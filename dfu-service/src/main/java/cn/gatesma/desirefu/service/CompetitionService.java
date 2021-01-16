package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.CompetitionRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.utils.HtmlUtils;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gatesma
 * Date: 2020-12-29
 * Desc:
 */
@Service
public class CompetitionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompetitionService.class);

    private final static Integer DEFAULT_PAGE = 1;
    private final static Integer DEFAULT_PAGE_SIZE = 10;
    private final static String DEFAULT_SORT_FIELD = "pv";
    private final static String DEFAULT_SORT_TYPE = "desc";

    @Resource
    private CompetitionRepository competitionRepository;

    public void createCompetition(AddCompetitionRequest request) {

        checkParam(request);

        // 如果概览文本是空的，从正文中提取文字
        if (StringUtils.isBlank(request.getOverviewText())) {
            fillOverviewText(request);
        }

        competitionRepository.addCompetition(
                request.getAccountId(),
                request.getAccountType(),
                request.getType(),
                request.getTitle(),
                request.getFounder(),
                request.getContent(),
                request.getStatus(),
                TimeUtils.convertStringToTimestamp(request.getBeginTime()),
                TimeUtils.convertStringToTimestamp(request.getEndTime()),
                request.getUserId(),
                request.getOverviewImg(),
                request.getOverviewText());

    }

    private void fillOverviewText(AddCompetitionRequest request) {
        // 正文提取文本
        if (StringUtils.isBlank(request.getContent())) {
            request.setOverviewText(StringUtils.EMPTY);
        } else {
            String htmlStr = HtmlUtils.html2Str(request.getContent());
            htmlStr = htmlStr.substring(0, 100) + "...";
            request.setOverviewText(htmlStr);
        }
    }

    public SelectCompetitionRet selectCompetition(SelectCompetitionRequest request) {

        SelectCompetitionRet ret = RetCodeUtils.ok(new SelectCompetitionRet());;

        // page信息
        fillPage(request);

        if (StringUtils.isBlank(request.getSortField())) {
            request.setSortField(DEFAULT_SORT_FIELD);
        }

        if (StringUtils.isBlank(request.getSortSeq())) {
            request.setSortSeq(DEFAULT_SORT_TYPE);
        }

        List<Competition_Record> records = competitionRepository.queryCompetition(
                request.getCompetitionIds(),
                request.getAccountId(),
                request.getType(),
                request.getTitle(),
                request.getFounder(),
                request.getStatus(),
                request.getState(),
                request.getSortField(),
                request.getSortSeq(),
                request.getPage());

        SelectCompetitionRetData data = new SelectCompetitionRetData();
        data.setList(toSelectCompetitionData(records));

        ret.setData(data);

        return ret;
    }

    private List<SelectCompetitionData> toSelectCompetitionData(List<Competition_Record> records) {

        List<SelectCompetitionData> ret = new ArrayList<>();
        for (Competition_Record record : records) {
            SelectCompetitionData item = new SelectCompetitionData()
                    .competitionId(record.getCompetitionid())
                    .accountId(record.getAccountid())
                    .accountType(record.getAccounttype())
                    .type(record.getType())
                    .title(record.getTitle())
                    .founder(record.getFounder())
                    .content(record.getContent())
                    .pv(record.getPv())
                    .status(record.getStatus())
                    .beginTime(TimeUtils.convertDateToString(record.getBegintime(), TimeFmt.getTimeFmt()))
                    .endTime(TimeUtils.convertDateToString(record.getEndtime(), TimeFmt.getTimeFmt()))
                    .createdIme(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()))
                    .overviewImg(record.getOverviewimg())
                    .overviewText(record.getOverviewtext());
            ret.add(item);
        }
        return ret;
    }

    private void fillPage(SelectCompetitionRequest request) {
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


    private void checkParam(AddCompetitionRequest request) {

        if (request.getUserId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "userId必须传");
        }

        if (request.getAccountType() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型必须传");
        }

        // 校验accountType
        if (!AccountType.COMPETITION_CREATOR.getValue().equals(request.getAccountType())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "非比赛创建者账号无法创建比赛");
        }

        if (request.getType() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "比赛类型没传");
        }

        if (StringUtils.isBlank(request.getTitle())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "比赛名称没传");
        }

    }

}
