package com.notification.service;

import com.notification.model.Message;

import java.util.List;

public interface MessageService {

    Message addMessage(Message message);

    List<Message> findMessageBySenderUser(String id);

    List<Message> findMessageByReceiverUser(String id);


}
