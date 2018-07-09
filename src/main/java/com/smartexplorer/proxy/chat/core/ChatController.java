package com.smartexplorer.proxy.chat.core;

import com.smartexplorer.proxy.chat.model.ChatMessage;
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

    @MessageMapping("/local")
    @SendTo("/topic/local")
    public ChatMessage chatMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

}
