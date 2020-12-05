package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.College_Record;
import cn.gatesma.desirefu.repository.CollegeRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
@Service
public class CollegeService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CollegeService.class);

    @Resource
    private CollegeRepository collegeRepository;

    public int createCollegeIfNotExisted(AddCollegeRequest request) {
        String identification = request.getIdentification();
        String name = request.getName();
        String memo = request.getMemo();
        String ministry = request.getMinistry();
        String level = request.getLevel();
        String location = request.getLocation();


        // 确保唯一标识不存在
        College_Record college = collegeRepository.getCollegeByIdentification(identification);
        if (college != null) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,
                    String.format("学校标识码已存在：collegeId=%s, name=%s", college.getCollegeid(), college.getName()));
        }
        return collegeRepository.addCollege(name, ministry, identification, location, level, memo);
    }


    /**
     * 获取College
     */
    public GetCollegeRet getCollege(String name, String ministry, String identification) {

        List<College_Record> records = collegeRepository.queryCollege(name, ministry, identification);

        List<College> ret = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(records)) {
            for (College_Record record : records) {
                College college = new College().collegeId(record.getCollegeid())
                        .name(record.getName())
                        .ministry(record.getMinistry())
                        .identification(record.getIdentification())
                        .location(record.getLocation())
                        .level(record.getLevel())
                        .memo(record.getMemo())
                        .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()))
                        .lastModifiedTime(TimeUtils.convertDateToString(record.getLastmodifiedtime(), TimeFmt.getTimeFmt()));
                ret.add(college);
            }
        }
        // 返回结果
        return (GetCollegeRet) new GetCollegeRet().data(ret)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

}
