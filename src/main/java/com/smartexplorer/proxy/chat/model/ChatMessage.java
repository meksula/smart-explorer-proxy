package com.smartexplorer.proxy.chat.model;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalDateTime;

/**
 * @Author
 * Karol Meksuła
 * 09-07-2018
 * */

@Getter
@Setter
public class ChatMessage {
    private String author;
    private String date;
    private String content;

    public ChatMessage() {
        this.date = LocalDateTime.now().toString();
    }

}
