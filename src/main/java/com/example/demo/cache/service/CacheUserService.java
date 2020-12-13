package com.example.demo.cache.service;

import com.example.demo.cache.domain.User;
import com.example.demo.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheUserService {
    @Autowired
    UserMapper userMapper;
    @Cacheable(value = {"user"},keyGenerator = "myKeyGenerator")
    public List<User> findAll(){
        System.out.println("cache测试");
        return userMapper.findAll();
    }
    //@Cacheable(value = {"user"},key = "#root.methodName+'['+#root+']'")
    @Cacheable(value = {"user"},key="#id")
    public User findById(int id){
        System.out.println("cache findByid 测试");
        return userMapper.findById(id);
    }
    @CachePut(value = {"user"},key="#user.id")
    public User updateUser(User user){
        System.out.println("cache updateUser test");
        userMapper.updateById(user);
        return user;
    }
}
