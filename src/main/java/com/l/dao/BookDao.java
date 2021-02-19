package com.l.dao;

import com.l.entity.Book;
import com.l.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author l
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    /**
     * 根据类别查询所有Book
     *
     * @param category
     * @return
     */
    List<Book> findAllByCategory(Category category);

    /**
     * 根据title 或者 作者查询图书
     *
     * @param title
     * @param author
     * @return
     */
    List<Book> findAllByTitleLikeOrAuthorLike(String title, String author);
}
