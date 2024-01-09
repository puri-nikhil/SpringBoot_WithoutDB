package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ProductAlreadyExistException;
import com.jbk.model.ProductModel;
import com.jbk.service.ProductService;
import com.jbk.service.impl.ProductServiceImpl;

@RestController
public class ProductController {

//	private static final ProductModel[] list = null;
	ProductService service = new ProductServiceImpl();
	
	// add product
	 @PostMapping(value = "/addproduct", produces = "application/json")
	public String addProduct(@RequestBody @Valid ProductModel productModel)
	{
		 
		 int status = service.addProduct(productModel);
		 if(status == 1)
		 {
			 return "Added Successfully !!";
		 }
		 else if(status == 2)
		 {
			 throw new ProductAlreadyExistException("Product Already Exists Product Name = "+ productModel.getProductName());
		 }
		 else
		 {  
			 return "Something Went Wrong";
		 }	 
	}
	 
	 @GetMapping("/get-product-by-id/{productId}")
	 
	 public Object getProductbByid(@PathVariable long productId)
	 {
		 
		ProductModel productModel = service.getProductbByid(productId);
		if(productModel != null)
		{
			return productModel;
		}
		else
		{		 
		return "Product Not Found with Id = "+ productId;
		
		} 
	 } 
	 
	 @DeleteMapping("/DeleteProductId/{productId}")
	 
	public String DeleteProductId(@RequestParam long productId)
	{ 
		 int status = service.DeleteProductId(productId); // shortcut key alt + shift + L
		 
		 if(status == 1)
		 {
			 return "Deleted Successfully";
		 }else if(status == 2)
		 {
			 return "Product not exists to delete " + productId;
		 }else
		 {
			 return "Something went Wrong";
		 }
 
	}
	
	 @GetMapping("get-All-Products")
	 
	 public Object getAllProducts()
	 {
		 List<ProductModel> list = service.getAllProducts();
		 
		 if(list!=null && !list.isEmpty())
		 {
			 return list;
		 }else {
			 
		return "Product Not Found";
		 } 
	 }

	 @PutMapping("update-product")
	 
	 public String updateProduct(@RequestBody ProductModel productModel)
	 {	
		 int status = service.updateProduct(productModel);
		 
		 if(status == 1)
		 {
			 return "Updated Successfully";
		 }
		 else if(status == 2)
		 {
			 return "Product not exists to update "+ productModel.getProductId();
		 }
		 else {
			 return "Something Went Wrong";
		 }
		 	 
	 }
	 
	 @GetMapping("sort-product/{orderType}/{propertyName}")
	 
	 public Object sortProduct(@PathVariable String orderType, @PathVariable String propertyName) {
		 
		List<ProductModel> list = service.sortProducts(orderType, propertyName);
		 
		 if(list!=null && !list.isEmpty())
		 {
			 return list;
		 }else {
			 
		return "Product Not Found";
		 
	 }
	}
} 
	 	  
