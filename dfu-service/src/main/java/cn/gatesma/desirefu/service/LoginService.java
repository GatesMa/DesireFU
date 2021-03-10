package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.constants.type.OperatorRole;
import cn.gatesma.desirefu.constants.type.PlatformType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Accountuserrole_Record;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.utils.AccountUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gatesma
 * @date: 2020-12-13
 * @desc
 */
@Service
public class LoginService {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private UserService userService;

    @Resource
    private AccountService accountService;

    @Resource
    private AccountUserRoleRepository accountUserRoleRepository;

    public CanLoginAccountRet getCanLoginAccount(CanLoginAccountRequest request) {

        String loginName = request.getLoginName();
        Integer loginNameType = request.getLoginNameType();
        Long userId = request.getUserId();

        // 先获取userId
        if (userId == null) {
            Login login = new Login()
                    .loginName(loginName)
                    .loginNameType(loginNameType);
            GetUserRet user = userService.getUser(login);
            if (user == null || user.getData() == null) {
                throw new CustomerApiException(ApiReturnCode.USER_NOT_EXISTED, "用户不存在");
            }
            userId = user.getData().getUserId();
        }

        // 通过userId获取user可以登录的账号以及角色

        List<Accountuserrole_Record> records = accountUserRoleRepository.queryRoleRelation(null, null
                , userId, null, DeleteStatus.NORMAL.code());

        return roleRecordsToRetData(records);
    }


    private CanLoginAccountRet roleRecordsToRetData(List<Accountuserrole_Record> records) {
        CanLoginAccountRet ret = new CanLoginAccountRet();

        if (CollectionUtils.isEmpty(records)) {
            ret.code(ApiReturnCode.OK.code())
                    .message(ApiReturnCode.OK.name());
            return ret;
        }

        List<Long> accountIds = records.stream().map(Accountuserrole_Record::getAccountid).collect(Collectors.toList());

        Map<Long, Account_Record> accountRecordMap = accountService.getAccountRecordMap(accountIds);

        // 保存accountType的账号列表
        Map<Integer, CanLoginAccountData> map = Maps.newHashMap();

        for (Accountuserrole_Record record : records) {
            // 先生成账号item
            CanLoginAccountItem item = new CanLoginAccountItem();
            item.setAccountId(record.getAccountid());
            item.setAccountType(record.getAccounttype());
            item.setRole(record.getRole());
            item.setRoleName(OperatorRole.parseCodeToVal(record.getRole()));

            Account_Record account_record = accountRecordMap.get(record.getAccountid());
            if (account_record != null) {
                item.setAccountName(account_record.getNickname());
                item.setAccountStatus(account_record.getAccountstatus());
                item.setAccountStatusStr(AccountUtils.accountStatusToStr(account_record.getAccountstatus()));
            }

            // 已经包含该类型账号列表
            if (map.containsKey(record.getAccounttype())) {
                CanLoginAccountData data = map.get(record.getAccounttype());
                data.getAccountList().add(item);
            } else {
                // 如果不包含就生成一个新的列表
                CanLoginAccountData data = new CanLoginAccountData();
                data.setPlatformType(record.getAccounttype());
                data.setPlatform(PlatformType.getDescByValue(record.getAccounttype()));

                List<CanLoginAccountItem> itemList = Lists.newArrayList();
                data.setAccountList(itemList);
                itemList.add(item);

                map.put(record.getAccounttype(), data);
            }
        }
        List<CanLoginAccountData> list = new ArrayList<>(map.values());
        // 按type以小到大排序
        list.sort(new Comparator<CanLoginAccountData>() {
            @Override
            public int compare(CanLoginAccountData o1, CanLoginAccountData o2) {
                return o1.getPlatformType().compareTo(o2.getPlatformType());
            }
        });
        ret.data(list)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
        return ret;
    }


}
