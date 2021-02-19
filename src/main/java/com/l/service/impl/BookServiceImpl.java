package com.l.service.impl;

import com.l.dao.BookDao;
import com.l.entity.Book;
import com.l.entity.Category;
import com.l.service.BookService;
import com.l.service.CategoryService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author l
 */
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final CategoryService categoryService;

    public BookServiceImpl(BookDao bookDao, CategoryService categoryService) {
        this.bookDao = bookDao;
        this.categoryService = categoryService;
    }

    @Override
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    @Override
    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> listByCategory(int category_id) {
        Category category = categoryService.get(category_id);
        return bookDao.findAllByCategory(category);
    }
}
