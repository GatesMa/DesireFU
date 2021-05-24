package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constant.EsConst;
import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.*;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.constants.type.OperatorRole;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.*;
import cn.gatesma.desirefu.repository.*;
import cn.gatesma.desirefu.utils.JsonUtil;
import cn.gatesma.desirefu.utils.TimeUtils;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.lang.Object;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.termsQuery;

/**
 * User: gatesma
 * Date: 2020-12-06
 * Desc:
 */
@Service
public class NormalAccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(NormalAccountService.class);

    @Resource
    private NormalAccountRepository normalAccountRepository;

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private AccountService accountService;

    @Resource
    private CollegeRepository collegeRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private DepartmentRepository departmentRepository;

    @Resource
    private OrganizeRepository organizeRepository;

    @Resource
    private OrganizeAccountApplicationRepository organizeAccountApplicationRepository;

    @Resource
    private OrganizeAccountRelationRepository organizeAccountRelationRepository;

    @Resource
    private CollectRepository collectRepository;

    @Resource
    private EsService esService;


    @Resource
    private AccountUserRoleRepository accountUserRoleRepository;

    public Long createNormalAccount(AddNormalAccountRequest request) {

        Integer accountType = request.getAccountType();
        Integer collegeId = request.getCollegeId();
        Integer departmentId = request.getDepartmentId();
        String major = request.getMajor();
        @NotNull Long rootUserId = request.getRootUserId();
        String stuId = request.getStuId();
        String realName = request.getRealName();


        // 1. 先创建一个common账号
        long accountId = accountService.createAccount(request);

        // 2. 创建一个NormalAccount表记录
        normalAccountRepository.addNormalAccount(accountId, accountType, collegeId, departmentId, major, stuId, realName, rootUserId);

        return accountId;
    }


    /**
     * 获取Account
     */
    public GetNormalAccountRet  get(GetNormalAccountRequest request) {
        // 查数据库
//        List<Normalaccount_Record> records = normalAccountRepository.queryNormalAccount(
//                request.getAccountId(), request.getCollegeId(), request.getDepartmentId(), request.getMajor(), request.getStuId(), request.getRealName());
//
//        List<GetNormalAccountData> ret = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(records)) {
//            ret = toGetNormalAccountList(records);
//        }

        // 查es
        List<GetNormalAccountData> ret = getNormalAccountFromES(request);
        // 返回结果
        return (GetNormalAccountRet) new GetNormalAccountRet().data(ret)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 获取Account
     */
    public GetNormalAccountRet getFromDBWithData(GetNormalAccountRequest request) {
        List<GetNormalAccountData> fromDB = getFromDB(request);
        // 返回结果
        return (GetNormalAccountRet) new GetNormalAccountRet().data(fromDB)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 获取Account
     */
    public List<GetNormalAccountData> getFromDB(GetNormalAccountRequest request) {
        // 查数据库
        List<Normalaccount_Record> records = normalAccountRepository.queryNormalAccount(
                request.getAccountId(), request.getCollegeId(), request.getDepartmentId(), request.getMajor(), request.getStuId(), request.getRealName());

        List<GetNormalAccountData> ret = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(records)) {
            ret = toGetNormalAccountList(records);
        }
        return ret;
    }

    public GetNormalAccountData getNormalAccountById(Long accountId) {

        Normalaccount_Record record = normalAccountRepository.getAccountById(accountId, DeleteStatus.NORMAL);

        if (record == null) {
            return null;
        }

        GetNormalAccountData data = new GetNormalAccountData()
                .accountId(record.getAccountid())
                .accountType(record.getAccounttype())
                .collegeId(record.getCollegeid())
                .departmentId(record.getDepartmentid())
                .major(record.getMajor())
                .stuId(record.getStuid())
                .realName(record.getRealname())
                .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));

        // 填充学校名称和学院名称
        College_Record college = collegeRepository.getCollegeById(record.getCollegeid(), DeleteStatus.NORMAL);
        if (college != null) {
            data.setCollegeName(college.getName());
        }
        Department_Record department = departmentRepository.getDepartmentById(record.getDepartmentid(), DeleteStatus.NORMAL);
        if (department != null) {
            data.setDepartmentName(department.getName());
        }

        return data;

    }

    public GetExamAccountRet getExamList() {

        // 1。 获取全部的未审核的学生账号
        List<Account_Record> records = accountRepository.getExamAccount(AccountType.NORMAL.getValue());

        if (CollectionUtils.isEmpty(records)) {
            // 返回结果
            return (GetExamAccountRet) new GetExamAccountRet()
                    .code(ApiReturnCode.OK.code())
                    .message(ApiReturnCode.OK.name());
        }

        // 2。通过ids查找normal record
        List<Normalaccount_Record> accountByIds =
                normalAccountRepository.getAccountByIds(records.stream().map(Account_Record::getAccountid).collect(Collectors.toList()));

        List<GetNormalAccountData> getNormalAccountData = toGetNormalAccountList(accountByIds);


        // 返回结果
        return (GetExamAccountRet) new GetExamAccountRet()
                .data(getNormalAccountData)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());

    }


    private List<GetNormalAccountData> toGetNormalAccountList(List<Normalaccount_Record> records) {
        List<GetNormalAccountData> ret = new ArrayList<>();
        for (Normalaccount_Record record : records) {
            GetNormalAccountData data = new GetNormalAccountData()
                    .accountId(record.getAccountid())
                    .accountType(record.getAccounttype())
                    .collegeId(record.getCollegeid())
                    .departmentId(record.getDepartmentid())
                    .major(record.getMajor())
                    .stuId(record.getStuid())
                    .realName(record.getRealname())
                    .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));

            // 填充学校名称和学院名称
            College_Record college = collegeRepository.getCollegeById(record.getCollegeid(), DeleteStatus.NORMAL);
            if (college != null) {
                data.setCollegeName(college.getName());
            }
            Department_Record department = departmentRepository.getDepartmentById(record.getDepartmentid(), DeleteStatus.NORMAL);
            if (department != null) {
                data.setDepartmentName(department.getName());
            }
            ret.add(data);
        }
        return ret;
    }

    public GetNormalBasicDataRet getNormalBasicData(GetNormalBasicDataRequest request) {

        if (request.getAccountId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数不对");
        }

        Integer msgCnt = 0, applicationCnt = 0, organizeCnt, collectCnt;


        // 消息数量
        List<Message_Record> messageRecords
                = messageRepository.queryMessage(null, MessageStatus.NOT_READ.code(), request.getAccountId(), null);
        msgCnt = messageRecords.size();

        // 入队申请
        // 通过队长id筛选队伍
        List<Long> organizeIds = new ArrayList<>();
        List<Organize_Record> organizes = organizeRepository.getOrganizeListBySrcAccountId(request.getAccountId());
        if (CollectionUtils.isNotEmpty(organizes)) {
            organizeIds = organizes.stream().map(Organize_Record::getOrganizeid).collect(Collectors.toList());
        }

        // 通过这几个参数在OrganizeApplication表中找
        List<Organizeaccountapplication_Record> accountApplication = organizeAccountApplicationRepository.queryOrganizeAccountApplication(
                organizeIds, null, null, OrganizeApplicationStatus.APPLYING.code());
        applicationCnt = accountApplication.size();

        // 队伍数量
        List<Organizeaccountrelation_Record> organizeRecords =
                organizeAccountRelationRepository.queryOrganizeAccountRelation(null, request.getAccountId(), null, null);
        organizeCnt = organizeRecords.size();

        // 收藏
        List<Collect_Record> collectRecords = collectRepository.queryCollectByAccountId(request.getAccountId(), null, null);
        collectCnt = collectRecords.size();


        GetNormalBasicDataData data = new GetNormalBasicDataData()
                .applicationCnt(applicationCnt)
                .collectCnt(collectCnt)
                .msgCnt(msgCnt)
                .organizeCnt(organizeCnt);
        // 返回结果
        return (GetNormalBasicDataRet) new GetNormalBasicDataRet()
                .data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }


    // 出现错误降级查DB
    @SentinelResource(value = "getNormalAccountFromES", fallback = "getFromDB")
    public List<GetNormalAccountData> getNormalAccountFromES(GetNormalAccountRequest request) {

        if (request.getAccountId()== 1L) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数不对");
        }

        // 根据request生成queryBuilder
        BoolQueryBuilder queryBuilder = getBoolQueryBuilder(request);

        // 返回查询结果, 默认最多500
        SearchResponse searchResponse = esService.queryFromES(EsConst.DESIREFU_SERVICE_INDEX, EsConst.INDEX_TYPE_NORMAL_ACCOUNT,
                queryBuilder, null, null, 0, 500);

        return toAccountData(searchResponse);
    }

    private List<GetNormalAccountData> toAccountData(SearchResponse response) {
        List<GetNormalAccountData> accounts = new LinkedList<GetNormalAccountData>();
        if (null != response) {
            SearchHits searchHits = response.getHits();
            SearchHit[] hits = searchHits.getHits();
            // 获取需要的字段
            for (SearchHit hit : hits) {
                String source = hit.getSourceAsString();
                GetNormalAccountData accountData = JsonUtil.deSerialize(source, GetNormalAccountData.class);
                if (null != accountData) {
                    accounts.add(accountData);
                }
            }
        }
        return accounts;
    }


    private BoolQueryBuilder getBoolQueryBuilder(GetNormalAccountRequest request) {

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        // account_id 查询条件
        if (request.getAccountId() != null) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "_id", request.getAccountId()
                    )
            );
        }

        // college_id 查询条件
        if (request.getCollegeId() != null) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "collegeId", request.getCollegeId()
                    )
            );
        }

        // departmentId 查询条件
        if (request.getDepartmentId() != null) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "departmentId", request.getDepartmentId()
                    )
            );
        }

        // major 查询条件
        if (StringUtils.isNotBlank(request.getMajor())) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "major", request.getMajor()
                    )
            );
        }

        // stuId 查询条件
        if (StringUtils.isNotBlank(request.getStuId())) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "stuId", request.getStuId()
                    )
            );
        }

        // realName 查询条件
        if (StringUtils.isNotBlank(request.getRealName())) {
            queryBuilder.must(
                    QueryBuilders.termQuery(
                            "realName", request.getRealName()
                    )
            );
        }

        return queryBuilder;
    }


    public void syncAccount(Long accountId) {
        boolean success = false;

        GetNormalAccountData account = getNormalAccountById(accountId);

        if (account == null) {
            return;
        }

        String json = JSONObject.toJSONString(account, SerializerFeature.WriteMapNullValue);
        Map<String, Object> dataMap = JSONObject.parseObject(json);

        // 更新ES
        UpdateResponse response = esService.upsertNormalAccount(accountId, dataMap);

        if (response != null) {
            success = true;
            LOGGER.info("pushAccountToEs success , accountType = {}, accountId = {}", account.getAccountType(), accountId);
        }

        if (!success) {
            LOGGER.error("pushAccountToEs error, accountId = {}", accountId);
        }

    }




}
