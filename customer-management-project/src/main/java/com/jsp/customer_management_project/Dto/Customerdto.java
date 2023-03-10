package com.jsp.customer_management_project.Dto;

public class Customerdto {
 private int customerId;
 private String customerName;
 private String customerEamil;
 private long phone;
 private Product product;
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerEamil() {
	return customerEamil;
}
public void setCustomerEamil(String customerEamil) {
	this.customerEamil = customerEamil;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}

}
