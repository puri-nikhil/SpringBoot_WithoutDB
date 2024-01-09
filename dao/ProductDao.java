package com.jbk.dao;

import java.util.List;

import com.jbk.model.ProductModel;

public interface ProductDao {
	
	public int addProduct(ProductModel productModel);
	
	public ProductModel getProductbByid(long productId);
	
	public int DeleteProductId(long productId);
	
	public List<ProductModel> getAllProducts();
	
	public int updateProduct(ProductModel productModel);
	
	public List<ProductModel> sortProducts(String orderType, String propertyName);
}	

