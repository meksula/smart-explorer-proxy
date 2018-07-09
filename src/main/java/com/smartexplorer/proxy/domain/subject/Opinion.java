package com.smartexplorer.proxy.domain.subject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author Karol Meksuła
 * 17-06-2018
 */

@Getter
public class Opinion {
    private String explorerId;
    private String spotId;
    private double rate;
    private String content;
    private String date;

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

    public Opinion(final OpinionBuilder opinionBuilder) {
        this.explorerId = opinionBuilder.explorerId;
        this.spotId = opinionBuilder.spotId;
        this.rate = opinionBuilder.rate;
        this.content = opinionBuilder.content;
        this.date = opinionBuilder.date;
    }

    public static class OpinionBuilder {
        private String explorerId;
        private String spotId;
        private double rate;
        private String content;
        private String date;

        public OpinionBuilder explorerId(String explorerId) {
            this.explorerId = explorerId;
            return this;
        }

        public OpinionBuilder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public OpinionBuilder rate(double rate) {
            this.rate = rate;
            return this;
        }

        public OpinionBuilder content(String content) {
            this.content = content;
            return this;
        }

        public OpinionBuilder date(String date) {
            this.date = date;
            return this;
        }

        public Opinion build() {
            return new Opinion(this);
        }
    }

}