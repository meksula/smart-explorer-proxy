package com.smartexplorer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

@Controller
@RequestMapping(path = "/doc")
public class DocumentationController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getDocumentation() {
        return "main_doc";
    }

}