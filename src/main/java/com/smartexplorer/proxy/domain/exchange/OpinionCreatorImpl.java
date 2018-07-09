package com.smartexplorer.proxy.domain.exchange;

import com.smartexplorer.proxy.domain.subject.Opinion;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Karol Meksuła
 * 24-06-2018
 */

@Service
public class OpinionCreatorImpl implements OpinionCreator {

    @Override
    public Opinion createOpinion(Map params) {
        return new Opinion.OpinionBuilder()
                .spotId((String) params.get("spotId"))
                .explorerId((String) params.get("explorerId"))
                .rate((Double) params.get("rate"))
                .content((String) params.get("content"))
                .date((String) params.get("date"))
                .build();
    }

}
