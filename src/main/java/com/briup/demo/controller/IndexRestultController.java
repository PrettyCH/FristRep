package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.service.IIndexResultService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="主页面返回所有信息测试")
public class IndexRestultController {
	
	@Autowired
	private IIndexResultService indexResultMapper;
	
	
	@GetMapping("/findAllCategoryEx")
	@ApiOperation("/查找所有的栏目级联下面的书籍信息")
	public Message<List<CategoryEx>> findAllCategoryEx(){
		List<CategoryEx> list = indexResultMapper.findAllCategoryEx();
		System.out.println(list);
		return  MessageUtil.success(list);
		
	}

	@GetMapping("/findAllIndexResult")
	@ApiOperation("/查找所有的栏目级联下面的书籍信息及其连接")
	public Message<IndexResult> findAllIndexResult(){
		IndexResult list = indexResultMapper.findAllIndexResult();
		System.out.println(list);
		return  MessageUtil.success(list);
		
	}
}
