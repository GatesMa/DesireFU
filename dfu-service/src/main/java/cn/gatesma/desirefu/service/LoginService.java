package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.constants.type.MessageType;
import cn.gatesma.desirefu.constants.type.OperatorRole;
import cn.gatesma.desirefu.constants.type.PlatformType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Accountuserrole_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Message_Record;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.utils.AccountUtils;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
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

    private final static Integer DEFAULT_PAGE = 1;
    private final static Integer DEFAULT_PAGE_SIZE = 10;


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
                , userId, null, DeleteStatus.NORMAL.code(), null);

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

    public AddRoleRelationRet addRoleRelation(AddRoleRelationRequest request) {


        if (request.getAccountId() == null || request.getRole() == null || request.getUserId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数有误");
        }

        List<Accountuserrole_Record> records =
                accountUserRoleRepository.queryRoleRelation(request.getAccountId(), request.getAccountType(), request.getUserId(),
                        null, DeleteStatus.NORMAL.code(), null);

        // 如果没有记录才添加
        if (CollectionUtils.isEmpty(records)) {
            // 创建账号和user的角色关系
            accountUserRoleRepository.addAccountUserRole(request.getAccountId(), request.getAccountType() == null ? 0 : request.getAccountType(),
                    request.getUserId(), request.getRole(), DeleteStatus.NORMAL.code(), request.getUserId(), request.getUserId());
        }

        // 返回结果
        return (AddRoleRelationRet) new AddRoleRelationRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());

    }

    public SelectRoleRelationRet selectRoleRelation(SelectRoleRelationRequest request) {
        SelectRoleRelationRet ret = RetCodeUtils.ok(new SelectRoleRelationRet());

        // page信息
        fillPage(request);


        Long accountId = request.getAccountId();
        Integer role = request.getRole();
        Long userId = request.getUserId();

        List<Accountuserrole_Record> records =
                accountUserRoleRepository.queryRoleRelation(accountId, null, userId, role, DeleteStatus.NORMAL.code(), request.getPage());


        ret.setData(toSelectData(records));

        return ret;
    }

    private List<SelectRoleRelationData> toSelectData(List<Accountuserrole_Record> records) {

        List<SelectRoleRelationData> ret = new ArrayList<>();
        for (Accountuserrole_Record record : records) {
            SelectRoleRelationData item = new SelectRoleRelationData()
                    .accountRoleId(record.getAccountroleid())
                    .accountId(record.getAccountid())
                    .userId(record.getUserid())
                    .role(record.getRole())
                    .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));
            ret.add(item);
        }
        return ret;
    }

    private void fillPage(SelectRoleRelationRequest request) {
        // 如果page是空，填充默认值
        if (request.getPage() == null) {
            Page page = new Page().pageNum(DEFAULT_PAGE).pageSize(DEFAULT_PAGE_SIZE);
            request.setPage(page);
        } else {
            if (request.getPage().getPageNum() == null) {
                request.getPage().setPageNum(DEFAULT_PAGE);
            }
            if (request.getPage().getPageSize() == null) {
                request.getPage().setPageSize(DEFAULT_PAGE_SIZE);
            }
        }
    }

    public DeleteRoleRelationRet deleteRoleRelation(DeleteRoleRelationRequest request) {

        if (request.getAccountRoleId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数有误");
        }

        accountUserRoleRepository.deleteRoleRelation(request.getAccountRoleId());

        // 返回结果
        return (DeleteRoleRelationRet) new DeleteRoleRelationRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }


}
