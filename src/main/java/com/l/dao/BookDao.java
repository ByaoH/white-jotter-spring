package com.l.dao;

import com.l.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author l
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
}
