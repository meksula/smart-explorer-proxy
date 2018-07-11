package com.smartexplorer.proxy.chat.core;

import com.smartexplorer.proxy.chat.model.ChatMessage;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author
 * Karol Meksuła
 * 09-07-2018
 * */

@Controller
public class ChatController {
    private Queue queue;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/local-chat")
    public ChatMessage chatMessage(@Payload ChatMessage chatMessage) {
        rabbitTemplate.convertAndSend(queue.getName(), chatMessage);

        return chatMessage;
    }

}
