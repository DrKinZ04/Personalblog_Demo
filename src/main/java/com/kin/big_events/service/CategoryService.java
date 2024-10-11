package com.kin.big_events.service;

import com.kin.big_events.pojo.Category;
import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    List<Category> getAllCategory();

    Category getById(Integer id);

    void updateCategory(Category category);

    void deleteById(Integer id);
}
