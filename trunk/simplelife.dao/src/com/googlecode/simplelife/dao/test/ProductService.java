package com.googlecode.simplelife.dao.test;

import com.googlecode.simplelife.dao.Pagination;

public interface ProductService {
	public void save(Product product);

	public void delete(Long id);

	public Product findById(Long id);

	public void browse(Pagination<Product> pagination);
}
