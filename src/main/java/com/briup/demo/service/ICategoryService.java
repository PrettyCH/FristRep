package com.briup.demo.service;
/**
 * 栏目相关的service层
 * @author Shinelon
 *
 */

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.utils.CustomerExcption;

public interface ICategoryService {

	/**
	 * 查询所有的栏目
	 */
	List<Category>  findAllCategorys() throws CustomerExcption;
	/**
	 * 添加或修改形象    
	 */
	void saveOrUpdateCategory(Category category)  throws CustomerExcption;
	/**
	 * 根据id删除栏目
	 */
	void delectCategroyById(Integer id) throws CustomerExcption;
	
	/**
	 * 根据id查找指定的栏目信息
	 */
	Category findCategoryById(Integer id) throws CustomerExcption;
	
	/**
	 * 选中栏目的名字，显示其中的数据
	 */
	List<CategoryEx> findCategoryExByName(String name) throws CustomerExcption;
	
	
	
}
