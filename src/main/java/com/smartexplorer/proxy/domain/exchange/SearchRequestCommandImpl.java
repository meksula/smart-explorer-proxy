package com.smartexplorer.proxy.domain.exchange;

import com.google.maps.model.LatLng;
import com.smartexplorer.proxy.domain.subject.SpotResponse;
import com.smartexplorer.proxy.domain.subject.Visit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 17-06-2018
 * */

@Service
public class SearchRequestCommandImpl implements SearchRequestCommand {

    @Override
    public Optional<SpotResponse> findNearest(LatLng latLng) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("PROXY_CLIENT_3d2dc3df22", "PROXY_CLIENT_3d2dc3df22"));

        HttpEntity<LatLng> request = new HttpEntity<>(latLng);

        ResponseEntity<Map> response = restTemplate.exchange("http://localhost:8090/api/v1/spot/exploration/nearest",
                HttpMethod.POST, request, Map.class);

        Map map = response.getBody();

        SpotResponse spotResponse = new SpotResponse.SpotResponseBuilder()
                .spotId((String) map.get("id"))
                .name((String) map.get("name"))
                .description((String) map.get("description"))
                .integratedAddress(map.get("city") + ", ul. " + map.get("street") + " " + map.get("buildingNumber"))
                .ratesAvg(5) //TODO
                .recentOpinions(null) //TODO
                .pictureUri("http://localhost:8090//api/v1/spot/" + map.get("id"))
                .longitude((Double) map.get("longitude"))
                .latitude((Double) map.get("latitude"))
                .build();


        return Optional.ofNullable(spotResponse);
    }

    @Override
    public Optional<List<SpotResponse>> findInCity(LatLng latLng) {
        return Optional.empty();
    }

    @Override
    public Optional<List<SpotResponse>> findInDistrict(LatLng latLng) {
        return Optional.empty();
    }

    @Override
    public Optional<List<SpotResponse>> findTop(int amount) {
        return Optional.empty();
    }

    @Override
    public Optional<List<SpotResponse>> findById(String spotId) {
        return Optional.empty();
    }

    @Override
    public Optional<SpotResponse> visit(Visit visit) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Visit>> visitHistory(String explorerId) {
        return Optional.empty();
    }
}
