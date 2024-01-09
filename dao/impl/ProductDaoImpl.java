package com.jbk.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jbk.dao.ProductDao;
import com.jbk.model.ProductModel;

public class ProductDaoImpl implements ProductDao {

	
	List<ProductModel> list = new ArrayList<>();
	
	public ProductDaoImpl() {
		
		list.add(new ProductModel(1l, "Pen", 10d, 100, new Date(2023, 12, 13), new Date(2024, 12, 13), new Date(2023, 12, 13)));
		list.add(new ProductModel(2l, "Pencil", 10d, 100, new Date(2023, 12, 13), new Date(2024, 12, 13), new Date(2023, 12, 13)));
		list.add(new ProductModel(3l, "book", 10d, 100, new Date(2023, 12, 13), new Date(2024, 12, 13), new Date(2023, 12, 13)));
		
	}
	
	@Override
	public int addProduct(ProductModel productModel) {
		
		 int status = 0;
		 for(ProductModel prd : list)
		 {
			 if(prd.getProductName().equals(productModel.getProductName()))
			 {
				 status = 2;
				 break;
			 }
		 }
		 if(status != 2)
		 {
			 
				 try {
					 list.add(productModel);
					 status = 1;
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
					 status = 3;
					 
				 }
			 }
		 	
		 for (ProductModel listproductModel : list) {
			 
			 System.out.println(listproductModel);
		}
		 
		return status;
	}

	@Override
	public ProductModel getProductbByid(long productId) {
		
		for (ProductModel productModel : list) {
			
			if(productModel.getProductId() == productId)
			{
				return productModel;
			}
		}
		
		return null;
	}

	@Override
	public int DeleteProductId(long productId) {
		
		int status = 0;
		Iterator<ProductModel> itr = list.iterator();
		while(itr.hasNext())
		{
			ProductModel productModel = (ProductModel) itr.next();
			
			try
			{
				if(productModel.getProductId() == productId)
				{
					itr.remove();
					status = 1;
					break;
				}
			}
			catch(Exception e)
			{
				status = 3;
			}
		}
		if(status !=1)
		{
			status = 2;
		}
		
		return status ;
		 
	}

	@Override
	public List<ProductModel> getAllProducts() {
	
		return list;
	}

	@Override
	public int updateProduct(ProductModel productModel) {
		
		int status = 0;
		
		try {
			for (ProductModel dbProduct : list) {
				if(dbProduct.getProductId() == productModel.getProductId()) {
					
					list.set(list.indexOf(dbProduct), productModel);
					status = 1;
				}
				
			}
		}catch(Exception e) {
			
			status = 3;
		}
		
		return status;
	}

	@Override
	public List<ProductModel> sortProducts(String orderType, String propertyName) {
		
		
		return null;
	}

}
