package com.smartexplorer.proxy.domain.exchange;

import com.google.maps.model.LatLng;
import com.smartexplorer.proxy.domain.subject.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @Author Karol Meksuła
 * 23-06-2018
 */

@Service
public class OpinionsRequestCommandImpl implements OpinionsRequestCommand {
    private RestTemplate restTemplate;
    private OpinionCreator opinionCreator;

    @Qualifier("restConfigured")
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setOpinionCreator(OpinionCreator opinionCreator) {
        this.opinionCreator = opinionCreator;
    }

    @Override
    public Optional<Opinion> addOpinion(Opinion opinion) {
        HttpEntity<Opinion> entity = new HttpEntity<>(opinion);

        ResponseEntity<Opinion> responseEntity = restTemplate.exchange("http://localhost:8090/api/v1/spot/opinions",
                HttpMethod.POST, entity, Opinion.class);

        return Optional.of(responseEntity.getBody());
    }

    @Override
    public Optional<List<Opinion>> getLatestOpinion(String spotId, int amount) {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/opinions/latest/" + spotId + "/" + amount, List.class);

        List<Opinion> opinionList = new ArrayList<>();

        for (Object object : response.getBody()) {
            opinionList.add(opinionCreator.createOpinion((Map) object));
        }

        return Optional.of(opinionList);
    }

    @Override
    public Optional<List<Opinion>> getBestOpinion(String spotId, int amount) {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/opinions/best/" + spotId + "/" + amount, List.class);

        List<Opinion> opinionList = new ArrayList<>();

        for (Object object : response.getBody()) {
            opinionList.add(opinionCreator.createOpinion((Map) object));
        }

        return Optional.of(opinionList);
    }

    @Override
    public Optional<List<Opinion>> getWorstOpinion(String spotId, int amount) {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/opinions/worst/" + spotId + "/" + amount, List.class);

        List<Opinion> opinionList = new ArrayList<>();

        for (Object object : response.getBody()) {
            opinionList.add(opinionCreator.createOpinion((Map) object));
        }

        return Optional.of(opinionList);
    }

    @Override
    public Optional<List<Opinion>> getExplorersOpinion(String explorerId) {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/opinions/explorer/" + explorerId, List.class);

        List<Opinion> opinionList = new ArrayList<>();

        for (Object object : response.getBody()) {
            opinionList.add(opinionCreator.createOpinion((Map) object));
        }

        return Optional.of(opinionList);
    }

    @Override
    public double getAvgRate(String spotId) {
        return restTemplate
                .getForEntity("http://localhost:8090/api/v1/spot/exploration/" + spotId + "/rate", Double.class)
                .getBody();
    }

}
