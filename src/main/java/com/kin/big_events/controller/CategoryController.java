package com.kin.big_events.controller;

import com.kin.big_events.pojo.Category;
import com.kin.big_events.pojo.Result;
import com.kin.big_events.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.addCategory(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> getAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        return Result.success(categoryList);
    }

    @GetMapping("/detail")
    public Result<Category> getCategoryDetail(Integer id) {
        Category category = categoryService.getById(id);
        return Result.success(category);
    }

    @PutMapping
    public Result updateCategory(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.updateCategory(category);
        return Result.success();
    }

    //
    @DeleteMapping
    public Result deleteCategory(Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }

}
