package com.example.demo.quick;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quick")
public class QuickController {

    @Value("${name}")
    private String name;
    @GetMapping("/1")
    public String quick1(){
        return name;
    }
}
