package com.wang.controller;

import com.wang.pojo.JotterArticle;
import com.wang.result.Result;
import com.wang.result.ResultFactory;
import com.wang.service.JotterArticleService;
import com.wang.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Jotter controller.
 *
 * @author Evan
 * @date 2020/1/14 20:33
 */
@RestController
public class JotterController {
    @Autowired
    JotterArticleService jotterArticleService;

//    @PostMapping("api/admin/content/article")
//    public Result saveArticle(@RequestBody @Valid JotterArticle article) {
//        jotterArticleService.addOrUpdate(article);
//        return ResultFactory.buildSuccessResult("保存成功");
//    }

//    @GetMapping("/api/article/{size}/{page}")
//    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
//        return ResultFactory.buildSuccessResult(jotterArticleService.list(page - 1, size));
//    }

    @GetMapping("/api/article/{size}/{page}")
    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page){
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(size);
        pageRequest.setPageNum(page);
        return ResultFactory.buildSuccessResult(jotterArticleService.findPage(pageRequest));
    }

//    @GetMapping("/api/article/{id}")
//    public Result getOneArticle(@PathVariable("id") int id) {
//        return ResultFactory.buildSuccessResult(jotterArticleService.findById(id));
//    }
//
//    @DeleteMapping("/api/admin/content/article/{id}")
//    public Result deleteArticle(@PathVariable("id") int id) {
//        jotterArticleService.delete(id);
//        return ResultFactory.buildSuccessResult("删除成功");
//    }
}