package com.smartexplorer.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.smartexplorer.domain.core.CustomPreferences
import com.smartexplorer.domain.core.PlaceFindCommandImpl
import com.smartexplorer.domain.core.RequestObject
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.util.NestedServletException
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GeolocationControllerTest extends Specification {

    @Shared
    private MockMvc mockMvc

    def setupSpec() {
        def placeFindCommand = new PlaceFindCommandImpl()
        def controller = new GeolocationController(placeFindCommand: placeFindCommand)
        mockMvc = standaloneSetup(controller).build()
    }

    def 'get nearest place to visit'() {
        setup:
        ObjectMapper objectMapper = new ObjectMapper()
        String json = objectMapper.writeValueAsString(
                new RequestObject(435, 34.44444, 34.5555, new CustomPreferences()))

        when:
        mockMvc.perform(post("/api/v1/geolocation/nearest")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
        then:
        thrown(NestedServletException)
    }

}
