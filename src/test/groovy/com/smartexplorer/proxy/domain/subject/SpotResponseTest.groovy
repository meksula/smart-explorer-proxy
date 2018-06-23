package com.smartexplorer.proxy.domain.subject

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

/**
 * @Author
 * Karol Meksuła
 * 17-06-2018
 * */

class SpotResponseTest extends Specification {
    private String spotId = "ich398433fdn4d3m4"
    private String name = "Muzeum Lubelskie"
    private String description = "Muzeum prezentujące dzieje lubelszczyzny."
    private String integratedAddress = "Lublin, aleja Tysiąclecia 21"
    private double ratesAvg = 4.3
    private String pictureUri = "http://api.somelink/api/v1/pic/ich398433fdn4d3m4"
    private List<String> recentOpinions = ["Wspaniałe miejsce pamięci historycznej", "Każdy musi tu być!"]
    private double longitude = 32.34235552
    private double latitude = 24.442245235

    def 'spotResponseBuilder and json serialize test'() {
        setup:
        def response = new SpotResponse.SpotResponseBuilder()
                .spotId(spotId).name(name)
                .description(description)
                .integratedAddress(integratedAddress)
                .ratesAvg(ratesAvg)
                .pictureUri(pictureUri)
                .recentOpinions(recentOpinions)
                .longitude(longitude)
                .latitude(latitude)
                .build()

        when: 'serialize'
        def json = new ObjectMapper().writeValueAsString(response)

        then:
        json == "{\"spotId\":\"ich398433fdn4d3m4\",\"name\":\"Muzeum Lubelskie\"," +
                "\"description\":\"Muzeum prezentujące dzieje lubelszczyzny.\",\"integratedAddress\":\"Lublin, aleja Tysiąclecia 21\"," +
                "\"ratesAvg\":4.3,\"pictureUri\":\"http://api.somelink/api/v1/pic/ich398433fdn4d3m4\"," +
                "\"recentOpinions\":[\"Wspaniałe miejsce pamięci historycznej\"," +
                "\"Każdy musi tu być!\"],\"longitude\":32.34235552,\"latitude\":24.442245235}"
    }
}
