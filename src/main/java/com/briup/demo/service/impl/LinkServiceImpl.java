package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Link;
import com.briup.demo.bean.LinkExample;
import com.briup.demo.bean.LinkExample.Criteria;
import com.briup.demo.mapper.LinkMapper;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class LinkServiceImpl implements ILinkService {
	
	
	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public void saveOrUpdateLink(Link link) throws CustomerExcption {
		// TODO Auto-generated method stub
		//参数为引用类型，要做判空处理
			if(link==null)
			{
				throw new CustomerExcption(StatusCodeUtil.Error_CODE, "参数为空！");
			}
			//判断传进来的link是否为空，如为空则为插入，不为空 则修改
			if(link.getId()!=null) {
				linkMapper.updateByPrimaryKey(link);
			}else {
				linkMapper.insertSelective(link);
			}
	}

	@Override
	public void deleteLink(Integer id) throws CustomerExcption {
				linkMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Link> selectAll() throws CustomerExcption {
		// TODO Auto-generated method stub
//		list = linkMapper.selectAll();
//		for (Link link : list) {
//			Integer id = link.getId();
//		}
//		return list;
		
		LinkExample example = new LinkExample();
		List<Link> list = linkMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Link> findLinksByName(String name) throws CustomerExcption {
		// TODO Auto-generated method stub
		name=name==null?"":name.trim();
		LinkExample example = new LinkExample();
		if("".equals(name)) {
			//如果搜索条件为空，返回所有数据
			return linkMapper.selectByExample(example);
		}else {
			//如果条件不为空，返回满嘴条件的数据
		Criteria criteria = example.createCriteria();
		 criteria.andNameLike("%"+name+"%");
		return linkMapper.selectByExample(example);
		}
	}


}
