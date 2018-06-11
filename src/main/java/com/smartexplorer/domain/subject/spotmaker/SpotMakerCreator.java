package com.smartexplorer.domain.subject.spotmaker;

import org.springframework.security.core.Authentication;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

public interface SpotMakerCreator {
    SpotMaker createSpotMaker(SpotMakerForm form, Authentication authentication);
}
