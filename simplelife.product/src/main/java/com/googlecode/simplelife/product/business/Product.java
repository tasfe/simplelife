package com.googlecode.simplelife.product.business;

import java.text.MessageFormat;
import java.util.Date;

public class Product {
	// ID
	private String id;

	// 商品名称
	private String name;

	// 价格
	private float price;

	// 供货商
	private String vendor;

	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null && !id.trim().isEmpty()) {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return MessageFormat.format(
				"[ID:{0}, name:{1}, price:{2}, vendor:{3}]", this.id,
				this.name, this.price, this.vendor);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
