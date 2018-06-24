package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.Opinion;

import java.util.List;
import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 23-06-2018
 * */

public interface OpinionsRequestCommand {
    Optional<Opinion> addOpinion(Opinion opinion);

    Optional<List<Opinion>> getLatestOpinion(String spotId, int amount);

    Optional<List<Opinion>> getBestOpinion(String spotId, int amount);

    Optional<List<Opinion>> getWorstOpinion(String spotId, int amount);

    Optional<List<Opinion>> getExplorersOpinion(String explorerId);

    double getAvgRate(String spotId);

}
