package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="栏目测试类")
public class CategoryController {
	@Autowired
	private ICategoryService categoryMapper;
	
	
	
	@PostMapping("/addCategory")
	@ApiOperation("添加栏目")
	public Message<String> addCategory(Category category){
		try {
			categoryMapper.saveOrUpdateCategory(category);
			
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.Error_CODE, e.getMessage());
		}
		
	}
	
	@PostMapping("/updateCategory")
	@ApiOperation("修改栏目")
	public Message<String> updateCategory(Category category){
		try {
			categoryMapper.saveOrUpdateCategory(category);
			
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.Error_CODE, e.getMessage());
		}
	}
	
	@GetMapping("/findAllCategorys")
	@ApiOperation("查询所有栏目")
	public Message<List<Category>> findAllCategorys(){
		return MessageUtil.success(categoryMapper.findAllCategorys());
	}
	
	@GetMapping("/findCategoryById")
	@ApiOperation("根据栏目id查询栏目")
	public Message<Category> findCategoryById(Integer id){
		try {
			return MessageUtil.success(categoryMapper.findCategoryById(id));
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), e.getMessage());
		}
	}
	
	@GetMapping("/delectCategroyById")
	@ApiOperation("查询所有栏目")
	public Message<String> delectCategroyById(Integer id){
		categoryMapper.delectCategroyById(id);
		return MessageUtil.success();
	}
	
	
	@GetMapping("/findCategoryExByName")
	@ApiOperation("选中栏目的名字，显示其中的文章")
	public Message<List<CategoryEx>> findArticleByCategoryName(String name){
		  List<CategoryEx> categoryEx = categoryMapper.findCategoryExByName(name);
		return MessageUtil.success(categoryEx);
	}
}
