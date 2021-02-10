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
import cn.gatesma.desirefu.repository.AccountRepository;
import cn.gatesma.desirefu.repository.OrganizeAccountApplicationRepository;
import cn.gatesma.desirefu.repository.OrganizeAccountRelationRepository;
import cn.gatesma.desirefu.repository.OrganizeRepository;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: gatesma
 * Date: 2021/02/02 2:55 下午
 * Desc:
 */
@Service
public class OrganizeApplicationService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrganizeApplicationService.class);

    @Resource
    private OrganizeAccountApplicationRepository organizeAccountApplicationRepository;

    @Resource
    private NormalAccountService normalAccountService;

    @Resource
    private OrganizeService organizeService;

    @Resource
    private OrganizeRepository organizeRepository;

    @Resource
    private MessageService messageService;

    private final static Integer DEFAULT_PAGE = 1;
    private final static Integer DEFAULT_PAGE_SIZE = 10;


    public AddOrganizeApplicationRet createOrganizeApplication(AddOrganizeApplicationRequest request) {

        Long organizeId = request.getOrganizeId();
        Long accountId = request.getAccountId();
        Integer accountType = request.getAccountType();
        Long createdUserId = request.getCreatedUserId();
        // 判断是否存在已经发起的请求
        List<Organizeaccountapplication_Record> records = organizeAccountApplicationRepository.queryOrganizeAccountApplication(
                Collections.singletonList(organizeId), accountId, accountType, OrganizeApplicationStatus.APPLYING.code());

        if (CollectionUtils.isNotEmpty(records)) {
            return (AddOrganizeApplicationRet) new AddOrganizeApplicationRet()
                    .code(ApiReturnCode.LOGIC_ERROR.code())
                    .message("存在未处理申请");
        } else {
            // 创建一个申请记录
            organizeAccountApplicationRepository.addOrganizeAccountApplication(organizeId, accountId,
                    accountType, OrganizeApplicationStatus.APPLYING.code(), createdUserId);

            // 向队长发送一条消息
            sendMessageToCaptain(organizeId, accountId);


            return RetCodeUtils.ok(new AddOrganizeApplicationRet());
        }
    }

    private void sendMessageToCaptain(Long organizeId, Long accountId) {
        //  获取队伍信息
        OrganizeData organize = organizeService.getOrganizeById(organizeId);
        GetNormalAccountData account = normalAccountService.getNormalAccountById(accountId);

        String name = account.getCollegeName() + account.getDepartmentName() + account.getMajor() + account.getRealName();

        String content = "用户：" + name + "(ID: " + account.getAccountId() + ")"
                + ", 想要加入你的队伍：" + organize.getNickName()
                + ", 请到审批列表页面进行审批。";

        messageService.sendMessage(organize.getSrcAccountId(), MessageType.JOIN_ORGANIZE.getValue(), content);

    }

    public SelectOrganizeApplicationRet list(SelectOrganizeApplicationRequest request) {

        List<SelectOrganizeApplicationData> data = new ArrayList<>();

        // 通过队长id筛选队伍
        List<Long> organizeIds = new ArrayList<>();
        if (request.getCaptainAccountId() != null) {
            List<Organize_Record> organizes = organizeRepository.getOrganizeListBySrcAccountId(request.getCaptainAccountId());
            if (CollectionUtils.isNotEmpty(organizes)) {
                organizeIds = organizes.stream().map(Organize_Record::getOrganizeid).collect(Collectors.toList());
            }
        } else {
            if (request.getOrganizeId() != null) {
                organizeIds.add(request.getOrganizeId());
            }
        }

        // 通过这几个参数在OrganizeApplication表中找
        List<Organizeaccountapplication_Record> records = organizeAccountApplicationRepository.queryOrganizeAccountApplication(
                organizeIds,
                request.getAccountId(),
                request.getAccountType(),
                request.getStatus());

        for (Organizeaccountapplication_Record record : records) {
            SelectOrganizeApplicationData item = new SelectOrganizeApplicationData();
            item.setId(record.getId());
            item.setOrganizeId(record.getOrganizeid());
            item.setAccountId(record.getAccountid());
            item.setAccountType(record.getAccounttype());
            item.setStatus(record.getStatus());
            item.setCreatedTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));
            
            // 设置申请人的信息
            GetNormalAccountData applicant = normalAccountService.getNormalAccountById(record.getAccountid());
            item.setApplicant(applicant);

            // 设置队伍信息
            OrganizeData organize = organizeService.getOrganizeById(record.getOrganizeid());
            item.setOrganize(organize);

            data.add(item);
        }

        // 返回结果
        return (SelectOrganizeApplicationRet) new SelectOrganizeApplicationRet().data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

}
