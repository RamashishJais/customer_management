package com.jsp.customer_management_project.Service;

import java.util.List;

import com.jsp.customer_management_project.Dao.CustomerDao;
import com.jsp.customer_management_project.Dto.Customerdto;
import com.jsp.customer_management_project.Dto.Product;

public class customerService {
        CustomerDao dao = new CustomerDao();
        public Customerdto insertCustomer(Customerdto customerdto) {
        	return dao.insertCustomer(customerdto);
        }
        public Product insertProduct(Product product) {
        	return dao.insertProduct(product);
        }
    	public List<Customerdto> displayCustomer() {
    		return dao.displayCustomer();
    	}
    	public List<Product> displayProduct() {
    		return dao.displayProduct();
    	}
    	 public void deleteProduct(int id) {
    		  dao.deleteProduct(id);
    	 }
    	 public void deleteCustomer(int id) {
    		  dao.deleteCustomer(id);
    	 }
    	 
    		public void UpdateCustomer(Customerdto customerdto) {
    			dao.UpdateCustomer(customerdto);
    		}
    	 	public void updateProdcut (Product product) {
    	 		dao.updateProdcut(product);
    	 	}
    	 	 public Product getByIdprodcut(int id)  {
    	 		return dao.getByIdprodcut(id);
    	 	 }
    	 	 public Customerdto getById(int id) {
    	 		 return dao.getById(id);
    	 	 }
    	 	 public String getByName(String cusmtomername) {
    	 		 return dao.getByName(cusmtomername);
    	 	 }
    	 	  public String getByEmail(String cusmtomeremail) {
    	 		  return dao.getByEmail(cusmtomeremail);
    	 	  }
    	
}
