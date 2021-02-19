package com.l.service.impl;

import com.l.dao.CategoryDao;
import com.l.entity.Category;
import com.l.service.CategoryService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author l
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    @Override
    public Category get(int id) {
        return categoryDao.findById(id).orElse(null);
    }
}
