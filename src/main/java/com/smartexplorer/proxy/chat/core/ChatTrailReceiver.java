package com.smartexplorer.proxy.chat.core;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "chat")
public class ChatTrailReceiver {

    @RabbitHandler
    public void listenQueue(String message) {
        System.out.println(message);
    }

}
