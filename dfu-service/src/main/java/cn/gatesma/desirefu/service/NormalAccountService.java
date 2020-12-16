package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.status.AccountStatus;
import cn.gatesma.desirefu.constants.status.ApprovalStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.OperatorRole;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.AddNormalAccountRequest;
import cn.gatesma.desirefu.repository.AccountRepository;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

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
    private AccountService accountService;

    @Resource
    private AccountUserRoleRepository accountUserRoleRepository;

    public Long createNormalAccount(AddNormalAccountRequest request) {

        Integer accountType = request.getAccountType();
        Integer collegeId = request.getCollegeId();
        Integer departmentId = request.getDepartmentId();
        String major = request.getMajor();
        @NotNull Long rootUserId = request.getRootUserId();
        String stuId = request.getStuId();


        // 1. 先创建一个common账号
        long accountId = accountService.createAccount(request);

        // 2. 创建一个NormalAccount表记录
        normalAccountRepository.addNormalAccount(accountId, accountType, collegeId, departmentId, major, stuId, rootUserId);

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
