package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.domain.api.generate.AddOSSAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.AddOrganizeRequest;
import cn.gatesma.desirefu.repository.OrganizeRepository;
import cn.gatesma.desirefu.repository.OssAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * User: gatesma
 * Date: 2021/01/30 1:24 下午
 * Desc:
 */
@Service
public class OrganizeService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrganizeService.class);

    @Resource
    private OrganizeRepository organizeRepository;

    @Resource
    private AccountService accountService;


    public Long createOrganize(AddOrganizeRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();
        Long competitionId = request.getCompetitionId();
        Long srcAccountId = request.getSrcAccountId();

        // 1. 先创建一个common账号 , 这个accountId等于Organize表中的organizeId
        long accountId = accountService.createAccount(request);

        // 2. 创建一个 Organize 表记录
        organizeRepository.addOrganize(accountId, competitionId, srcAccountId, rootUserId);

        return accountId;
    }

}
