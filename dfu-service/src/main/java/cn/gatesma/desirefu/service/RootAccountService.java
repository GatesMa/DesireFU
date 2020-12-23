package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.domain.api.generate.AddOSSAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.AddRootAccountRequest;
import cn.gatesma.desirefu.repository.OssAccountRepository;
import cn.gatesma.desirefu.repository.RootAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * User: gatesma
 * Date: 2020/12/22 1:28 下午
 * Desc:
 */
@Service
public class RootAccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RootAccountService.class);

    @Resource
    private RootAccountRepository rootAccountRepository;

    @Resource
    private AccountService accountService;


    public Long createRootAccount(AddRootAccountRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();

        // 1. 先创建一个common账号
        long accountId = accountService.createAccount(request);

        // 2. 创建一个RootAccount表记录
        rootAccountRepository.addRootAccount(accountId, accountType, rootUserId);

        return accountId;
    }

}
