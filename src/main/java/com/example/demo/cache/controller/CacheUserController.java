package com.example.demo.cache.controller;

import com.example.demo.cache.domain.User;
import com.example.demo.cache.service.CacheUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheUserController {
    @Autowired
    CacheUserService cacheUserService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return cacheUserService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id) {
        return cacheUserService.findById(id);
    }

    @RequestMapping("/update")
    public String update() {
        User user = new User(45, "1", new Date(), "1", "1", null);
        cacheUserService.updateUser(user);
        return "OK";
    }
}
