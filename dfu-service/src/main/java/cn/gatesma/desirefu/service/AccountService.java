package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

//    public int createAccount(AddAccountRequest request) {
//
//        // 一个userId只能创建以root身份创建一个账号
//
//        // 确保唯一标识不存在
//        Account_Record college = accountRepository.getAccountByIdentification(identification);
//        if (college != null) {
//            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,
//                    String.format("学校标识码已存在：collegeId=%s, name=%s", college.getAccountid(), college.getName()));
//        }
//        return collegeRepository.addAccount(name, ministry, identification, location, level, memo);
//    }


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
