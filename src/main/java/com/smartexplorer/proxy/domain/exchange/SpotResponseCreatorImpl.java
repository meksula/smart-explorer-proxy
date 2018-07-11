package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.SpotInformation;
import com.smartexplorer.proxy.domain.subject.SpotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author Karol Meksuła
 * 24-06-2018
 */

@Service
public class SpotResponseCreatorImpl implements SpotResponseCreator {
    private OpinionsRequestCommand opinionsRequestCommand;
    private RestTemplate restTemplate;

    @Autowired
    public void setOpinionsRequestCommand(OpinionsRequestCommand opinionsRequestCommand) {
        this.opinionsRequestCommand = opinionsRequestCommand;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${hostname}")
    private String hostname;

    @Override
    public SpotResponse createSpotResponse(Map responseValues) {
        String spotId = (String) responseValues.get("id");

        return new SpotResponse.SpotResponseBuilder()
                .spotId(spotId)
                .name((String) responseValues.get("name"))
                .description((String) responseValues.get("description"))
                .integratedAddress(responseValues.get("city") + ", ul. " + responseValues.get("street") + " " + responseValues.get("buildingNumber"))
                .ratesAvg(opinionsRequestCommand.getAvgRate(spotId))
                .recentOpinions(opinionsRequestCommand.getLatestOpinion(spotId, 5).orElse(null))
                .pictureUri(hostname + "/api/v1/spot/" + responseValues.get("id"))
                .longitude((Double) responseValues.get("longitude"))
                .latitude((Double) responseValues.get("latitude"))
                .build();
    }

    @Override
    public SpotResponse createDetailedSpotResponse(Map responseValues) {
        SpotResponse spotResponse = createSpotResponse(responseValues);
        spotResponse.setOpenNow(isOpenNowRequest(spotResponse.getSpotId()));
        spotResponse.setSpotInformation(spotInformationRequest(spotResponse.getSpotId()));

        return spotResponse;
    }

    private boolean isOpenNowRequest(String spotId) {
        return restTemplate.getForEntity(hostname + "/api/v1/spot/exploration/" + spotId + "/visitable",
                Boolean.class).getBody();
    }

    private SpotInformation spotInformationRequest(String spotId) {
        return restTemplate.getForEntity(hostname + "/api/v1/spot/info/" + spotId, SpotInformation.class).getBody();
    }

}
