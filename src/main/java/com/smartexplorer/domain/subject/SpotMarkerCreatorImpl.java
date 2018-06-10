package com.smartexplorer.domain.subject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@Service
public class SpotMarkerCreatorImpl implements SpotMarkerCreator {
    @Override
    public SpotMaker createSpotMaker(SpotMakerForm form, Authentication authentication) {
        return null;
    }
}
