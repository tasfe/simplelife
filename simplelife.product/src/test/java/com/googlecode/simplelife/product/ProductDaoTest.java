package com.googlecode.simplelife.product;

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.googlecode.simplelife.product.business.Product;
import com.googlecode.simplelife.product.business.ProductDao;

public class ProductDaoTest extends
		AbstractDependencyInjectionSpringContextTests {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:com/googlecode/simplelife/product/config.xml" };
	}

	@Test
	public void test() {
		Product product=new Product();
		product.setName("p");
		product.setPrice(111);
		
		this.productDao.saveOrUpdate(product);
		assert product.getId()!=null;
		assert this.productDao.findById(product.getId())!=null;
		
		product.setPrice(112);
		this.productDao.saveOrUpdate(product);
		assert this.productDao.findById(product.getId()).getPrice()==112;
		
		this.productDao.delete(product);
		assert this.productDao.findById(product.getId())==null;
	}
}
