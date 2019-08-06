package com.wei.example.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posUi")
public class HelloRest {

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!\n";
    }

}