package com.l;

import com.l.dao.CategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class WhiteJotterSpringApplicationTests {
    @Test
    void test(@Autowired CategoryDao dao) {
        File file = new File("../");
        System.out.println(file.getAbsolutePath());
    }
}
