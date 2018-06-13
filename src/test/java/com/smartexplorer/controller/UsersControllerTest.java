package com.smartexplorer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartexplorer.domain.subject.spotmaker.SpotMakerForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@WithMockUser(username = "user1", password = "pwd", roles = "USER")
public class UsersControllerTest {

    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    public void setMessageConverter(HttpMessageConverter<?>[] convs) {
        mappingJackson2HttpMessageConverter = Arrays.stream(convs)
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);
    }

    private MockMvc mockMvc;

    private SpotMakerForm form;
    private String username = "AdamK200";
    private String password = "qwertyuiop";
    private String name = "Adam";
    private String surname = "Kowalski";
    private String email = "kowalski.adam@gmail.com";
    private int age = 46;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();

        form = new SpotMakerForm(username, password, name, surname, email, age);
    }

    @Test
    public void spotMakerRegistrationIntegrationTest() throws Exception {
        mockMvc.perform(put("/api/v1/user/spotmaker")
                .accept(mediaType)
                .contentType(mediaType)
                .content(new ObjectMapper().writeValueAsString(form)))
                .andDo(print());
    }

    @After
    public void tearDown() throws Exception {
    }
}