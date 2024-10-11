package com.kin.big_events.service;

import com.kin.big_events.pojo.Article;
import com.kin.big_events.pojo.PageBean;

public interface ArticleService {
    void addArticle(Article article);

    void updateArticle(Article article);

    PageBean<Article> getAllList(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article getById(Integer id);

    void deleteArticle(Integer id);
}
