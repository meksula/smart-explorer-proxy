package com.smartexplorer.proxy.domain.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author
 * Karol Meksuła
 * 18-06-2018
 * */

@Getter
public class Visit {
    private String spotId;
    private String explorerId;

    public Visit(@JsonProperty("spotId") String spotId,
                 @JsonProperty("explorerId") String explorerId) {
        this.spotId = spotId;
        this.explorerId = explorerId;
    }

}
