package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.status.MessageStatus;
import cn.gatesma.desirefu.domain.api.generate.Page;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Message_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountapplication_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.MESSAGE_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ORGANIZEACCOUNTAPPLICATION_;

/**
 * User: gatesma
 * Date: 2021/2/7 12:38 下午
 * Desc:
 */
@Repository
public class MessageRepository {


    @Resource
    private DSLContext dslContext;

    /**
     * ID GET
     */
    public Message_Record getMessageById(long id) {
        SelectConditionStep<Message_Record> stmt = dslContext
                .selectFrom(MESSAGE_)
                .where(MESSAGE_.ID.eq(id))
                .and(MESSAGE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }

    public List<Message_Record> queryMessage(Integer type, Integer status, Long accountId, Page page) {
        SelectConditionStep<Message_Record> stmt = dslContext
                .selectFrom(MESSAGE_)
                .where(MESSAGE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (type != null) {
            stmt.and(MESSAGE_.TYPE.eq(type));
        }
        if (status != null) {
            stmt.and(MESSAGE_.STATUS.eq(status));
        }
        if (accountId != null) {
            stmt.and(MESSAGE_.ACCOUNTID.eq(accountId));
        }
        // 翻页
        if (page != null) {
            stmt.limit(page.getPageSize()).offset(page.getPageSize() * (page.getPageNum() - 1));
        }

        // 按时间倒序
        stmt.orderBy(MESSAGE_.CREATEDTIME.desc());
        return stmt.fetch();
    }

    /**
     * 新增Message
     */
    public int addMessage(Integer type, Integer status, Long accountId, String content) {

        Timestamp createdTime = TimeUtils.now();

        return dslContext
                .insertInto(
                        MESSAGE_,
                        MESSAGE_.ACCOUNTID,
                        MESSAGE_.TYPE,
                        MESSAGE_.CONTENT,
                        MESSAGE_.STATUS,
                        MESSAGE_.CREATEDTIME,
                        MESSAGE_.LASTMODIFIEDTIME,
                        MESSAGE_.DELETESTATUS
                )
                .values(
                        accountId,
                        type,
                        content,
                        status,
                        createdTime,
                        createdTime,
                        DeleteStatus.NORMAL.code()
                ).execute();
    }


    /**
     * 删除Message_表数据
     */
    public int deleteMessage(List<Long> ids) {

        UpdateSetMoreStep<Message_Record> step = dslContext.update(MESSAGE_)
                .set(MESSAGE_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(MESSAGE_.ID.in(ids)).execute();
    }

    /**
     * 更新状态
     */
    public int updateMessageStatus(List<Long> ids, Integer status) {
        Timestamp modifiedTime = TimeUtils.now();
        UpdateSetMoreStep<Message_Record> stmt = dslContext.update(MESSAGE_)
                .set(MESSAGE_.LASTMODIFIEDTIME, modifiedTime)
                .set(MESSAGE_.STATUS, status);

        return stmt.where(MESSAGE_.ID.in(ids))
                .and(MESSAGE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()))
                .execute();
    }

    /**
     * 把accountId的全部消息设为已读
     * @param accountId
     */
    public int updateAllMessageStatus(Long accountId) {
        Timestamp modifiedTime = TimeUtils.now();
        UpdateSetMoreStep<Message_Record> stmt = dslContext.update(MESSAGE_)
                .set(MESSAGE_.LASTMODIFIEDTIME, modifiedTime)
                .set(MESSAGE_.STATUS, MessageStatus.READ.code());

        return stmt.where(MESSAGE_.ACCOUNTID.eq(accountId))
                .and(MESSAGE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()))
                .and(MESSAGE_.STATUS.eq(MessageStatus.NOT_READ.code()))
                .execute();
    }



}
