package com.smartexplorer.proxy.domain.exchange;

import com.google.maps.model.LatLng;
import com.smartexplorer.proxy.domain.subject.SpotResponse;
import com.smartexplorer.proxy.domain.subject.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @Author
 * Karol Meksuła
 * 17-06-2018
 * */

@Service
public class SearchRequestCommandImpl implements SearchRequestCommand {
    private SpotResponseCreator spotResponseCreator;
    private RestTemplate restTemplate;

    @Qualifier("restConfigured")
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setSpotResponseCreator(SpotResponseCreator spotResponseCreator) {
        this.spotResponseCreator = spotResponseCreator;
    }

    @Override
    public Optional<SpotResponse> findNearest(LatLng latLng) {
        HttpEntity<LatLng> request = new HttpEntity<>(latLng);

        ResponseEntity<Map> response = restTemplate.exchange("http://localhost:8090/api/v1/spot/exploration/nearest",
                HttpMethod.POST, request, Map.class);

        return Optional.of(spotResponseCreator.createSpotResponse(response.getBody()));
    }

    @Override
    public Optional<List<SpotResponse>> findInCity(LatLng latLng) {
        HttpEntity<LatLng> request = new HttpEntity<>(latLng);

        ResponseEntity<List> response = restTemplate.exchange("http://localhost:8090/api/v1/spot/exploration/city",
                HttpMethod.POST, request, List.class);

        List<SpotResponse> spotResponseList = new ArrayList<>();

        for (Object object : response.getBody()) {
            spotResponseList.add(spotResponseCreator.createSpotResponse((Map) object));
        }

        return Optional.of(spotResponseList);
    }

    @Override
    public Optional<List<SpotResponse>> findInDistrict(LatLng latLng) {
        HttpEntity<LatLng> request = new HttpEntity<>(latLng);

        ResponseEntity<List> response = restTemplate.exchange("http://localhost:8090/api/v1/spot/exploration/district",
                HttpMethod.POST, request, List.class);

        List<SpotResponse> spotResponseList = new ArrayList<>();

        for (Object object : response.getBody()) {
            spotResponseList.add(spotResponseCreator.createSpotResponse((Map) object));
        }

        return Optional.of(spotResponseList);
    }

    @Override
    public Optional<List<SpotResponse>> findTop(int amount) {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/exploration/top/" + amount, List.class);

        List<SpotResponse> spotResponseList = new ArrayList<>();

        for (Object object : response.getBody()) {
            spotResponseList.add(spotResponseCreator.createSpotResponse((Map) object));
        }

        return Optional.of(spotResponseList);
    }

    @Override
    public Optional<SpotResponse> findById(String spotId) {
        ResponseEntity<Map> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/exploration/" + spotId, Map.class);

        return Optional.of(spotResponseCreator.createSpotResponse(response.getBody()));
    }

    @Override
    public Optional<SpotResponse> visit(Visit visit) {
        HttpEntity<Visit> request = new HttpEntity<>(visit);

        ResponseEntity<Map> response = restTemplate.exchange("http://localhost:8090/api/v1/spot/exploration",
                HttpMethod.POST, request, Map.class);

        return Optional.of(spotResponseCreator.createSpotResponse(response.getBody()));
    }

    @Override
    public Optional<List> visitHistory(String explorerId) {
        ResponseEntity<List> response =
                restTemplate.getForEntity("http://localhost:8090/api/v1/spot/exploration/history/" + explorerId, List.class);

        return Optional.of(response.getBody());
    }

}
