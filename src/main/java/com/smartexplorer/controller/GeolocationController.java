package com.smartexplorer.controller;

import com.smartexplorer.controller.exception.CannotDefinePlace;
import com.smartexplorer.domain.core.RequestObject;
import com.smartexplorer.domain.core.ResponseObject;
import com.smartexplorer.domain.core.PlaceFindCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 09-06-2018
 * */

@RestController
@RequestMapping(path = "/api/v1/geolocation/nearest")
public class GeolocationController {
    private PlaceFindCommand placeFindCommand;

    @Autowired
    public void setPlaceFindCommand(PlaceFindCommand placeFindCommand) {
        this.placeFindCommand = placeFindCommand;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseObject getNearestPlaceToVisit(@RequestBody RequestObject requestObject) {
        return placeFindCommand.lookForPlace(requestObject)
                .orElseThrow(CannotDefinePlace::new);
    }

}
