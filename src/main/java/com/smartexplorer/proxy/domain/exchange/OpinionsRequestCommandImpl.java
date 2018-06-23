package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.Opinion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 23-06-2018
 * */

@Service
public class OpinionsRequestCommandImpl implements OpinionsRequestCommand {

    @Override
    public Optional<Opinion> addOpinion(Opinion opinion) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Opinion>> getLatestOpinion(String spotId, int amount) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Opinion>> getBestOpinion(String spotId, int amount) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Opinion>> getWorstOpinion(String spotId, int amount) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Opinion>> getExplorersOpinion(String explorerId) {
        return Optional.empty();
    }
}
