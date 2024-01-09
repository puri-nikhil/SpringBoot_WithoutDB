package com.jbk.model;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ProductModel {
	
	private long productId;
	
	@NotBlank(message = "Product Name is required")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]{3,50}$", message = "Product name should consist of letters, numbers, and spaces and between 3 to 50 charaters long")
	private String productName;
	
	@Min(1)
	private double productPrice;
	
	@Min(1)
	private int productQty;
	private Date mfgDate;
	private Date expDate;
	private Date createdDate;
	
	
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}

	public ProductModel(long productId, String productName, double productPrice, int productQty, Date mfgDate,
			Date expDate, Date createdDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.createdDate = createdDate;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductQty() {
		return productQty;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public Date getMfgDate() {
		return mfgDate;
	}


	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}


	public Date getExpDate() {
		return expDate;
	}


	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productQty=" + productQty + ", mfgDate=" + mfgDate + ", expDate=" + expDate
				+ ", createdDate=" + createdDate + "]";
	}

		
	
}
