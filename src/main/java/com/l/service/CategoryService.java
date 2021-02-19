package com.l.service;

import com.l.entity.Category;

import java.util.List;

/**
 * @author l
 */
public interface CategoryService {
    /**
     * 返回所有类别信息 按id排序
     *
     * @return
     */
    List<Category> list();

    /**
     * 根据id查找类别
     *
     * @param id
     * @return 存在返回 Category 不存在返回null
     */
    Category get(int id);
}
