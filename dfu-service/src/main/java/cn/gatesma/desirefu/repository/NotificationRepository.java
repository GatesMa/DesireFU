package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Notification_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.NOTIFICATION_;

/**
 * User: gatesma
 * Date: 2021/1/22 10:38 下午
 * Desc:
 */
@Repository
public class NotificationRepository {


    @Resource
    private DSLContext dslContext;

    /**
     * 获取一个 Notification
     */
    public Notification_Record getNotificationById(int noticeId) {
        SelectConditionStep<Notification_Record> stmt = dslContext
                .selectFrom(NOTIFICATION_)
                .where(NOTIFICATION_.NOTICEID.eq(noticeId))
                .and(NOTIFICATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }


    public List<Notification_Record> queryNotification(Integer noticeId, Integer type, Integer status) {
        SelectConditionStep<Notification_Record> stmt = dslContext
                .selectFrom(NOTIFICATION_)
                .where(NOTIFICATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (noticeId != null) {
            stmt.and(NOTIFICATION_.NOTICEID.eq(noticeId));
        }
        if (type != null) {
            stmt.and(NOTIFICATION_.TYPE.eq(type));
        }
        if (status != null) {
            stmt.and(NOTIFICATION_.STATUS.eq(status));
        }
        return stmt.fetch();
    }

    /**
     * 新增Notification
     */
    public int addNotification(Integer type, String frontImg, Integer status, String content) {

        Timestamp createdTime = TimeUtils.now();

        Notification_Record record = dslContext
                .insertInto(
                        NOTIFICATION_,
                        NOTIFICATION_.TYPE,
                        NOTIFICATION_.FRONTIMG,
                        NOTIFICATION_.STATUS,
                        NOTIFICATION_.CONTENT,
                        NOTIFICATION_.CREATEDTIME,
                        NOTIFICATION_.LASTMODIFIEDTIME,
                        NOTIFICATION_.DELETESTATUS
                )
                .values(
                        type,
                        frontImg,
                        status,
                        content,
                        createdTime,
                        createdTime,
                        DeleteStatus.NORMAL.code()
                ).returning(NOTIFICATION_.NOTICEID).fetchOne();
        return record.getValue(NOTIFICATION_.NOTICEID);
    }


    /**
     * 删除Notification_表数据
     */
    public int deleteNotification(int noticeId) {

        UpdateSetMoreStep<Notification_Record> step = dslContext.update(NOTIFICATION_)
                .set(NOTIFICATION_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(NOTIFICATION_.NOTICEID.eq(noticeId)).execute();
    }


}
