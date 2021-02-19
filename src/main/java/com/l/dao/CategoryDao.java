package com.l.dao;

import com.l.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author l
 */
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
