package com.googlecode.simplelife.dao.test;

import com.googlecode.simplelife.dao.Pagination;

/**
 * 商品服务接口
 * 
 * @author Marshal Wu
 * 
 * $Id$
 */
public interface ProductService {
	public void save(Product product);

	public void delete(Long id);

	public Product findById(Long id);

	public void browse(Pagination<Product> pagination);
}
