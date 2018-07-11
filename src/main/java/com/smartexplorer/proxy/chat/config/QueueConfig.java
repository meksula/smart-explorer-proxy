package com.smartexplorer.proxy.chat.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author
 * Karol Meksuła
 * 10-07-2018
 * */

@Configuration
public class QueueConfig {
    private final String QUEUE = "chat";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

}
