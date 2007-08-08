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

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.simplelife.dao.CriteriaCallBack;
import com.googlecode.simplelife.dao.DaoUtil;
import com.googlecode.simplelife.dao.Pagination;

/**
 * 
 * @author Marshal Wu
 *
 * $Id$
 */
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public void browse(final Pagination<Product> pagination) {
		final Product product = (Product) pagination.getConditon();
		product.setName(DaoUtil.getLikeString(product.getName(), "!"));
		product.setVendor(DaoUtil.getLikeString(product.getVendor(), "!"));

		pagination.setConditon(new CriteriaCallBack() {

			/**
			 * Sets the criteria.
			 * 
			 * @param criteria
			 *            the criteria
			 */
			@Override
			public void setCriteria(Criteria criteria) {
				Example example = Example.create(product);
				example.enableLike(MatchMode.ANYWHERE).setEscapeCharacter('!')
						.ignoreCase().excludeProperty("id");
				criteria.add(example);
			}
		});

		this.productDao.browse(pagination);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		Product product = this.findById(id);

		if (product != null) {
			this.productDao.delete(product);
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Product findById(Long id) {
		return this.productDao.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Product product) {
		this.productDao.saveOrUpdate(product);
	}

}
