package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.status.AccountStatus;
import cn.gatesma.desirefu.constants.status.ApprovalStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.MessageType;
import cn.gatesma.desirefu.constants.type.OperatorRole;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.UpdateAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.UpdateAccountRet;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Accountuserrole_Record;
import cn.gatesma.desirefu.repository.AccountRepository;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User: gatesma
 * Date: 2020-11-29
 * Desc:
 */
@Service
public class AccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private AccountUserRoleRepository accountUserRoleRepository;

    @Resource
    private MessageService messageService;

    /**
     * 创建一个 Account_ 表记录，并绑定rootUserId跟account的关系
     */
    public Long createAccount(AddAccountRequest request) {

        Timestamp now = TimeUtils.now();
        Integer accountType = request.getAccountType();
        String nickName = request.getNickName();
        String memo = request.getMemo();
        Long rootUserId = request.getRootUserId();

        // 创建账号
        long accountId = accountRepository.addAccount(accountType, nickName,
                AccountStatus.STATUS_PENDING.code(), ApprovalStatus.PENDING.code(), memo, 0L,
                StringUtils.EMPTY, null, rootUserId, now, DeleteStatus.NORMAL.code(), rootUserId, now);

        // 创建账号和user的角色关系
        accountUserRoleRepository.addAccountUserRole(accountId, accountType, rootUserId, OperatorRole.ROLE_ROOT.code(),
                DeleteStatus.NORMAL.code(), rootUserId, rootUserId);

        return accountId;
    }

    /**
     * 通过账号列表获取账号名称的map
     */
    public Map<Long, String> getAccountNameMap(List<Long> accountIds) {


        if (CollectionUtils.isEmpty(accountIds)) {
            return null;
        }

        List<Account_Record> records = accountRepository.batchGetAccountById(accountIds);

        if (CollectionUtils.isNotEmpty(records)) {
            return records.stream().collect(Collectors.toMap(Account_Record::getAccountid,
                    Account_Record::getNickname));
        } else {
            return null;
        }
    }

    /**
     * 通过账号列表获取账号record
     */
    public Map<Long, Account_Record> getAccountRecordMap(List<Long> accountIds) {


        if (CollectionUtils.isEmpty(accountIds)) {
            return null;
        }

        List<Account_Record> records = accountRepository.batchGetAccountById(accountIds);

        if (CollectionUtils.isNotEmpty(records)) {
            return records.stream().collect(Collectors.toMap(Account_Record::getAccountid,
                    it -> it));
        } else {
            return null;
        }
    }


    /**
     * 获取Account
     */
//    public GetAccountRet getAccount(String name, String ministry, String identification) {
//
//        List<Account_Record> records = collegeRepository.queryAccount(name, ministry, identification);
//
//        List<Account> ret = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(records)) {
//            for (Account_Record record : records) {
//                Account college = new Account().collegeId(record.getAccountid())
//                        .name(record.getName())
//                        .ministry(record.getMinistry())
//                        .identification(record.getIdentification())
//                        .location(record.getLocation())
//                        .level(record.getLevel())
//                        .memo(record.getMemo())
//                        .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()))
//                        .lastModifiedTime(TimeUtils.convertDateToString(record.getLastmodifiedtime(), TimeFmt.getTimeFmt()));
//                ret.add(college);
//            }
//        }
//        // 返回结果
//        return (GetAccountRet) new GetAccountRet().data(ret)
//                .code(ApiReturnCode.OK.code())
//                .message(ApiReturnCode.OK.name());
//    }

    public UpdateAccountRet updateAccount(UpdateAccountRequest request) {

        if (request.getAccountId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数不对");
        }

        accountRepository.updateAccount(request.getAccountId(), request.getAccountStatus(), request.getNickName(), request.getMemo());

        return (UpdateAccountRet) new UpdateAccountRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());

    }

}
