package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerExcption;

/**
 * 关于连接的Service层，相关操作
 * @author Shinelon
 *
 */
public interface ILinkService {
	/**
	 * 保存连接信息
	 * @param link
	 */
	void   saveOrUpdateLink(Link link) throws CustomerExcption;
	void   deleteLink(Integer id) throws CustomerExcption;
	List<Link> 	selectAll() throws CustomerExcption;
	List<Link> findLinksByName(String name) throws CustomerExcption;
	
}
