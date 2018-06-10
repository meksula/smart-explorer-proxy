package com.smartexplorer.controller;

import com.smartexplorer.domain.subject.SpotMaker;
import com.smartexplorer.domain.subject.SpotMakerForm;
import com.smartexplorer.domain.subject.SpotMarkerCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@RestController
@RequestMapping("/api/v1/user/")
public class UsersController {
    private SpotMarkerCreator spotMarkerCreator;

    @Autowired
    public void setSpotMarkerCreator(SpotMarkerCreator spotMarkerCreator) {
        this.spotMarkerCreator = spotMarkerCreator;
    }

    @PutMapping(path = "/spotmaker")
    @ResponseStatus(HttpStatus.CREATED)
    public SpotMaker createSpotMaker(@RequestBody SpotMakerForm form, Authentication authentication) {
        return spotMarkerCreator.createSpotMaker(form, authentication);
    }

}
