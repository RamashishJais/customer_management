package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Customerdto;
import com.jsp.customer_management_project.Dto.Product;
import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/AddCustomer")
public class AddCustomer  extends HttpServlet{
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("customerId"));
		String name1 = req.getParameter("customerName");
		String email2 = req.getParameter("customerEmail");
		long phone = Long.parseLong(req.getParameter("customerPhone"));
		int id2 = Integer.parseInt(req.getParameter("productId")); 
		System.out.println(id+"\n"+name1+"\n"+email2+"\n"+phone+"\n"+id2+"\n");
		
		customerService customerService = new customerService();
		Customerdto customerdto = new Customerdto();
		customerdto.setCustomerId(id);
		customerdto.setCustomerName(name1);
		customerdto.setCustomerEamil(email2);
		customerdto.setPhone(phone);
		Product product = new Product();
		product.setProductId(id2);
		customerdto.setProduct(product);
		customerService.insertCustomer(customerdto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("CustomerLogin.jsp");
		dispatcher.forward(req, resp);
		
	}
}
