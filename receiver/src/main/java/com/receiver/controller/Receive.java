package com.receiver.controller;

import com.receiver.listner.RListener;
import com.receiver.modal.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Receive {

    @Autowired
    private RListener msgListen;

    @GetMapping("/receive")
    public List<Message> receive(){
        return msgListen.storeMsg;
    }
}
