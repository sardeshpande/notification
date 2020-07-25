package com.notification.service;


import com.notification.model.Message;
import com.notification.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findMessageBySenderUser(String id) {
        return (List<Message>) messageRepository.findBysenderId(id);
    }

    @Override
    public List<Message> findMessageByReceiverUser(String id) {
        return (List<Message>) messageRepository.findByreceiverId(id);
    }
}
