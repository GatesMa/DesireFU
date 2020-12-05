package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.status.AccountStatus;
import cn.gatesma.desirefu.constants.status.ApprovalStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Accountuserrole_Record;
import cn.gatesma.desirefu.repository.AccountRepository;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

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
        accountUserRoleRepository.addAccountUserRole(accountId, accountType, rootUserId, 10,
                DeleteStatus.NORMAL.code(), rootUserId, rootUserId);

        return accountId;
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

}
