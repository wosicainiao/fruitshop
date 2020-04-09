package com.wc.project.fruitshop.web;

import redis.clients.jedis.Jedis;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/6 16:05
 */
public class RedisTest {
    public static void main(String[] args){
        Jedis jedis = new Jedis("192.168.43.198", 6379);
        String redis1 = jedis.get("1");
        String redis2 = jedis.get("2");
        String redis3 = jedis.get("3");
        String redis4 = jedis.get("4");
        String redis5 = jedis.get("5");
        System.out.println("value1: "+redis1);
        System.out.println("value2: "+redis2);
        System.out.println("value3: "+redis3);
        System.out.println("value5: "+redis5);
        jedis.close();
    }
}
