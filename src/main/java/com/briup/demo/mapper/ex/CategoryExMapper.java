package com.briup.demo.mapper.ex;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;

public interface CategoryExMapper {
	
	List<CategoryEx> findAllCategoryEx();
	List<CategoryEx> findCategoryExByName(String name);
}
