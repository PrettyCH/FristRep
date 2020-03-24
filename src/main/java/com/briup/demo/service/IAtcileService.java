package com.briup.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.utils.CustomerExcption;

/**
 * 文章内容相关的service层接口
 * @author Shinelon
 *
 */


public interface IAtcileService {
	/**
	 *新增或更新文章 
	 */
		void saveOrUpdateArticle(Article article) throws CustomerExcption;
		
	/**
	 * 删除文章
	 */
		void deleteArticleById(Integer id) throws CustomerExcption;
	

		/**
		 * 
		 * @param keyStr 表是 搜索关键字
		 * @param Condition 表示 搜索栏目
		 * @return
		 * @throws CustomerExcption
		 */
		List<Article> findArticleByCondition(String keyStr,String Condition) throws CustomerExcption;
		
		/**
		 * 根据id查询栏目
		 */
		Article findArticleById(Integer id)  throws CustomerExcption;
		
		
		
		/**
		 * 顾客浏览文章目录，并点击进去。展示文章所有信息并溜了量+1
		 */
		Article customerBrowseArticleByName(String name) throws CustomerExcption;
		
}
