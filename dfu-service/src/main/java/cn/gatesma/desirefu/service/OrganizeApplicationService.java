package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.status.OrganizeApplicationStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
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
import java.util.List;

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

    private final static Integer DEFAULT_PAGE = 1;
    private final static Integer DEFAULT_PAGE_SIZE = 10;


    public AddOrganizeApplicationRet createOrganizeApplication(AddOrganizeApplicationRequest request) {

        Long organizeId = request.getOrganizeId();
        Long accountId = request.getAccountId();
        Integer accountType = request.getAccountType();
        Long createdUserId = request.getCreatedUserId();
        // 判断是否存在已经发起的请求
        List<Organizeaccountapplication_Record> records = organizeAccountApplicationRepository.queryOrganizeAccountApplication(
                organizeId, accountId, accountType, OrganizeApplicationStatus.APPLYING.code(), null);

        if (CollectionUtils.isNotEmpty(records)) {
            return (AddOrganizeApplicationRet) new AddOrganizeApplicationRet()
                    .code(ApiReturnCode.LOGIC_ERROR.code())
                    .message("存在未处理申请");
        } else {
            // 创建一个申请记录
            organizeAccountApplicationRepository.addOrganizeAccountApplication(organizeId, accountId,
                    accountType, OrganizeApplicationStatus.APPLYING.code(), createdUserId);
            return RetCodeUtils.ok(new AddOrganizeApplicationRet());
        }
    }

    public SelectOrganizeApplicationRet list(SelectOrganizeApplicationRequest request) {

        fillPage(request);

        List<SelectOrganizeApplicationData> data = new ArrayList<>();

        // 通过这几个参数在OrganizeApplication表中找
        List<Organizeaccountapplication_Record> records = organizeAccountApplicationRepository.queryOrganizeAccountApplication(
                request.getOrganizeId(),
                request.getAccountId(),
                request.getAccountType(),
                request.getStatus(),
                request.getPage());

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

    private void fillPage(SelectOrganizeApplicationRequest request) {
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

}
