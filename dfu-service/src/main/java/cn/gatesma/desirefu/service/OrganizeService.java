package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organize_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountrelation_Record;
import cn.gatesma.desirefu.repository.AccountRepository;
import cn.gatesma.desirefu.repository.OrganizeAccountRelationRepository;
import cn.gatesma.desirefu.repository.OrganizeRepository;
import cn.gatesma.desirefu.repository.OssAccountRepository;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private AccountRepository accountRepository;
    
    @Resource
    private NormalAccountService normalAccountService;

    @Resource
    private OrganizeAccountRelationRepository organizeAccountRelationRepository;


    public Long createOrganize(AddOrganizeRequest request) {

        Integer accountType = request.getAccountType();
        @NotNull Long rootUserId = request.getRootUserId();
        Long competitionId = request.getCompetitionId();
        Long srcAccountId = request.getSrcAccountId();

        // 1. 先创建一个common账号 , 这个accountId等于Organize表中的organizeId
        long accountId = accountService.createAccount(request);

        // 2. 创建一个 Organize 表记录
        organizeRepository.addOrganize(accountId, competitionId, srcAccountId, rootUserId);

        // 3. 为队长创建记录
        organizeAccountRelationRepository.addOrganizeAccountRelation(accountId, srcAccountId, AccountType.ORGANIZE.getValue(), 1, rootUserId);

        return accountId;
    }

    public ListOrganizeRet list(ListOrganizeRequest request) {

        List<OrganizeData> data = new ArrayList<>();
        
        // 通过这几个参数在Organize表中找
        List<Organize_Record> organizeRecords = organizeRepository
                .queryOrganize(request.getOrganizeId(), request.getCompetitionId(), request.getSrcAccountId());

        for (Organize_Record organizeRecord : organizeRecords) {
            OrganizeData item = new OrganizeData();
            item.setOrganizeId(organizeRecord.getOrganizeid());
            item.setCompetitionId(organizeRecord.getCompetitionid());
            item.setSrcAccountId(organizeRecord.getSrcaccountid());
            item.setCreatedIme(TimeUtils.convertDateToString(organizeRecord.getCreatedtime(), TimeFmt.getTimeFmt()));
            
            // 队伍名称：organizeId对应的nickName
            Account_Record account = accountRepository.getAccountById(organizeRecord.getOrganizeid(), DeleteStatus.NORMAL);
            if (account != null) {
                item.setNickName(account.getNickname());
            }
            
            // 队长信息，通过srcAccountId获取NormalAccount的数据
            GetNormalAccountData captain = normalAccountService.getNormalAccountById(organizeRecord.getSrcaccountid());
            item.setCaptain(captain);

            // 查找队伍有多少人
            List<Organizeaccountrelation_Record> relation =
                    organizeAccountRelationRepository.queryOrganizeAccountRelation(organizeRecord.getOrganizeid(), null, null, null);
            // 设置队伍人数
            item.setMemberNum(relation.size());
            data.add(item);
        }




        // 返回结果
        return (ListOrganizeRet) new ListOrganizeRet().data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

}
