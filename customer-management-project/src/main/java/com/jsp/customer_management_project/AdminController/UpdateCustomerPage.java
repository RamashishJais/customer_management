package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Customerdto;
import com.jsp.customer_management_project.Dto.Product;
import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/UpdateCustomer")
public class UpdateCustomerPage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customerdto customerdto = new Customerdto();
		Product product = new Product();
	   customerdto.setCustomerId(Integer.parseInt(req.getParameter("customerId")));	
		customerdto.setCustomerName( req.getParameter("customerName"));
		customerdto.setCustomerEamil(req.getParameter("customerName"));
		customerdto.setPhone(Long.parseLong(req.getParameter("customerPhone")));
		product.setProductId(Integer.parseInt(req.getParameter("productId")));
	    customerdto.setProduct(product);
		customerService service = new customerService();
		service.UpdateCustomer(customerdto);
		
	}
}
