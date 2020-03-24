package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CustomerEx;
import com.briup.demo.service.ICustomerJPAService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="顾客JPA测试类")
public class CustomerJPAContorller {
	
	@Autowired
	ICustomerJPAService customerExMapper;
	
	@PostMapping("/saveCustomer")
	@ApiOperation("添加顾客")
	public Message<String> saveCustomer(CustomerEx customerEx){
		try {
			customerExMapper.saveCustomer(customerEx);	
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.Error_CODE, e.getMessage());
		}
		
	}
	
	@GetMapping("/deleteCustomer")
	@ApiOperation("根据顾客id删除顾客信息")
	public Message<String> deleteCustomer(Integer id){
		customerExMapper.deleteCustomer(id);
		return MessageUtil.success();
	}
}
