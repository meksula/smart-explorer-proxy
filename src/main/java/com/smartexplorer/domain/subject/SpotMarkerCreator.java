package com.smartexplorer.domain.subject;

import org.springframework.security.core.Authentication;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

public interface SpotMarkerCreator {
    SpotMaker createSpotMaker(SpotMakerForm form, Authentication authentication);
}
