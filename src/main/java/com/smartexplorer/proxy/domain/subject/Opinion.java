package com.smartexplorer.proxy.domain.subject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author
 * Karol Meksuła
 * 17-06-2018
 * */

@Getter
public class Opinion {
    private String explorerId;
    private String spotId;
    private double rate;
    private String content;

    @JsonCreator
    public Opinion(@JsonProperty("explorerId") String explorerId,
                   @JsonProperty("spotId") String spotId,
                   @JsonProperty("rate") double rate,
                   @JsonProperty("content") String content) {
        this.explorerId = explorerId;
        this.spotId = spotId;
        this.rate = rate;
        this.content = content;
    }

}