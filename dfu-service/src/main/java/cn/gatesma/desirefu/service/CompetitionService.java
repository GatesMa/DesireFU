package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.constants.type.MessageType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Collect_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Message_Record;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.CollectRepository;
import cn.gatesma.desirefu.repository.CompetitionRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.service.ratelimit.RateLimiterMethodService;
import cn.gatesma.desirefu.utils.HtmlUtils;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @Resource
    private CollectRepository collectRepository;

    @Resource
    private RateLimiterMethodService rateLimiterMethodService;

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

        // 限流
        // queryRateLimit(request);

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

    public SelectCompetitionData getCompetitionById(Long competitionId) {
        if (competitionId == null) {
            return null;
        }
        Competition_Record record = competitionRepository.getCompetitionById(competitionId, DeleteStatus.NORMAL);
        SelectCompetitionData data = new SelectCompetitionData()
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
        return data;
    }

    public void queryRateLimit(SelectCompetitionRequest request){
        // 检查限流，一分钟20次
        // TODO 配置改成动态修改
        rateLimiterMethodService.rateLimitQuery(20);
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

    public CollectCompetitionRet collectCompetition(CollectCompetitionRequest request) {
        if (request.getLike() == null || request.getAccountId() == null || request.getCompetitionId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数不对");
        }
        if (request.getLike() == 0) {
            // 看看是否有记录，如果有记录，删了
            collectRepository.deleteCollect(request.getAccountId(), request.getCompetitionId());
        } else {
            // 看看是否有记录，没有的话插入
            List<Collect_Record> records = collectRepository.queryCollectByAccountId(request.getAccountId(), request.getCompetitionId(), null);
            if (CollectionUtils.isEmpty(records)) {
                collectRepository.addCollect(request.getAccountId(), request.getCompetitionId());
            }
        }
        // 返回结果
        return (CollectCompetitionRet) new CollectCompetitionRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    public GetCollectCompetitionRet getCollectCompetition(GetCollectCompetitionRequest request) {

        GetCollectCompetitionRet ret = RetCodeUtils.ok(new GetCollectCompetitionRet());

        // page信息
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


        Long accountId = request.getAccountId();

        List<Collect_Record> records = collectRepository.queryCollectByAccountId(accountId, null, request.getPage());

        ret.setData(toSelectData(records));

        return ret;

    }

    private List<GetCollectCompetitionData> toSelectData(List<Collect_Record> records) {

        List<GetCollectCompetitionData> ret = new ArrayList<>();

        if (CollectionUtils.isEmpty(records)) {
            return ret;
        }

        for (Collect_Record record : records) {
            SelectCompetitionData competitionById = getCompetitionById(record.getCompetitionid());
            GetCollectCompetitionData item = new GetCollectCompetitionData();
            item.setCompetition(competitionById);
            item.setAccountId(record.getAccountid());
            item.setCompetitionId(record.getCompetitionid());
            item.setCreatedTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));
            ret.add(item);
        }

        return ret;
    }

    public CheckCollectCompetitionRet checkCollectCompetition(CheckCollectCompetitionRequest request) {
        if (request.getAccountId() == null || request.getCompetitionId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数不对");
        }
        List<Collect_Record> collect_records = collectRepository.queryCollectByAccountId(request.getAccountId(), request.getCompetitionId(), null);
        CheckCollectCompetitionData data = new CheckCollectCompetitionData();
        if (CollectionUtils.isEmpty(collect_records)) {
            data.isLiked(0);
        } else {
            data.isLiked(1);
        }

        // 返回结果
        return (CheckCollectCompetitionRet) new CheckCollectCompetitionRet()
                .data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

}
