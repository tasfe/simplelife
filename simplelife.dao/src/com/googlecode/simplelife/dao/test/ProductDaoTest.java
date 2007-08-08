package com.googlecode.simplelife.dao.test;

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.googlecode.simplelife.dao.Pagination;

/**
 * ProductDao的测试类
 * 
 * @author Marshal Wu
 * 
 * $Id$
 */
public class ProductDaoTest extends
		AbstractDependencyInjectionSpringContextTests {

	private ProductDao productDao;

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:com/googlecode/simplelife/dao/test/config.schema.xml" };
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Test
	public void test() {
		Product product = new Product();
		product.setName("张三");
		this.productDao.create(product);
		assert product.getId() != null;
		assert this.productDao.findById(product.getId()) != null;

		product.setName("李四");
		this.productDao.update(product);
		assert this.productDao.findById(product.getId()).getName().equals("李四");

		this.productDao.delete(product);
		assert this.productDao.findById(product.getId()) == null;

		for (int i = 0; i < 5; i++) {
			product = new Product();
			product.setName("张三");
			this.productDao.create(product);
		}

		Pagination<Product> pagination = new Pagination<Product>();
		pagination.setConditon("张");
		pagination.setNo(1);
		pagination.setSize(2);
		this.productDao.browse(pagination);
		assert pagination.getRecordSum() == 5;
		assert pagination.isFirst();
		assert !pagination.isLast();
		assert pagination.isNext();
		assert !pagination.isPrevious();
		assert pagination.getPageSum() == 3;
		assert pagination.getNo() == 1;
		assert pagination.getResults().size() == 2;

		pagination = new Pagination<Product>();
		pagination.setNo(2);
		pagination.setSize(2);
		this.productDao.browse(pagination);
		assert pagination.getRecordSum() == 5;
		assert !pagination.isFirst();
		assert !pagination.isLast();
		assert pagination.isNext();
		assert pagination.isPrevious();
		assert pagination.getPageSum() == 3;
		assert pagination.getNo() == 2;
		assert pagination.getResults().size() == 2;

		pagination = new Pagination<Product>();
		pagination.setNo(3);
		pagination.setSize(2);
		this.productDao.browse(pagination);
		assert pagination.getRecordSum() == 5;
		assert !pagination.isFirst();
		assert pagination.isLast();
		assert !pagination.isNext();
		assert pagination.isPrevious();
		assert pagination.getPageSum() == 3;
		assert pagination.getNo() == 3;
		assert pagination.getResults().size() == 1;

	}
}
