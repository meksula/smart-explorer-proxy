package com.smartexplorer;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author
 * Karol Meksuła
 * 08-06-2018
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
public class SmartExplorerApplicationTests {

    @Value("${google.api.key}")
    private String key;

    private Logger logger = LogManager.getLogger();

    @Test
    public void contextLoads() {
        logger.info(key);
    }

}
