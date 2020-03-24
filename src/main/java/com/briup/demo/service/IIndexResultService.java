package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;

/**
 * 输出首页的所有数据的接口
 * @author Shinelon
 *
 */
public interface IIndexResultService {

	IndexResult findAllIndexResult();
	List<CategoryEx> findAllCategoryEx();
}
