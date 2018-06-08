package com.smartexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @Author
 * Karol Meksuła
 * 07-06-2018
 * */

@EnableOAuth2Sso
@SpringBootApplication
public class SmartExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartExplorerApplication.class, args);
    }
}
