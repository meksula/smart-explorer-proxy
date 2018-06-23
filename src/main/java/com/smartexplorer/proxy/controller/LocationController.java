package com.smartexplorer.proxy.controller;

import com.google.maps.model.LatLng;
import com.smartexplorer.proxy.domain.exception.CannotFindAnySpot;
import com.smartexplorer.proxy.domain.exchange.SearchRequestCommand;
import com.smartexplorer.proxy.domain.subject.SpotResponse;
import com.smartexplorer.proxy.domain.subject.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-06-2018
 * */

@RestController
@RequestMapping
public class LocationController {
    private SearchRequestCommand searchRequestCommand;

    @Autowired
    public void setSearchRequestCommand(SearchRequestCommand searchRequestCommand) {
        this.searchRequestCommand = searchRequestCommand;
    }

    @PostMapping("/nearest")
    @ResponseStatus(HttpStatus.OK)
    public SpotResponse nearestSpot(@RequestBody LatLng latLng) {
        return searchRequestCommand.findNearest(latLng)
                .orElseThrow(() -> new CannotFindAnySpot("Cannot find any spot for your position: " + latLng.toString()));
    }

    @PostMapping("/city")
    @ResponseStatus(HttpStatus.OK)
    public List<SpotResponse> spotListInCity(@RequestBody LatLng latLng) {
        return searchRequestCommand.findInCity(latLng)
                .orElseThrow(() -> new CannotFindAnySpot("Cannot find any spot for your position: " + latLng.toString()));
    }

    @PostMapping("/district")
    @ResponseStatus(HttpStatus.OK)
    public List<SpotResponse> spotListInDistrict(@RequestBody LatLng latLng) {
        return searchRequestCommand.findInDistrict(latLng)
                .orElseThrow(() -> new CannotFindAnySpot("Cannot find any spot for your position: " + latLng.toString()));
    }

    @PostMapping("/top/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public List<SpotResponse> topSpots(@PathVariable("amount") int amount) {
        return searchRequestCommand.findTop(amount)
                .orElseThrow(() -> new CannotFindAnySpot("Cannot find any spot"));
    }

    @PostMapping("/{spotId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SpotResponse> spotById(@PathVariable("spotId") String spotId) {
        return searchRequestCommand.findById(spotId)
                .orElseThrow(() -> new CannotFindAnySpot("Cannot find any spot with this id: " + spotId));
    }

    @PostMapping("/visit")
    @ResponseStatus(HttpStatus.OK)
    public SpotResponse visit(@RequestBody Visit visit) {
        return searchRequestCommand.visit(visit)
                .orElseThrow(() -> new CannotFindAnySpot("Cannot visit this place! : " + visit.getSpotId()));
    }

    @PostMapping("/visit/history/{explorerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Visit> visitHistory(@PathVariable("explorerId") String explorerId) {
        return searchRequestCommand.visitHistory(explorerId)
                .orElseThrow(() -> new CannotFindAnySpot("This user has no visit history! : " + explorerId));
    }

}
