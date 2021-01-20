package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.status.AccountStatus;
import cn.gatesma.desirefu.constants.status.ApprovalStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.OperatorRole;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.College_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Department_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.repository.*;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    private CollegeRepository collegeRepository;

    @Resource
    private DepartmentRepository departmentRepository;


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
    public GetNormalAccountRet get(GetNormalAccountRequest request) {

        List<Normalaccount_Record> records = normalAccountRepository.queryNormalAccount(
                request.getAccountId(), request.getCollegeId(), request.getDepartmentId(), request.getMajor(), request.getStuId(), request.getRealName());

        List<GetNormalAccountData> ret = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(records)) {
            for (Normalaccount_Record record : records) {
                GetNormalAccountData data = new GetNormalAccountData()
                        .accountId(record.getAccountid())
                        .accountType(record.getAccounttype())
                        .collegeId(record.getCollegeid())
                        .departmentId(record.getDepartmentid())
                        .major(record.getMajor())
                        .stuId(record.getStuid())
                        .realName(record.getRealname());

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
        }
        // 返回结果
        return (GetNormalAccountRet) new GetNormalAccountRet().data(ret)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

}
