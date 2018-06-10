package com.smartexplorer.domain.subject

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

class SpotMakerTest extends Specification {
    private String spotMakerId = "dg454ec63f22"
    private String principalNumber = "9928494849848"
    private String username = "Clerifly"
    private String password = "445rfcgv"
    private String name = "Cler"
    private String surname = "Abrevee"
    private String email = "cl.abrevee@gmail.com"
    private int age = 34

    def 'dto creation and JSON serialization test'() {
        setup:
        def spotMaker = new SpotMaker()
        spotMaker.setSpotMakerId(spotMakerId)
        spotMaker.setPrincipalNumber(principalNumber)
        spotMaker.setUsername(username)
        spotMaker.setPassword(password)
        spotMaker.setName(name)
        spotMaker.setSurname(surname)
        spotMaker.setEmail(email)
        spotMaker.setAge(age)

        when:
        def json = new ObjectMapper().writeValueAsString(spotMaker)

        then:
        json.equals("{\"spotMakerId\":\"dg454ec63f22\",\"confirmed\":false,\"principalNumber\":\"9928494849848\",\"username\":\"Clerifly\",\"password\":\"445rfcgv\",\"name\":\"Cler\",\"surname\":\"Abrevee\",\"email\":\"cl.abrevee@gmail.com\",\"age\":34}")
    }

}
