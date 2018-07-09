package com.smartexplorer.proxy.domain.subject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

/**
 * @Author Karol Meksuła
 * 17-06-2018
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SpotResponse {
    private String spotId;
    private String name;
    private String description;
    private String integratedAddress;
    private double ratesAvg;
    private List<Opinion> recentOpinions;
    private String pictureUri;
    private double longitude;
    private double latitude;

    public SpotResponse(final SpotResponseBuilder spotResponseBuilder) {
        this.spotId = spotResponseBuilder.spotId;
        this.name = spotResponseBuilder.name;
        this.description = spotResponseBuilder.description;
        this.integratedAddress = spotResponseBuilder.integratedAddress;
        this.ratesAvg = spotResponseBuilder.ratesAvg;
        this.pictureUri = spotResponseBuilder.pictureUri;
        this.recentOpinions = spotResponseBuilder.recentOpinions;
        this.longitude = spotResponseBuilder.longitude;
        this.latitude = spotResponseBuilder.latitude;
    }

    public static class SpotResponseBuilder {
        private String spotId;
        private String name;
        private String description;
        private String integratedAddress;
        private double ratesAvg;
        private String pictureUri;
        private List<Opinion> recentOpinions;
        private double longitude;
        private double latitude;

        public SpotResponseBuilder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public SpotResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SpotResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public SpotResponseBuilder integratedAddress(String integratedAddress) {
            this.integratedAddress = integratedAddress;
            return this;
        }

        public SpotResponseBuilder ratesAvg(double ratesAvg) {
            this.ratesAvg = ratesAvg;
            return this;
        }

        public SpotResponseBuilder pictureUri(String pictureUri) {
            this.pictureUri = pictureUri;
            return this;
        }

        public SpotResponseBuilder recentOpinions(List<Opinion> recentOpinions) {
            this.recentOpinions = recentOpinions;
            return this;
        }

        public SpotResponseBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public SpotResponseBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public SpotResponse build() {
            return new SpotResponse(this);
        }

    }

}
