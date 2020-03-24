package com.briup.demo.service.impl;
import java.util.Date;
/**
 *实现文章管理的逻辑类
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.CategoryExample.Criteria;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.IAtcileService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class ArticleServiceImpl implements IAtcileService {

	@Autowired
	private ArticleMapper articleMapper;	
	
	@Autowired
	private CategoryMapper CategoryMapper;
	
	@Override
	public void saveOrUpdateArticle(Article article) throws CustomerExcption {
		// TODO Auto-generated method stub
			if(article==null) {
				throw new CustomerExcption(StatusCodeUtil.Error_CODE, "参数为空");
			}
			if(article.getId()==null) {
				//需要额外添加两条数据
				article.setPublishdate(new Date());
				article.setClicktimes(0);
				articleMapper.insert(article);
			}else {
				article.setPublishdate(new Date());
				articleMapper.updateByPrimaryKeySelective(article);
				}
	}

	@Override
	public void deleteArticleById(Integer id) throws CustomerExcption {
		// TODO Auto-generated method stub
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Article> findArticleByCondition(String keyStr, String Condition) throws CustomerExcption {
		// TODO Auto-generated method stub
		/*
		 * 三种情况
		 * 1.没有添加任何条件，则查询所有
		 * 2.没有指定栏目，但指定了查询的关键字，则根据关键字查询满足条件的所有文章
		 * 3.指定栏目，没有指定关键字，则根据栏目查询满足条件的所有文章
		 * 4.指定栏目，同时指定查询关键字，则根据栏目和关键字查询满足条件的所有文章
		 */
		keyStr= keyStr==null?"":keyStr.trim();
		Condition= Condition==null?"":Condition.trim();
		ArticleExample example = new ArticleExample();
		CategoryExample categoryExample = new CategoryExample();
		if("".equals(keyStr) &&"".equals(Condition)){
			//情况1
			List<Article> list = articleMapper.selectByExample(example);
			return list;
		}
		if(!"".equals(keyStr)&& "".equals(Condition)) {
			//情况二
			  example.createCriteria().andTitleLike("%"+keyStr+"%");
			  return articleMapper.selectByExample(example);
		}
		if("".equals(keyStr)&& !"".equals(Condition)) {
			//情况3
			categoryExample.createCriteria().andNameEqualTo(Condition);
			List<Category> category = CategoryMapper.selectByExample(categoryExample);
			if (category.size()>0) {
				Integer id = category.get(0).getId();
				example.createCriteria().andCategoryIdEqualTo(id);
				 return articleMapper.selectByExample(example);
			}else {
				throw new CustomerExcption(StatusCodeUtil.Error_CODE, "没有这个给改搜索栏目");
			}
		
			
		}
		if(!"".equals(keyStr)&& !"".equals(Condition)) {
			//情况4
			categoryExample.createCriteria().andNameEqualTo(Condition);
			List<Category> category = CategoryMapper.selectByExample(categoryExample);
			if (category.size()>0) {
				Integer id = category.get(0).getId();
				example.createCriteria().andCategoryIdEqualTo(id).andTitleLike("%"+keyStr+"%");
				 return articleMapper.selectByExample(example);
			}else {
				throw new CustomerExcption(StatusCodeUtil.Error_CODE, "没有这个给改搜索栏目");
			}	 
		}
		return null;
		
	}

	@Override
	public Article findArticleById(Integer id) throws CustomerExcption {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}



	@Override
	public Article customerBrowseArticleByName(String name) throws CustomerExcption {
		// TODO Auto-generated method stub
		 ArticleExample example = new ArticleExample();
		example.createCriteria().andTitleEqualTo(name);
		List<Article> list = articleMapper.selectByExample(example);
		
		Article article = list.get(0);
		Integer clicktimes = article.getClicktimes();
		clicktimes=clicktimes==null?0:clicktimes;
		article.setClicktimes(clicktimes+1);
		articleMapper.updateByPrimaryKey(article);
		return article;
	}

}
