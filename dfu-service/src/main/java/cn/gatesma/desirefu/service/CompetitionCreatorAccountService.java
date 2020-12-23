package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.domain.api.generate.AddCompetitionCreatorAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.AddNormalAccountRequest;
import cn.gatesma.desirefu.repository.AccountUserRoleRepository;
import cn.gatesma.desirefu.repository.CompetitionCreatorAccountRepository;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

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


}
