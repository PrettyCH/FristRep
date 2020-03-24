package com.briup.demo.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.Link;

/**
 * 保存首页的所有数据
 * @author Shinelon
 *
 */
public class IndexResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<CategoryEx> categroys;
	private List<Link> links;
	
	@Override
	public String toString() {
		return "IndexResult [categroys=" + categroys + ", links=" + links + "]";
	}
	public List<CategoryEx> getCategroys() {
		return categroys;
	}
	public void setCategroys(List<CategoryEx> categroys) {
		this.categroys = categroys;
	}
	public List<Link> getList() {
		return links;
	}
	public void setList(List<Link> list) {
		this.links = list;
	}
	public IndexResult(List<CategoryEx> categroys, List<Link> list) {
		super();
		this.categroys = categroys;
		this.links = list;
	}
	public IndexResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
