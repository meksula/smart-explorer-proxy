package com.smartexplorer.proxy.controller;

import com.smartexplorer.proxy.domain.exception.OpinionException;
import com.smartexplorer.proxy.domain.exchange.OpinionsRequestCommand;
import com.smartexplorer.proxy.domain.subject.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 23-06-2018
 * */

@RestController
@RequestMapping("/opinions")
public class OpinionsController {
    private OpinionsRequestCommand opinionsRequestCommand;

    @Autowired
    public void setOpinionsRequestCommand(OpinionsRequestCommand opinionsRequestCommand) {
        this.opinionsRequestCommand = opinionsRequestCommand;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Opinion addOpinion(@RequestBody Opinion opinion) {
        return opinionsRequestCommand.addOpinion(opinion)
                .orElseThrow(() -> new OpinionException("Cannot add opinion to spot with id: " + opinion.getSpotId()));
    }

    @GetMapping("/latest/{spotId}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opinion> getLatest(@PathVariable("spotId") String spotId,
                                   @PathVariable("amount") int amount) {
        return opinionsRequestCommand.getLatestOpinion(spotId, amount)
                .orElseThrow(() -> new OpinionException("Cannot find latest opinions."));
    }

    @GetMapping("/best/{spotId}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opinion> getBestOpinions(@PathVariable("spotId") String spotId,
                                         @PathVariable("amount") int amount) {
        return opinionsRequestCommand.getBestOpinion(spotId, amount)
                .orElseThrow(() -> new OpinionException("Cannot find best opinions."));
    }

    @GetMapping("/worst/{spotId}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opinion> getWorstOpinions(@PathVariable("spotId") String spotId,
                                          @PathVariable("amount") int amount) {
        return opinionsRequestCommand.getWorstOpinion(spotId, amount)
                .orElseThrow(() -> new OpinionException("Cannot find worst opinions."));
    }

    @GetMapping("/{explorerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opinion> getExplorerOpinions(@PathVariable("explorerId") String explorerId) {
        return opinionsRequestCommand.getExplorersOpinion(explorerId)
                .orElseThrow(() -> new OpinionException("Cannot find explorers opinions with id: " + explorerId));
    }

}
