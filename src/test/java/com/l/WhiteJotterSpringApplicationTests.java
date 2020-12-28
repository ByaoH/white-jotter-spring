package com.l;

import com.l.dao.UserDao;
import com.l.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WhiteJotterSpringApplicationTests {
    @Autowired
    private UserDao dao;

    @Test
    void contextLoads() {
        System.out.println(dao.findByUsername("root"));
    }

    @Test
    void initDataBase() {
        User entity = new User();
        entity.setUsername("root");
        entity.setPassword("123456");
        System.out.println(dao.save(entity));
    }
}
