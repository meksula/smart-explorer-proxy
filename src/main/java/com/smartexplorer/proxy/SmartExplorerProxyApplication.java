package com.smartexplorer;

import com.smartexplorer.configuration.security.OpenBeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Import;

/**
 * @Author
 * Karol Meksuła
 * 07-06-2018
 * */

//@EnableOAuth2Sso
@Import(OpenBeanConfig.class)
@SpringBootApplication
public class SmartExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartExplorerApplication.class, args);
    }

}
