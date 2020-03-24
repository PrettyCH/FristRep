package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.service.IAtcileService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="文章测试")
public class ArticleController {
	
	@Autowired
	private IAtcileService  articleMapper;
	
	@PostMapping("/addArticle")
	@ApiOperation("添加文章")
	public Message<String> saveArticle(Article article){
		try {
			articleMapper.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), e.getMessage());
		}
		
	}
	
	@PostMapping("/updateArticle")
	@ApiOperation("修改文章")
	public Message<String> updateArticle(Article article){
		try {
			articleMapper.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), e.getMessage());
		}
		
	}
	
	@GetMapping("/deleteArticle")
	@ApiOperation("删除文章")
	public Message<String> deleteArticle(Integer id){
		articleMapper.deleteArticleById(id);
		return MessageUtil.success();
		
	}
	
	@GetMapping("/findArticleByCondition")
	@ApiOperation("通过索引查询文章")
	public Message<List<Article>> findArticleByCondition(String keyStr, String Condition){
		
		try {
			List<Article> list = articleMapper.findArticleByCondition(keyStr, Condition);
			return MessageUtil.success(list);
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), e.getMessage());
		}
	}

	@GetMapping("/findArticleById")
	@ApiOperation("通过id查询文章")
	public Message<Article> findArticleById(Integer id){
		Article article = articleMapper.findArticleById(id);
		return MessageUtil.success(article);
		
	}
	

	
	@GetMapping("/customerBrowseArticleByName")
	@ApiOperation("顾客浏览文章目录，并点击进去。展示文章所有信息并浏览量+1")
	public Message<Article> customerBrowseArticleByName(String name){
		 Article article = articleMapper.customerBrowseArticleByName(name);
		return MessageUtil.success(article);
		
	}
}
