package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MVC")
public class MVCController {
    @GetMapping("/1")
    public String hello(Model model){
        model.addAttribute("msg","你好");
        return "success";
    }
}
