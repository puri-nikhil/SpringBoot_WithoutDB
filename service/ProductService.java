package com.jbk.service;

import java.util.List;

import com.jbk.model.ProductModel;

public interface ProductService {
	
	public int addProduct(ProductModel productModel);
	
	public ProductModel getProductbByid(long productId);
	
	public List<ProductModel> getAllProducts();
	
	public int DeleteProductId (long productId);
	
	public int updateProduct(ProductModel productModel);

	public List<ProductModel> sortProducts(String orderType, String propertyName);
}
