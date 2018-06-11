package com.smartexplorer.domain.mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mail.javamail.JavaMailSender
import org.thymeleaf.TemplateEngine
import spock.lang.Specification

/**
 * @Author
 * Karol Meksuła
 * 11-06-2018
 * */

@SpringBootTest
class TemplateMailSenderTest extends Specification {

    @Autowired
    private JavaMailSender javaMailSender

    @Autowired
    private TemplateEngine templateEngine

    def 'email sending integration test'() {
        setup:
        def sut = new TemplateMailSender(javaMailSender: javaMailSender, templateEngine: templateEngine)

        sut.sendMail(MailType.REGISTER_CONFIRM, new MailReceiver() {
            @Override
            String getEmail() {
                return "karol.meksula@onet.pl"
            }
        })

    }

}
