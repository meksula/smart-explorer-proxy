package com.smartexplorer.proxy.domain.subject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.Map;

/**
 * @Author Karol Meksuła
 * 11-07-2018
 * */

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SpotInformation {
    private String id;

    private String spotId;
    private Map<DayOfWeek, VisitDay> visitDaysInWeek;
    private BigDecimal normalTicketPrice;
    private BigDecimal discountedTicketPrice;
    private String message;

    public SpotInformation() {}

    public SpotInformation(String spotId) {
        this.spotId = spotId;
    }

}
