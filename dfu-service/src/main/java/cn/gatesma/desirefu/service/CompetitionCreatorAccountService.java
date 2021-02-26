package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.status.CompetitionStatus;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.CompetitionCreatorAccountRepository;
import cn.gatesma.desirefu.repository.CompetitionRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * User: gatesma
 * Date: 2020/12/22 1:22 下午
 * Desc:
 */
@Service
public class CompetitionCreatorAccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompetitionCreatorAccountService.class);

    @Resource
    private CompetitionCreatorAccountRepository competitionCreatorAccountRepository;

    @Resource
    private AccountService accountService;

    @Resource
    private CompetitionRepository competitionRepository;


    public Long createCompetitionCreatorAccount(AddCompetitionCreatorAccountRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();
        String author = request.getAuthor();


        // 1. 先创建一个common账号
        long accountId = accountService.createAccount(request);

        // 2. 创建一个NormalAccount表记录
        competitionCreatorAccountRepository.addCompetitionCreatorAccount(accountId, accountType, author, rootUserId);

        return accountId;
    }


    public GetCompetitionBasicDataRet getCompetitionBasicData(GetCompetitionBasicDataRequest request) {

        if (request.getAccountId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "accountId必须传");
        }

        List<Competition_Record> records = competitionRepository.queryCompetition(request.getAccountId());

        int allCnt = 0, validCnt = 0, pv = 0, notStartCnt = 0, startCnt = 0, endCnt = 0;

        Timestamp now = TimeUtils.now();

        for (Competition_Record record : records) {
            allCnt++;
            validCnt += record.getStatus() == CompetitionStatus.NORMAL.code() ? 1 : 0;
            pv += record.getPv();

            if (record.getBegintime().after(now)) {
                notStartCnt++;
            } else if (record.getEndtime().after(now)) {
                startCnt++;
            } else {
                endCnt++;
            }
        }
        GetCompetitionBasicDataData data = new GetCompetitionBasicDataData();
        data.allCnt(allCnt).validCnt(validCnt).pv(pv)
                .notStartCnt(notStartCnt).startCnt(startCnt).endCnt(endCnt);
        // 返回结果
        return (GetCompetitionBasicDataRet) new GetCompetitionBasicDataRet().data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }





}
