package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.NotificationStatus;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Notification_Record;
import cn.gatesma.desirefu.repository.DepartmentRepository;
import cn.gatesma.desirefu.repository.NotificationRepository;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gatesma
 * Date: 2021/1/22 10:51 下午
 * Desc:
 */
@Service
public class NotificationService {

    @Resource
    private NotificationRepository notificationRepository;

    public AddNotificationRet addNotification(AddNotificationRequest request) {

        // 直接调用repository的方法创建
        int noticeId = notificationRepository.addNotification(request.getType(), request.getFrontImg(), NotificationStatus.NORMAL.code(), request.getContent());

        List<Notification_Record> records = notificationRepository.queryNotification(noticeId, null, null);
        List<SelectNotificationData> dataList = toSelectNotificationData(records);

        // 返回结果
        return (AddNotificationRet) new AddNotificationRet()
                .data(CollectionUtils.isNotEmpty(dataList) ? dataList.get(0) : null)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    public SelectNotificationRet selectNotification(SelectNotificationRequest request) {

        SelectNotificationRet ret = RetCodeUtils.ok(new SelectNotificationRet());

        List<Notification_Record> records = notificationRepository.queryNotification(request.getNoticeId(), request.getType(), request.getStatus());

        SelectNotificationRetData data = new SelectNotificationRetData();
        data.setList(toSelectNotificationData(records));

        ret.setData(data);

        return ret;
    }

    private List<SelectNotificationData> toSelectNotificationData(List<Notification_Record> records) {

        List<SelectNotificationData> ret = new ArrayList<>();
        for (Notification_Record record : records) {
            SelectNotificationData item = new SelectNotificationData()
                    .noticeId(record.getNoticeid())
                    .type(record.getType())
                    .frontImg(record.getFrontimg())
                    .status(record.getStatus())
                    .content(record.getContent());
            ret.add(item);
        }
        return ret;
    }


    public DeleteNotificationRet deleteNotification(DeleteNotificationRequest request) {
        if (request.getNoticeId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数不对");
        }
        notificationRepository.deleteNotification(request.getNoticeId());
        return (DeleteNotificationRet) new DeleteNotificationRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }



}
