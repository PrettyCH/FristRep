package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.mapper.LinkMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.IIndexResultService;

@Service
public class IndexResultServiceImpl implements IIndexResultService{
	@Autowired
	private CategoryExMapper categoryExMapper;
	
	@Autowired
	private LinkMapper linkMapper;
	
	
	@Override
	public List<CategoryEx> findAllCategoryEx() {
		// TODO Auto-generated method stub
		List<CategoryEx> list = categoryExMapper.findAllCategoryEx();
		return list;
	}

	
	
	@Override
	public IndexResult findAllIndexResult() {
		IndexResult result = new IndexResult();
		
		result.setCategroys(categoryExMapper.findAllCategoryEx());
		result.setList(linkMapper.selectAll());
		return result;
	}

}
