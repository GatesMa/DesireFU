package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constant.EsConst;
import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.AccountStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.status.OrganizeApplicationStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.constants.type.MessageType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.*;
import cn.gatesma.desirefu.repository.*;
import cn.gatesma.desirefu.service.processor.BatchSyncOrganizeToEsProcessor;
import cn.gatesma.desirefu.utils.JsonUtil;
import cn.gatesma.desirefu.utils.TimeUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.lang.Object;
import java.util.*;
import java.util.stream.Collectors;

/**
 * User: gatesma
 * Date: 2021/01/30 1:24 下午
 * Desc:
 */
@Service
public class OrganizeService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrganizeService.class);

    @Resource
    private OrganizeRepository organizeRepository;

    @Resource
    private AccountService accountService;

    @Resource
    private AccountRepository accountRepository;
    
    @Resource
    private NormalAccountService normalAccountService;

    @Resource
    private OrganizeAccountRelationRepository organizeAccountRelationRepository;

    @Resource
    private OrganizeAccountApplicationRepository organizeAccountApplicationRepository;

    @Resource
    private CompetitionService competitionService;

    @Resource
    private OrganizeService organizeService;

    @Resource
    private MessageService messageService;

    @Resource
    private EsService esService;

    @Resource
    private BatchSyncOrganizeToEsProcessor syncOrganizeToEsProcessor;


    public Long createOrganize(AddOrganizeRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();
        Long competitionId = request.getCompetitionId();
        Long srcAccountId = request.getSrcAccountId();

        // 检查一下，目前一个账号只能创建一个队伍
        List<Organize_Record> records = organizeRepository.queryOrganize(null, competitionId, srcAccountId);
        if (CollectionUtils.isNotEmpty(records)) {
            throw new CustomerApiException(ApiReturnCode.LOGIC_ERROR, "一个账号只能创建一个比赛队伍");
        }

        // 1. 先创建一个common账号 , 这个accountId等于Organize表中的organizeId
        long accountId = accountService.createAccount(request);

        // 2. 创建一个 Organize 表记录
        organizeRepository.addOrganize(accountId, competitionId, srcAccountId, rootUserId);

        // 3. 为队长创建记录
        organizeAccountRelationRepository.addOrganizeAccountRelation(accountId, srcAccountId, AccountType.ORGANIZE.getValue(), 1, rootUserId);

        // 4。发送消息
        messageService.sendMessage(
                srcAccountId,
                MessageType.CREATE_ORGANIZE.getValue(),
                String.format("创建队伍（%s）成功， 请等待运营审核！", request.getNickName()));

        return accountId;
    }

    public ListOrganizeRet list(ListOrganizeRequest request) {

//        List<OrganizeData> data = new ArrayList<>();

        // 通过这几个参数在Organize表中找
//        List<Organize_Record> organizeRecords = organizeRepository
//                .queryOrganize(request.getOrganizeId(), request.getCompetitionId(), request.getSrcAccountId());
//
//        for (Organize_Record organizeRecord : organizeRecords) {
//            // 只返回状态是已审核通过的
//            Account_Record account = accountRepository.getAccountById(organizeRecord.getOrganizeid(), DeleteStatus.NORMAL);
//            if (account.getAccountstatus() != AccountStatus.STATUS_NORMAL.code()) {
//                continue;
//            }
//            // 调用抽取的公共方法
//            data.add(recordToOrganizeData(organizeRecord));
//        }

        List<OrganizeData> organizeFromES = getOrganizeFromES(request);

        // 返回结果
        return (ListOrganizeRet) new ListOrganizeRet().data(organizeFromES)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    public ListOrganizeRet listFromDB(ListOrganizeRequest request) {

        List<OrganizeData> data = new ArrayList<>();

        // 通过这几个参数在Organize表中找
        List<Organize_Record> organizeRecords = organizeRepository
                .queryOrganize(request.getOrganizeId(), request.getCompetitionId(), request.getSrcAccountId());

        for (Organize_Record organizeRecord : organizeRecords) {
            // 只返回状态是已审核通过的
            Account_Record account = accountRepository.getAccountById(organizeRecord.getOrganizeid(), DeleteStatus.NORMAL);
            if (account.getAccountstatus() != AccountStatus.STATUS_NORMAL.code()) {
                continue;
            }
            // 调用抽取的公共方法
            data.add(recordToOrganizeData(organizeRecord));
        }


        // 返回结果
        return (ListOrganizeRet) new ListOrganizeRet().data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 更新申请的状态
     */
    public UpdateOrganizeApplicationRet update(UpdateOrganizeApplicationRequest request) {

        organizeAccountApplicationRepository.updateApplication(request.getId(), request.getStatus(), request.getUserId());

        if (request.getStatus() == OrganizeApplicationStatus.PASSED.code()) {
            // 如果更新后的状态是通过，需要把这条记录的账号添加到队伍中去
            Organizeaccountapplication_Record record = organizeAccountApplicationRepository.getOrganizeAccountApplicationById(request.getId());

            addOrganizeRelation(record.getOrganizeid(), record.getAccountid(), record.getAccounttype(), request.getUserId());

            // 发送审批成功通知
            sendSuccessMessage(request.getId());

            // 更新ES信息
            syncOrganizeToEsProcessor.syncSubOrganizeToEs(Arrays.asList(record.getOrganizeid()));

        } else if (request.getStatus() == OrganizeApplicationStatus.REJECT.code()) {
            // 发送审批拒绝通知
            sendFailMessage(request.getId());
        }

        // 返回结果
        return (UpdateOrganizeApplicationRet) new UpdateOrganizeApplicationRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 发送审批失败的消息
     * @param id application的主键
     */
    private void sendFailMessage(Long id) {

        Organizeaccountapplication_Record application = organizeAccountApplicationRepository.getOrganizeAccountApplicationById(id);

        OrganizeData organize = organizeService.getOrganizeById(application.getOrganizeid());

        String content = "你申请加入的队伍：" + organize.getNickName() + "(ID: " + organize.getOrganizeId() + ")"
                + ", 该请求被队长拒绝！";

        messageService.sendMessage(application.getAccountid(), MessageType.JOIN_ORGANIZE_SUCCESS.getValue(), content);
    }

    /**
     * 发送审批成功的消息
     * @param id application的主键
     */
    private void sendSuccessMessage(Long id) {

        Organizeaccountapplication_Record application = organizeAccountApplicationRepository.getOrganizeAccountApplicationById(id);

        OrganizeData organize = organizeService.getOrganizeById(application.getOrganizeid());

        String content = "你申请加入的队伍：" + organize.getNickName() + "(ID: " + organize.getOrganizeId() + ")"
                + ", 该请求被队长审批通过，你已经是该队伍的成员了，可以到账号管理页面查看队伍信息！";

        messageService.sendMessage(application.getAccountid(), MessageType.JOIN_ORGANIZE_FAIL.getValue(), content);
    }

    // 把accountId添加到organizeId这个队伍中
    public void addOrganizeRelation(Long organizeId, Long accountId, Integer accountType, Long userId) {

        // 先看看是否已经在队伍里了
        List<Organizeaccountrelation_Record> records = organizeAccountRelationRepository.queryOrganizeAccountRelation(organizeId, accountId, null, null);
        if (CollectionUtils.isNotEmpty(records)) {
            // 已经存在记录了，不做处理
            return;
        }

        // 插入一条记录
        organizeAccountRelationRepository.addOrganizeAccountRelation(organizeId, accountId, accountType, 0, userId);
    }

    public OrganizeData getOrganizeById(Long organizeId) {
        if (organizeId == null) {
            return null;
        }
        Organize_Record record = organizeRepository.getOrganizeById(organizeId);

        return recordToOrganizeData(record);
    }

    private OrganizeData recordToOrganizeData(Organize_Record record) {
        OrganizeData item = new OrganizeData();
        item.setOrganizeId(record.getOrganizeid());
        item.setCompetitionId(record.getCompetitionid());
        item.setSrcAccountId(record.getSrcaccountid());
        item.setCreatedIme(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));

        // 队伍名称：organizeId对应的nickName
        Account_Record account = accountRepository.getAccountById(record.getOrganizeid(), DeleteStatus.NORMAL);
        if (account != null) {
            item.setNickName(account.getNickname());
        }

        // 队长信息，通过srcAccountId获取NormalAccount的数据
        GetNormalAccountData captain = normalAccountService.getNormalAccountById(record.getSrcaccountid());
        item.setCaptain(captain);

        // 查找队伍有多少人
        List<Organizeaccountrelation_Record> relation =
                organizeAccountRelationRepository.queryOrganizeAccountRelation(record.getOrganizeid(), null, null, null);
        // 设置队伍人数
        item.setMemberNum(relation.size());

        // 设置比赛数据
        item.setCompetition(competitionService.getCompetitionById(record.getCompetitionid()));
        return item;
    }

    public GetExamOrganizeRet getExamOrganizeList() {

        // 1。 获取全部的未审核的学生账号
        List<Account_Record> records = accountRepository.getExamAccount(AccountType.ORGANIZE.getValue());

        if (CollectionUtils.isEmpty(records)) {
            // 返回结果
            return (GetExamOrganizeRet) new GetExamOrganizeRet()
                    .code(ApiReturnCode.OK.code())
                    .message(ApiReturnCode.OK.name());
        }

        // 2。通过ids查找normal record
        List<Organize_Record> accountByIds =
                organizeRepository.getOrganizeByIds(records.stream().map(Account_Record::getAccountid).collect(Collectors.toList()));

        List<OrganizeData> data = new ArrayList<>();

        for (Organize_Record organizeRecord : accountByIds) {
            // 调用抽取的公共方法
            data.add(recordToOrganizeData(organizeRecord));
        }


        // 返回结果
        return (GetExamOrganizeRet) new GetExamOrganizeRet()
                .data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());

    }

    public ListOrganizeMemberRet listMember(ListOrganizeMemberRequest request) {

        if (request.getOrganizeId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "OrganizeId必须传");
        }

        // 1。 获取全部的账号ID
        List<Organizeaccountrelation_Record> records = organizeAccountRelationRepository.queryOrganizeAccountRelation(request.getOrganizeId(), null, null, null);

        List<GetNormalAccountData> data = new ArrayList<>();

        // 每一个账号添加到data里
        if (CollectionUtils.isNotEmpty(records)) {
            for (Organizeaccountrelation_Record record : records) {
                GetNormalAccountData item = normalAccountService.getNormalAccountById(record.getAccountid());
                item.createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));
                data.add(item);
            }
        }

        // 返回结果
        return (ListOrganizeMemberRet) new ListOrganizeMemberRet()
                .data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());

    }

    public List<OrganizeData> getOrganizeFromES(ListOrganizeRequest request) {


        // 根据request生成queryBuilder
        BoolQueryBuilder queryBuilder = getBoolQueryBuilder(request);

        // 返回查询结果, 默认最多500
        SearchResponse searchResponse = esService.queryFromES(EsConst.DESIREFU_SERVICE_INDEX, EsConst.INDEX_TYPE_ORGANIZE,
                queryBuilder, null, null, 0, 500);

        return toOrganizeData(searchResponse);
    }

    private List<OrganizeData> toOrganizeData(SearchResponse response) {
        List<OrganizeData> accounts = new LinkedList<>();
        if (null != response) {
            SearchHits searchHits = response.getHits();
            SearchHit[] hits = searchHits.getHits();
            // 获取需要的字段
            for (SearchHit hit : hits) {
                String source = hit.getSourceAsString();
                OrganizeData accountData = JsonUtil.deSerialize(source, OrganizeData.class);
                if (null != accountData) {
                    accounts.add(accountData);
                }
                // 队长的ID
                Long srcAccountId = accountData.getSrcAccountId();
                if (srcAccountId != null) {
                    // 获取队长信息
                    List<GetNormalAccountData> accountFromES = normalAccountService.getNormalAccountFromES(new GetNormalAccountRequest().accountId(srcAccountId));
                    if (CollectionUtils.isNotEmpty(accountFromES)) {
                        accountData.setCaptain(accountFromES.get(0));
                    }
                }
            }
        }
        return accounts;
    }

    private BoolQueryBuilder getBoolQueryBuilder(ListOrganizeRequest request) {

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        // account_id 查询条件
        if (request.getOrganizeId() != null) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "_id", request.getOrganizeId()
                    )
            );
        }

        // college_id 查询条件
        if (request.getCompetitionId() != null) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "competitionId", request.getCompetitionId()
                    )
            );
        }

        // departmentId 查询条件
        if (request.getSrcAccountId() != null) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "srcAccountId", request.getSrcAccountId()
                    )
            );
        }

        return queryBuilder;
    }


    public void syncOrganize(Long organizeId) {
        boolean success = false;

        if (organizeId == null) {
            return;
        }
        Organize_Record record = organizeRepository.getOrganizeById(organizeId);

        if (record == null) {
            return;
        }

        // ------------------------------------------------
        OrganizeData item = new OrganizeData();
        item.setOrganizeId(record.getOrganizeid());
        item.setCompetitionId(record.getCompetitionid());
        item.setSrcAccountId(record.getSrcaccountid());
        item.setCreatedIme(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));

        // 队伍名称：organizeId对应的nickName
        Account_Record account = accountRepository.getAccountById(record.getOrganizeid(), DeleteStatus.NORMAL);
        if (account != null) {
            item.setNickName(account.getNickname());
        }

        // 队长信息，通过srcAccountId获取NormalAccount的数据
//        GetNormalAccountData captain = normalAccountService.getNormalAccountById(record.getSrcaccountid());
//        item.setCaptain(captain);

        // 查找队伍有多少人
        List<Organizeaccountrelation_Record> relation =
                organizeAccountRelationRepository.queryOrganizeAccountRelation(record.getOrganizeid(), null, null, null);
        // 设置队伍人数
        item.setMemberNum(relation.size());

        // 设置比赛数据
        item.setCompetition(competitionService.getCompetitionById(record.getCompetitionid()));
        // ------------------------------------------------


        String json = JSONObject.toJSONString(item, SerializerFeature.WriteMapNullValue);
        Map<String, Object> dataMap = JSONObject.parseObject(json);

        // 更新ES
        UpdateResponse response = esService.upsertOrganize(organizeId, dataMap);

        if (response != null) {
            success = true;
            LOGGER.info("pushAccountToEs success , organizeId = {}", organizeId);
        }

        if (!success) {
            LOGGER.error("pushAccountToEs error, organizeId = {}", organizeId);
        }

    }

}
