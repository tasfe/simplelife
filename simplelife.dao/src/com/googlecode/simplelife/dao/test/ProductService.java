/*
 * Copyright 2007 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *      
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.simplelife.dao.test;

import com.googlecode.simplelife.dao.Pagination;

/**
 * 商品服务接口.
 * 
 * @author Marshal Wu
 * 
 * $Id$
 */
public interface ProductService {
	
	/**
	 * Save.
	 * 
	 * @param product the product
	 */
	public void save(Product product);

	/**
	 * Delete.
	 * 
	 * @param id the id
	 */
	public void delete(Long id);

	/**
	 * Find by id.
	 * 
	 * @param id the id
	 * 
	 * @return the product
	 */
	public Product findById(Long id);

	/**
	 * Browse.
	 * 
	 * @param pagination the pagination
	 */
	public void browse(Pagination<Product> pagination);
}
