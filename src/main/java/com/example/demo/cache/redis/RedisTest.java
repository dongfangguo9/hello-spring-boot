package com.example.demo.cache.redis;

import com.example.demo.DemoApplication;
import com.example.demo.cache.domain.User;
import com.example.demo.cache.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;
   /* @Test
    public void test() throws JsonProcessingException {
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        if(userListJson==null){
            List<User> users = userMapper.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("=========从数据库中获得user的数据==========");
        }else{
            System.out.println("=======从redis缓存中获得user的数据======");
        }
        System.out.println(userListJson);
    }*/
    @Test
    public void string(){
        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().rightPush("mylist","7");
    }
    @Test
    public void object(){
        User byId = userMapper.findById(45);
        redisTemplate.opsForValue().set("user-45",byId);
        /*User o =(User)redisTemplate.opsForValue().get("user-45");
        System.out.println(o);*/
    }

}