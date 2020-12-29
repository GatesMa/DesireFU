package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.AddCompetitionRequest;
import cn.gatesma.desirefu.domain.api.generate.AddNormalAccountRequest;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.CompetitionRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * User: gatesma
 * Date: 2020-12-29
 * Desc:
 */
@Service
public class CompetitionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompetitionService.class);

    @Resource
    private CompetitionRepository competitionRepository;

    public void createCompetition(AddCompetitionRequest request) {

        checkParam(request);

        competitionRepository.addCompetition(
                request.getAccountId(),
                request.getAccountType(),
                request.getType(),
                request.getTitle(),
                request.getFounder(),
                request.getContent(),
                TimeUtils.convertStringToTimestamp(request.getBeginTime()),
                TimeUtils.convertStringToTimestamp(request.getEndTime()),
                request.getUserId());

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
