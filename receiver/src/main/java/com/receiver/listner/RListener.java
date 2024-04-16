package com.receiver.listner;


import com.receiver.config.RabbitMq;
import com.receiver.modal.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RListener {

    public List<Message> storeMsg = new ArrayList<>();

    @RabbitListener(queues = RabbitMq.MSGQUEUE)
    public void listenMessage(Message m){
        this.storeMsg.add(m);
    }
}
