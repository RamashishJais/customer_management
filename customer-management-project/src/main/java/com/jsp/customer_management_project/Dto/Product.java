package com.jsp.customer_management_project.Dto;

public class Product {
 private int productId;
 private String productName;
 private long productPrice;
 private String productAvailble;
 
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductAvailble() {
	return productAvailble;
}
public void setProductAvailble(String productAvailble) {
	this.productAvailble = productAvailble;
}
public long getProductPrice() {
	return productPrice;
}
public void setProductPrice(long productPrice) {
	this.productPrice = productPrice;
}
}
