package com.l;

import com.l.dao.UserDao;
import com.l.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataBaseInit {
    @Test
    public void init(@Autowired UserDao userDao) {
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");
        userDao.save(user);

    }
}
