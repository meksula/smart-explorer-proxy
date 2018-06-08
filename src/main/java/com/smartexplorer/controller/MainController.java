package com.smartexplorer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author
 * Karol Meksuła
 * 09-06-2018
 * */

@Controller
public class MainController {

    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public String homePage() {
        return "home";
    }
}
