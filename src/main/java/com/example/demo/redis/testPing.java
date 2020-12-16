package com.example.demo.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class testPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("120.27.8.113", 6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        System.out.println(jedis.setnx("1", "2"));
        System.out.println(jedis.setnx("1", "3"));
        System.out.println(jedis.setnx("2", "3"));
        Transaction multi = jedis.multi();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        try {
            multi.set("user",jsonObject.toString());
            int a=1/0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
           e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user"));
        }
        jedis.close();
    }
}
