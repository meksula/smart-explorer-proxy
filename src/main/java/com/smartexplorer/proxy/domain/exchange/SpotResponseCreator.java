package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.SpotResponse;

import java.util.Map;

/**
 * @Author Karol Meksuła
 * 24-06-2018
 */

public interface SpotResponseCreator {
    SpotResponse createSpotResponse(Map responseValues);

    SpotResponse createDetailedSpotResponse(Map responseValues);
}
