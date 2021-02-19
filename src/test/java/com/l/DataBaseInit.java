package com.l;

import com.alibaba.fastjson.JSON;
import com.l.dao.BookDao;
import com.l.dao.CategoryDao;
import com.l.dao.UserDao;
import com.l.entity.Book;
import com.l.entity.Category;
import com.l.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootTest
class DataBaseInit {
    @Autowired
    UserDao userDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void init() throws IOException {
        userInit(userDao);
        categoryInit(categoryDao);
        bookInit(bookDao);
    }

    private void userInit(UserDao userDao) {
        User user = new User();
        user.setId(1);
        user.setUsername("root");
        user.setPassword("123456");
        userDao.save(user);
    }

    @Test
    public void test() throws IOException {
    }

    private void categoryInit(CategoryDao categoryDao) throws IOException {
        StringBuffer sb = getStringBuffer("categorys.json");
        List<Category> categories = JSON.parseArray(sb.toString(), Category.class);
        categories.forEach(categoryDao::save);
    }

    private void bookInit(BookDao bookDao) throws IOException {
        StringBuffer sb = getStringBuffer("books.json");
        List<Book> books = JSON.parseArray(sb.toString(), Book.class);
        books.forEach(bookDao::save);
    }

    private StringBuffer getStringBuffer(String classFile) throws IOException {
        Resource resource = new ClassPathResource(classFile);
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String t;
        while ((t = br.readLine()) != null) {
            sb.append(t);
        }
        br.close();
        return sb;
    }
}
