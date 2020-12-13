package com.example.demo.quick;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/quick2")
@ConfigurationProperties(prefix = "person")
@Getter
@Setter
public class QuickController2 {

    public String name;
    private String addr;
    private String age;

    @RequestMapping("/1")
    @ResponseBody
    public String quick(){
        return name+" "+" "+ addr+" "+age;
    }
}
