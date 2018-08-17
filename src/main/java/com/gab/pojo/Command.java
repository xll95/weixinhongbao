package com.gab.pojo;

import java.io.Serializable;

public class Command implements Serializable {
	
	private Integer id;
	private String title;//标题
	private String content;//内容
	private Integer sort;//点击量
	private Integer status;//状态
	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Command(Integer id, String title, String content, Integer sort, Integer status) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.sort = sort;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "command [id=" + id + ", title=" + title + ", content=" + content + ", sort=" + sort + ", status="
				+ status + "]";
	}
	
	

}
