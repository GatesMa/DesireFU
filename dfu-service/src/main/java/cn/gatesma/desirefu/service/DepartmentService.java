package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.AddDepartmentRequest;
import cn.gatesma.desirefu.domain.api.generate.Department;
import cn.gatesma.desirefu.domain.api.generate.GetDepartmentRet;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Department_Record;
import cn.gatesma.desirefu.repository.DepartmentRepository;
import cn.gatesma.desirefu.repository.DepartmentRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.jooq.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gatesma
 * Date: 2020-11-28
 * Desc:
 */
@Service
public class DepartmentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Resource
    private DepartmentRepository departmentRepository;

    public int createDepartmentIfNotExisted(AddDepartmentRequest request) {
        String name = request.getName();
        Integer collegeId = request.getCollegeId();

        // 确保不存在
        List<Department_Record> records = departmentRepository.queryDepartment(null, name, collegeId);
        if (CollectionUtils.isNotEmpty(records)) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,
                    String.format("学院已存在：departmentId=%s", records.get(0).getDepartmentid()));
        }
        return departmentRepository.addDepartment(name, collegeId);
    }


    /**
     * 获取Department
     */
    public GetDepartmentRet getDepartment(Integer departmentId, String name, Integer collegeId) {

        if (departmentId == null && StringUtils.isBlank(name) && collegeId == null) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "参数不能全为空");
        }

        List<Department_Record> records = departmentRepository.queryDepartment(departmentId, name, collegeId);

        List<Department> ret = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(records)) {
            for (Department_Record record : records) {
                Department department = new Department()
                        .departmentId(record.getDepartmentid())
                        .collegeId(record.getCollegeid())
                        .name(record.getName())
                        .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()))
                        .lastModifiedTime(TimeUtils.convertDateToString(record.getLastmodifiedtime(), TimeFmt.getTimeFmt()));
                ret.add(department);
            }
        }
        // 返回结果
        return (GetDepartmentRet) new GetDepartmentRet().data(ret)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

}
