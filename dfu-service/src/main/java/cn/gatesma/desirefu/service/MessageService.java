package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.MessageStatus;
import cn.gatesma.desirefu.constants.status.NotificationStatus;
import cn.gatesma.desirefu.constants.status.OrganizeApplicationStatus;
import cn.gatesma.desirefu.constants.type.MessageType;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Message_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Notification_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountapplication_Record;
import cn.gatesma.desirefu.repository.MessageRepository;
import cn.gatesma.desirefu.repository.NotificationRepository;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gatesma
 * Date: 2021/2/8 10:51
 * Desc:
 */
@Service
public class MessageService {

    @Resource
    private MessageRepository messageRepository;

    private final static Integer DEFAULT_PAGE = 1;
    private final static Integer DEFAULT_PAGE_SIZE = 10;

    public SelectMessageRet selectMessage(SelectMessageRequest request) {

        SelectMessageRet ret = RetCodeUtils.ok(new SelectMessageRet());

        // page信息
        fillPage(request);


        Long accountId = request.getAccountId();
        Integer type = request.getType();
        Integer status = request.getStatus();

        List<Message_Record> records = messageRepository.queryMessage(type, status, accountId, request.getPage());

        ret.setData(toSelectMessageData(records));

        return ret;
    }

    private List<SelectMessageData> toSelectMessageData(List<Message_Record> records) {

        List<SelectMessageData> ret = new ArrayList<>();
        for (Message_Record record : records) {
            SelectMessageData item = new SelectMessageData()
                    .id(record.getId())
                    .accountId(record.getAccountid())
                    .type(record.getType())
                    .title(MessageType.parseValToMsg(record.getType()))
                    .status(record.getStatus())
                    .content(record.getContent())
                    .createdTime(TimeUtils.convertDateToString(record.getCreatedtime(), TimeFmt.getTimeFmt()));
            ret.add(item);
        }
        return ret;
    }

    private void fillPage(SelectMessageRequest request) {
        // 如果page是空，填充默认值
        if (request.getPage() == null) {
            Page page = new Page().pageNum(DEFAULT_PAGE).pageSize(DEFAULT_PAGE_SIZE);
            request.setPage(page);
        } else {
            if (request.getPage().getPageNum() == null) {
                request.getPage().setPageNum(DEFAULT_PAGE);
            }
            if (request.getPage().getPageSize() == null) {
                request.getPage().setPageSize(DEFAULT_PAGE_SIZE);
            }
        }
    }

    /**
     * 更新申请的状态
     */
    public UpdateMessageStatusRet updateStatus(UpdateMessageStatusRequest request) {

        if (CollectionUtils.isNotEmpty(request.getIds())) {
            messageRepository.updateMessageStatus(request.getIds(), request.getStatus());
        }

        // 返回结果
        return (UpdateMessageStatusRet) new UpdateMessageStatusRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 删除消息
     */
    public DeleteMessageRet deleteMessage(DeleteMessageRequest request) {

        if (CollectionUtils.isNotEmpty(request.getIds())) {
            messageRepository.deleteMessage(request.getIds());
        }

        // 返回结果
        return (DeleteMessageRet) new DeleteMessageRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 更新全部消息为已读
     */
    public ReadAllMessageRet readAllMessage(ReadAllMessageRequest request) {

        if (request.getAccountId() != null) {
            messageRepository.updateAllMessageStatus(request.getAccountId());
        }

        // 返回结果
        return (ReadAllMessageRet) new ReadAllMessageRet()
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    public void sendMessage(Long accountId, Integer type, String content) {
        //
        if (accountId == null) {
            return;
        }
        messageRepository.addMessage(type, MessageStatus.NOT_READ.code(), accountId, content);
    }



}
