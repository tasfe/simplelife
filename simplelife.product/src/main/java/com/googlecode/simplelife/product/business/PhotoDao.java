package com.googlecode.simplelife.product.business;

import com.googlecode.simplelife.product.dao.Dao;

public interface PhotoDao extends Dao<Photo, String> {
	public void delete(Product product);
	
	public Photo findByProductId(String id);
}
