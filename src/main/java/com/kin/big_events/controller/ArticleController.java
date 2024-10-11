package com.kin.big_events.controller;


import com.kin.big_events.pojo.Article;
import com.kin.big_events.pojo.PageBean;
import com.kin.big_events.pojo.Result;
import com.kin.big_events.service.ArticleService;
import com.kin.big_events.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
//测试
//    @GetMapping("/list")
//    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
////        try {
////            Map<String, Object> claims = JwtUtil.parseToken(token);
////            return Result.success("Article success");
////        } catch (Exception e) {
////            response.setStatus(401);
////            return Result.error("未登录！");
////        }
//        return Result.success("Article success");
//    }

    @Autowired
    private ArticleService articleService;


    @PostMapping
    public Result addArticle(@RequestBody @Validated Article article) {
        articleService.addArticle(article);
        return Result.success();
    }

    //更新文章
    //有问题
    @PutMapping
    public Result updateArticle(@RequestBody @Validated Article article) {
        articleService.updateArticle(article);
        return Result.success();
    }

    //获取文章详情
    //有问题
    @GetMapping("/detail")
    public Result<Article> getById(Integer id) {
        Article article = articleService.getById(id);
        return Result.success(article);
    }

    //删除文章
    @DeleteMapping
    public Result deleteArticle(Integer id) {
        articleService.deleteArticle(id);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> getAllArticle(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pb = articleService.getAllList(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }

}
