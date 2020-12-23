package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.domain.api.generate.AddOSSAccountRequest;
import cn.gatesma.desirefu.repository.OssAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * User: gatesma
 * Date: 2020/12/22 1:24 下午
 * Desc:
 */
@Service
public class OssAccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OssAccountService.class);

    @Resource
    private OssAccountRepository ossAccountRepository;

    @Resource
    private AccountService accountService;


    public Long createOssAccount(AddOSSAccountRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();
        Integer type = request.getType();

        // 1. 先创建一个common账号
        long accountId = accountService.createAccount(request);

        // 2. 创建一个OssAccount表记录
        ossAccountRepository.addOssAccount(accountId, accountType, type, rootUserId);

        return accountId;
    }

}
