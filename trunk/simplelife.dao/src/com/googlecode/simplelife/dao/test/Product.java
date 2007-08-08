package com.googlecode.simplelife.dao.test;

/**
 * 商品
 * 
 * @author Marshal Wu
 * 
 * $Id$
 */
public class Product {
	private String name;

	private Long id;

	private String vendor;

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
