package com.sender.controller;


import com.sender.config.RabbitMq;
import com.sender.modal.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message m){
        m.setMid(UUID.randomUUID().toString());
        m.setDate(new Date());
        rabbitTemplate.convertAndSend(RabbitMq.EXCHANGE,RabbitMq.ROUTINGKEY,m);
        return "Massage Send Successfully";
    }


}
