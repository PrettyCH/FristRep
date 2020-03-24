package com.briup.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ex.CustomerEx;
import com.briup.demo.mapper.ex.CustomerExMapper;
import com.briup.demo.service.ICustomerJPAService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CustomerJPAServiceImpl implements ICustomerJPAService {
	
		@Autowired
		private CustomerExMapper customerExMapper;
		
	@Override
	public void saveCustomer(CustomerEx customerEx) throws CustomerExcption {
		// TODO Auto-generated method stub
		System.out.println(customerEx);
		if(customerEx==null) {
			throw new CustomerExcption(StatusCodeUtil.Error_CODE, "您输入的数据为空");
		}else {
			customerExMapper.save(customerEx);
		}
	}

	@Override
	public void deleteCustomer(Integer id) throws CustomerExcption {
		// TODO Auto-generated method stub
		id=id==null?0:id;
		customerExMapper.deleteById(id);
	}

}
