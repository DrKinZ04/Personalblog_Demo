package com.kin.big_events;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest//如果在测试类上添加了这个注解，那么单元测试方法执行之前，会先初始化Spring容器
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testSet() {
        //往Redis中存储键值对
        stringRedisTemplate.opsForValue().set("key", "value");
        stringRedisTemplate.opsForValue().set("key2", "value2",10, TimeUnit.SECONDS);//设置过期时间
    }

    @Test
    public void testGet() {
        System.out.println(stringRedisTemplate.opsForValue().get("key"));
    }
}
