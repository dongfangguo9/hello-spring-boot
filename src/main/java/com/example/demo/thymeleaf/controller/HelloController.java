package com.example.demo.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController// responsbody+controller
public class HelloController {
    @RequestMapping(value = {"hello"},method = RequestMethod.GET)
    public String Hello(){
        return "Hello Spring Boot";
    }
}
