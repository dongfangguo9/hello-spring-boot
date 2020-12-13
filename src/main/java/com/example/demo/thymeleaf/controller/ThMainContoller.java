package com.example.demo.thymeleaf.controller;

import com.example.demo.thymeleaf.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThMainContoller {
    @RequestMapping(value = "th",method = RequestMethod.GET)
    public String index(Model model){
        User user=new User();
        user.setName("zhangsan");
        model.addAttribute("user",user);
        return "index";
    }
}
