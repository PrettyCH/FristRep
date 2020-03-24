package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.ArticleExample.Criteria;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryMapper categorymapper;
	
	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private CategoryExMapper categoryExMapper;
	@Override
	public List<Category> findAllCategorys() throws CustomerExcption {
		// TODO Auto-generated method stub
		
		return categorymapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerExcption {
		// TODO Auto-generated method stub
			if(category==null) {
				throw new CustomerExcption(StatusCodeUtil.Error_CODE, "您输入的数据为空");
			}
			if(category.getId()==null) {
				categorymapper.insert(category);
			}else {
				categorymapper.updateByPrimaryKey(category);
			}
	}

	@Override
	public void delectCategroyById(Integer id) throws CustomerExcption {
		// TODO Auto-generated method stub
		ArticleExample articleExample = new ArticleExample();
		Criteria createCriteria = articleExample.createCriteria();
		createCriteria.andCategoryIdEqualTo(id);
		articleMapper.deleteByExample(articleExample);
		categorymapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category findCategoryById(Integer id) throws CustomerExcption {
		// TODO Auto-generated method stub
		Category category = categorymapper.selectByPrimaryKey(id);
		if (category==null) {
			throw new CustomerExcption(500, "根据您的id未曾找到相关栏目");
		}else {
			return category;
		}
		
	}
	
	@Override
	public List<CategoryEx> findCategoryExByName(String name) throws CustomerExcption {
		name=name==null?"":name;
		List<CategoryEx> list = categoryExMapper.findCategoryExByName(name);
		if(list.size()>0) {
			return list;
		}else {
			throw new CustomerExcption(StatusCodeUtil.Error_CODE, "您查找的数据栏目不存在为空");
		}
	}

}
