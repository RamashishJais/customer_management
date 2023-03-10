package com.jsp.customer_management_project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.customer_management_project.Connection.MakeConnection;
import com.jsp.customer_management_project.Dto.Customerdto;
import com.jsp.customer_management_project.Dto.Product;

public class CustomerDao {
    Customerdto customerdto = new Customerdto();
    Product product = new Product();
    Connection conn = null;
    PreparedStatement prestmt = null;
    
    //customer insert method
    public Customerdto insertCustomer(Customerdto customerdto) {
             conn= MakeConnection.getConnection();
             String insertCusto = "Insert into customer values(?,?,?,?,?)";
             String insertPro = "Insert into product values(?,?,?,?)";
             try {
				prestmt = conn.prepareStatement(insertCusto);
				prestmt.setInt(1, customerdto.getCustomerId());
				prestmt.setString(2, customerdto.getCustomerName());
				prestmt.setString(3, customerdto.getCustomerEamil());
				prestmt.setLong(4, customerdto.getPhone());
				prestmt.setInt(5, customerdto.getProduct().getProductId());
              prestmt.execute();
			return customerdto;
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return customerdto;
    }
    // get by Name method
    public String getByName(String cusmtomername) {
		Connection conn = MakeConnection.getConnection();
		String getName = "Select * from customer where customerName=?";
		try {
			PreparedStatement presm = conn.prepareStatement(getName);
			presm.setString(1, cusmtomername);
		ResultSet res=	 presm.executeQuery();
		while(res.next()) {
			int id1 = res.getInt("customerId");
		String	 name1 = res.getString("customerName");
			String email = res.getString("customerEmail");
			long phone = res.getLong("customerPhone");
			
			return name1;
		}
		
	   
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}
	
    // get by Email method
    public String getByEmail(String cusmtomeremail) {
		Connection conn = MakeConnection.getConnection();
		String getName = "Select * from customer where customerEmail=?";
		try {
			PreparedStatement presm = conn.prepareStatement(getName);
			presm.setString(1, cusmtomeremail);
		ResultSet res=	 presm.executeQuery();
		while(res.next()) {
			int id1 = res.getInt("customerId");
		String	 name1 = res.getString("customerName");
			String email = res.getString("customerEmail");
			long phone = res.getLong("customerPhone");
			
			return email;
		}
		
	   
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}
    //method get by Id customer
    public Customerdto getById(int id) {
		Connection conn = MakeConnection.getConnection();
		String getName = "Select * from customer where customerId=?";
		try {
			PreparedStatement presm = conn.prepareStatement(getName);
			presm.setInt(1, id);
		ResultSet res=	 presm.executeQuery();
		while(res.next()) {
			Customerdto customerdto = new Customerdto();
			Product product = new Product();
			customerdto.setCustomerId(res.getInt("customerId"));;
			customerdto.setCustomerName(res.getString("customerName"));
			customerdto.setCustomerEamil(res.getString("customerEmail"));
			customerdto.setPhone(res.getLong("customerPhone"));
			product.setProductId(res.getInt("productId"));
			customerdto.setProduct(product);
			return customerdto;
		}
		
	   
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return customerdto;
	}
    //method get by Id product
    public Product getByIdprodcut(int id)  {
    	conn = MakeConnection.getConnection();
    	String getByIdPro = "Select * from product where productId=?";
    	
    	try {
    		prestmt = conn.prepareStatement(getByIdPro);
    		prestmt.setInt(1, id);
    	ResultSet res=	prestmt.executeQuery();
    		while(res.next()) {
    			Product product =new  Product();
    	       product.setProductId(res.getInt("productId"));
    		   product.setProductName(res.getString("prodcutName"));
    		   product.setProductPrice(res.getLong("productPrice"));
    			product.setProductAvailble(res.getString("productPrice"));
    			return product;
    		}
    		
    	} 
    	catch (SQLException e ) {
    		e.printStackTrace();
    	}
		return product;
    	
    }
    //method getProdcut name
    public String  getByNameprodcut(String name)  {
    	conn = MakeConnection.getConnection();
    	String getByNamePro = "Select * from product where productName=?";
    	
    	try {
    		prestmt = conn.prepareStatement(getByNamePro);
    		prestmt.setString(1, name);
    	ResultSet res=	prestmt.executeQuery();
    		while(res.next()) {
    			int id1 = res.getInt("productId");
    			String  name1 = res.getString("prodcutName");
    			long price = res.getLong("productPrice");
    			String avble = res.getString("availabiltty");
    			return name1;
    		}
    	} catch (SQLException e ) {
    		e.printStackTrace();
    	}
		return null;
    }
    //method getProduct price 
    public long getByPricerodcut(long price)  {
    	conn = MakeConnection.getConnection();
    	String getByPricePro = "Select * from product where productPrice=?";
    	
    	try {
    		prestmt = conn.prepareStatement(getByPricePro);
    		prestmt.setLong(1, price);
    	ResultSet res=	prestmt.executeQuery();
    		while(res.next()) {
    			int id1 = res.getInt("productId");
    			String  name = res.getString("prodcutName");
    			long price1 = res.getLong("productPrice");
    			String avble = res.getString("availabiltty");
    			return price1;
    		}
    	} catch (SQLException e ) {
    		e.printStackTrace();
    	}
		return 0;
    }
    
//    method getProdcut available
    public String  getByavailableprodcut(String available)  {
    	conn = MakeConnection.getConnection();
    	String getByavailablePro = "Select * from product where availabiltty=?";
    	
    	try {
    		prestmt = conn.prepareStatement(getByavailablePro);
    		prestmt.setString(1, available);
    	ResultSet res=	prestmt.executeQuery();
    		while(res.next()) {
    			int id1 = res.getInt("productId");
    			String  name1 = res.getString("prodcutName");
    			long price = res.getLong("productPrice");
    			String avble = res.getString("availabiltty");
    			return avble;
    		}
    	} catch (SQLException e ) {
    		e.printStackTrace();
    	}
		return null;
    }
    //customer delete method
    public void deleteCustomer(int id) {
    	conn = MakeConnection.getConnection();
    	String deletecustomer ="Delete from customer where customerId=?";
    	
    	try {
			prestmt = conn.prepareStatement(deletecustomer);
			prestmt.setInt(1, id);
			prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //product delete method
    public void deleteProduct(int id) {
    	conn = MakeConnection.getConnection();
    	String deleteproduct ="Delete from product where productId=?";
    	
    	try {
			prestmt = conn.prepareStatement(deleteproduct);
			prestmt.setInt(1, id);
			prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //Insert product method
    public Product insertProduct(Product product) {
        conn= MakeConnection.getConnection();
//        String insertCusto = "Insert into customer values(?,?,?,?,?)";
        String insertPro = "Insert into product values(?,?,?,?)";
        try {
			prestmt = conn.prepareStatement(insertPro);
			prestmt.setInt(1, product.getProductId());
			prestmt.setString(2, product.getProductName());
			prestmt.setLong(3, product.getProductPrice());
			prestmt.setString(4, product.getProductAvailble());
         prestmt.execute();
		return product;
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
}
  //display method in customer
  	public List<Customerdto> displayCustomer() {
  		Connection conn = MakeConnection.getConnection();
  		List<Customerdto> customerdtos = new ArrayList();
  		
  		String displayCustomer = "Select * from customer";
  		 try {
  			 PreparedStatement pres = conn.prepareStatement(displayCustomer);
  			 ResultSet res = pres.executeQuery();
  			 while(res.next()) {
  				Customerdto customerdto = new Customerdto();
  				Product product = new Product();
  				customerdto.setCustomerId(res.getInt("customerId"));
  				customerdto.setCustomerName(res.getString("customerName"));
  				customerdto.setCustomerEamil(res.getString("customerEmail"));
  				customerdto.setPhone(res.getLong("customerPhone"));
  				product.setProductId(res.getInt("productId"));
  				customerdto.setProduct(product);
  				customerdtos.add(customerdto);
  			 }
  			 return customerdtos;
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 }
  		return customerdtos;
  	}
  	//Display method for product
  	public List<Product> displayProduct() {
  		Connection conn = MakeConnection.getConnection();
  		List<Product> products = new ArrayList();
  		
  		String displayProduct = "Select * from product";
  		 try {
  			 PreparedStatement pres = conn.prepareStatement(displayProduct);
  			 ResultSet res = pres.executeQuery();
  			 while(res.next()) {
  				Product product = new Product();
  				product.setProductId(res.getInt("productId"));
  				product.setProductName(res.getString("productName"));
  				product.setProductPrice(res.getLong("productPrice"));
  				product.setProductAvailble(res.getString("availabiltty"));
  				products.add(product);
  			 }
  			 return products;
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 }
  		return products;
  	}
  	//Update method for Customer
  	public void UpdateCustomer(Customerdto customerdto) {
  		conn = MakeConnection.getConnection();
  		String updatecustomer = "Update customer set customerName=?, customerEmail=?, customerPhone=? where customerId=?";
  		 try {
  			 PreparedStatement pres = conn.prepareStatement(updatecustomer);
  			 pres.setInt(4, customerdto.getCustomerId());
  			 pres.setLong(3, customerdto.getPhone());
  			 pres.setString(2, customerdto.getCustomerEamil());
  			 pres.setString(1, customerdto.getCustomerName());
  			 pres.executeUpdate();
  		 } catch(SQLException e ) {
  			 e.printStackTrace();
  		 }
  	}
  	//update method for Product
  	public void updateProdcut (Product product) {
  		conn = MakeConnection.getConnection();
  		String updateproduct = "Update product set productName=?, productPrice=?, availabiltty=? where productId=?";
  		  
  		try {
  			prestmt = conn.prepareStatement(updateproduct);
  			prestmt.setInt(4, product.getProductId());
  			prestmt.setString(3, product.getProductAvailble());
  			prestmt.setLong(2, product.getProductPrice());
  			prestmt.setString(1, product.getProductName());
  			prestmt.executeUpdate();
  		} catch(SQLException e ) {
 			 e.printStackTrace();
 		 }
  	}
}
