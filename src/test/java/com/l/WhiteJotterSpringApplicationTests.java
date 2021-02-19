package com.l;

import com.l.dao.CategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WhiteJotterSpringApplicationTests {
    @Test
    void test(@Autowired CategoryDao dao) {
        System.out.println("asdf".getClass().getSimpleName());
    }
}
