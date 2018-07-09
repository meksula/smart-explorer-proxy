package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.Opinion;

import java.util.Map;

/**
 * @Author Karol Meksuła
 * 24-06-2018
 */

public interface OpinionCreator {
    Opinion createOpinion(Map params);
}
