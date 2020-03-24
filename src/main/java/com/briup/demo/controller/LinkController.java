package com.briup.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 和前端交互的web层，与Link连接相关的
 */
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Link;

import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerExcption;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="Link连接相关接口")
public class LinkController {

	@Autowired
	private	ILinkService  linkService;
	
	@PostMapping("/addLink")
	@ApiOperation("Link连接的添加")
	public Message<String> addLink(Link link) {
		
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.Error_CODE, "系统错误:    "+e.getMessage());
		}	
	}
	
	@PostMapping("/updateLink")
	@ApiOperation("Link连接的修改")
	public Message<String> updateLink(Link link) {
		
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		} catch (CustomerExcption e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.Error_CODE, "系统错误:    "+e.getMessage());
		}	
	}
	
	@GetMapping("/deleteLink")
	@ApiOperation("Link连接通过id删除")
	public Message<String> deleteLink(Integer id) {
		
			linkService.deleteLink(id);
			return MessageUtil.success();
	}
	
	@GetMapping("/findLink")
	@ApiOperation("查找所有Link连接")
	public Message<List<Link>> findLink() {
		
			List<Link> selectAll = linkService.selectAll();
			return MessageUtil.success(selectAll);
		
	}
	
	@GetMapping("/findLinkByName")
	@ApiOperation("通过名字Link连接")
	public Message<List<Link>> findLinkByname(String name) {
		
			List<Link> selectAll = linkService.findLinksByName(name);   
			return MessageUtil.success(selectAll);
		
	}
}
