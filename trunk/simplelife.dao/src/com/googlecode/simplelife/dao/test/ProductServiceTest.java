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

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.googlecode.simplelife.dao.Pagination;

/**
 * 
 * @author Marshal Wu
 *
 */
public class ProductServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:com/googlecode/simplelife/dao/test/config.annotations.xml" };
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		/**
		 * 测试Product的CRUD
		 */
		Product product = new Product();
		product.setName("p1");
		this.productService.save(product);
		assert product.getId() != null;
		assert this.productService.findById(product.getId()) != null;

		product.setName("pp1");
		this.productService.save(product);
		assert this.productService.findById(product.getId()).getName().equals(
				"pp1");

		this.productService.delete(product.getId());
		assert this.productService.findById(product.getId()) == null;

		/**
		 * 测试根据品名和厂商关键字的分页浏览
		 * 
		 * (product.name like '%keyword%' and product.vendor like '%keyword%')
		 */

		// 准备工作
		product = new Product();
		product.setName("p.1");
		this.productService.save(product);

		product = new Product();
		product.setName("%");
		product.setVendor("v1");
		this.productService.save(product);

		product = new Product();
		product.setName("%%");
		product.setVendor("v1");
		this.productService.save(product);
		
		product = new Product();
		product.setName("!");
		product.setVendor("v2");
		this.productService.save(product);
		
		product = new Product();
		product.setName("_");
		product.setVendor("v2");
		this.productService.save(product);

		// 查询product.name为%
		product = new Product();
		product.setName("%");
		Pagination<Product> pagination = new Pagination<Product>();
		pagination.setNo(1);
		pagination.setSize(3);
		pagination.setConditon(product);

		this.productService.browse(pagination);
		assert pagination.getRecordSum() == 2;
		
		// 查询product.name为%, product.vendor为v
		product = new Product();
		product.setName("%");
		product.setVendor("v");
		pagination.setNo(1);
		pagination.setSize(3);
		pagination.setConditon(product);
		
		this.productService.browse(pagination);
		assert pagination.getRecordSum() == 2;
		
		// 查询product.name为%%, product.vendor为v
		product = new Product();
		product.setName("%%");
		product.setVendor("v");
		pagination.setNo(1);
		pagination.setSize(3);
		pagination.setConditon(product);
		
		this.productService.browse(pagination);
		assert pagination.getRecordSum() == 1;
		
		// 查询product.name为p
		product = new Product();
		product.setName("p");
		pagination.setNo(1);
		pagination.setSize(3);
		pagination.setConditon(product);
		
		this.productService.browse(pagination);
		assert pagination.getRecordSum() == 1;
		
		// 查询product.name为_
		product = new Product();
		product.setName("_");
		pagination.setNo(1);
		pagination.setSize(3);
		pagination.setConditon(product);
		
		this.productService.browse(pagination);
		assert pagination.getRecordSum() == 1;
		
		// 查询product.name为!
		product = new Product();
		product.setName("!");
		pagination.setNo(1);
		pagination.setSize(3);
		pagination.setConditon(product);
		
		this.productService.browse(pagination);
		assert pagination.getRecordSum() == 1;

	}

}
