package com.smartexplorer.proxy.controller;

import com.smartexplorer.proxy.domain.subject.Explorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Karol Meksuła
 * 24-06-2018
 */

@RestController
@RequestMapping("/explorer")
public class ExplorerController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Explorer postExplorer(@RequestBody Explorer explorer) {
        //explorer.setExplorerId(auth.getName());
        HttpEntity<Explorer> entity = new HttpEntity<>(explorer);

        return restTemplate.exchange("http://localhost:8090/api/v1/explorer/personalization",
                HttpMethod.POST, entity, Explorer.class).getBody();
    }

}
