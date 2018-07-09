package com.smartexplorer.proxy.domain.exchange;

import com.google.maps.model.LatLng;
import com.smartexplorer.proxy.domain.subject.SpotResponse;
import com.smartexplorer.proxy.domain.subject.Visit;

import java.util.List;
import java.util.Optional;

/**
 * @Author Karol Meksuła
 * 17-06-2018
 */

public interface SearchRequestCommand {
    Optional<SpotResponse> findNearest(LatLng latLng);

    Optional<List<SpotResponse>> findInCity(LatLng latLng);

    Optional<List<SpotResponse>> findInDistrict(LatLng latLng);

    Optional<List<SpotResponse>> findTop(int amount);

    Optional<SpotResponse> findById(String spotId);

    Optional<SpotResponse> visit(Visit visit);

    Optional<List> visitHistory(String explorerId);

}
