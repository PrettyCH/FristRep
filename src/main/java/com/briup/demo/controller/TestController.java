package com.briup.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="测试接口")
public class TestController {
		
		//@RequestMapping(value="/test",method=RequestMethod.GET)
		@GetMapping
		@ApiOperation("无敌接口")
		public String test() {
			return "as54d65as1d65asd";
			
		}
}
