package com.l;

import com.l.dao.BookDao;
import com.l.dao.CategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WhiteJotterSpringApplicationTests {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private BookDao bookDao;

    @Test
    void test() {
        System.out.println(bookDao.findAll());
    }
}
