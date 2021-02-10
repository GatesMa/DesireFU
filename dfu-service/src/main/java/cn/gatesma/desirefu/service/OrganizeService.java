package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.status.OrganizeApplicationStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.constants.type.MessageType;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organize_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountapplication_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountrelation_Record;
import cn.gatesma.desirefu.repository.*;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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


    public Long createOrganize(AddOrganizeRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();
        Long competitionId = request.getCompetitionId();
        Long srcAccountId = request.getSrcAccountId();

        // 1. 先创建一个common账号 , 这个accountId等于Organize表中的organizeId
        long accountId = accountService.createAccount(request);

        // 2. 创建一个 Organize 表记录
        organizeRepository.addOrganize(accountId, competitionId, srcAccountId, rootUserId);

        // 3. 为队长创建记录
        organizeAccountRelationRepository.addOrganizeAccountRelation(accountId, srcAccountId, AccountType.ORGANIZE.getValue(), 1, rootUserId);

        return accountId;
    }

    public ListOrganizeRet list(ListOrganizeRequest request) {

        List<OrganizeData> data = new ArrayList<>();
        
        // 通过这几个参数在Organize表中找
        List<Organize_Record> organizeRecords = organizeRepository
                .queryOrganize(request.getOrganizeId(), request.getCompetitionId(), request.getSrcAccountId());

        for (Organize_Record organizeRecord : organizeRecords) {
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

}
