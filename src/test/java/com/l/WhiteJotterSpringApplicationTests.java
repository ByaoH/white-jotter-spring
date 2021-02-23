package com.l;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class WhiteJotterSpringApplicationTests {
    @Test
    void test(@Autowired StringRedisTemplate redisTemplate) {
        redisTemplate.opsForValue().set("k1", "v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));
    }
}
