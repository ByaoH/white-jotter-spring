package com.l.service;

import com.l.entity.Book;

import java.util.List;

/**
 * @author l
 */
public interface BookService {
    /**
     * 查找所有book
     *
     * @return 按照id排序的所有book
     */
    List<Book> list();

    /**
     * 插入一条数据 当该主键存在时则为修改
     *
     * @param book
     */
    void addOrUpdate(Book book);

    /**
     * 删除指定id的列
     *
     * @param id 不能为空
     */
    void deleteById(int id);

    /**
     * 按照类被id返回所有book
     *
     * @param category_id 不能为空
     * @return
     */
    List<Book> listByCategory(int category_id);
}
