package com.notification.controller;

import com.notification.model.Message;
import com.notification.model.User;
import com.notification.repository.MessageRepository;
import com.notification.repository.UserRepository;
import com.notification.service.MessageService;
import com.notification.service.MessageServiceImpl;
import com.notification.service.UserService;
import com.notification.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/message")
public class MessageController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    MessageServiceImpl messageServiceImpl;

    @PostMapping(value = "/sendmessage")
    public @ResponseBody String sendmessage(@RequestParam String sender, @RequestParam String message, @RequestParam String recevier){

            Message msg = new Message();
            msg.setMessage(message);
            msg.setCreatedAt(new Date());
            msg.setSenderId(sender);
            msg.setReceiverId(recevier);
            messageServiceImpl.addMessage(msg);

        return "message send successfully";
    }

    @GetMapping(value = "/getsendermessage")
    public @ResponseBody List<Message> getsendermessage(@RequestParam String senderEmail){
        List<Message> messages = messageServiceImpl.findMessageBySenderUser(senderEmail);
        return messages;
    }

    @GetMapping(value = "/getreceivermessage")
    public @ResponseBody List<Message> getreceivermessage(@RequestParam String receiverEmail){
        List<Message> messages = messageServiceImpl.findMessageByReceiverUser(receiverEmail);
        return messages;

    }
}
