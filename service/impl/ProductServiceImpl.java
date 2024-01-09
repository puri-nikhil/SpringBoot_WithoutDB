package com.jbk.service.impl;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jbk.dao.ProductDao;
import com.jbk.dao.impl.ProductDaoImpl;
import com.jbk.model.ProductModel;
import com.jbk.service.ProductService;

public  class ProductServiceImpl implements ProductService {
	
	ProductDao dao = new ProductDaoImpl();
	
	@Override
	public int addProduct(ProductModel productModel) {
		
//		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
//		
//		productModel.setProductId(Long.parseLong(productId));
//		
		
	      java.sql.Date CreatedDate=new java.sql.Date(System.currentTimeMillis());

	      productModel.setCreatedDate(CreatedDate);
	      
		return dao.addProduct(productModel);
	}

	@Override
	public ProductModel getProductbByid(long productId) {
		 
		
		return dao.getProductbByid(productId);
	}

	@Override
	public int DeleteProductId(long productId) {
		
		
		return dao.DeleteProductId(productId); 
		
	}

	@Override
	public List<ProductModel> getAllProducts() {
		
		return dao.getAllProducts();
	}

	@Override
	public int updateProduct(ProductModel productModel) {
		
		int status = 0;
		
		ProductModel dbProduct = getProductbByid(productModel.getProductId());
		
		if(dbProduct != null) {
			
			status = dao.updateProduct(productModel);
			
		}else {
			
			status = 2;
		}
		
		return status;
	}

	@Override
	public List<ProductModel> sortProducts(String orderType, String propertyName) {
		
		List<ProductModel> list = getAllProducts();
		
		Comparator<ProductModel> comparator = null;
		
		if(!list.isEmpty()) {
			
		switch (propertyName) {
		case "productName":{
			
			comparator = Comparator.comparing(ProductModel:: getProductName);
			break;
		}
		case "productPrice": 
		{
			comparator = Comparator.comparing(ProductModel:: getProductPrice);

			break;
		}
		default:
			
			comparator = Comparator.comparing(ProductModel:: getProductId);

			break;
		}
		
		if(orderType.equalsIgnoreCase("desc")) {
			
			comparator = comparator.reversed();
		}
		
		Stream<ProductModel> sorted = list.stream().sorted(comparator);
		list = sorted.collect(Collectors.toList());
		
	}else {
		
		return list;
	}
		
		return list;
	

	}
} 
 