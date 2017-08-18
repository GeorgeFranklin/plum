package com.blackunion.george.plum.pojo.dto;

/**
 * 订单实体类
 * @author george
 * @date 2017年8月16日
 *
 */
public class OrderDTO {

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", name=" + name + "]";
	}
	
}
