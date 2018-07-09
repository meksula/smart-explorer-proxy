package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.SpotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Karol Meksuła
 * 24-06-2018
 */

@Service
public class SpotResponseCreatorImpl implements SpotResponseCreator {
    private OpinionsRequestCommand opinionsRequestCommand;

    @Autowired
    public void setOpinionsRequestCommand(OpinionsRequestCommand opinionsRequestCommand) {
        this.opinionsRequestCommand = opinionsRequestCommand;
    }

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
                .pictureUri("http://localhost:8090/api/v1/spot/" + responseValues.get("id"))
                .longitude((Double) responseValues.get("longitude"))
                .latitude((Double) responseValues.get("latitude"))
                .build();
    }

}
