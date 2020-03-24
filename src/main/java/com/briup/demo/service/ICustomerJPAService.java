package com.briup.demo.service;

import com.briup.demo.bean.ex.CustomerEx;
import com.briup.demo.utils.CustomerExcption;

public interface ICustomerJPAService {
	void saveCustomer(CustomerEx customerEx) throws CustomerExcption;
	void deleteCustomer(Integer id) throws CustomerExcption;
}
