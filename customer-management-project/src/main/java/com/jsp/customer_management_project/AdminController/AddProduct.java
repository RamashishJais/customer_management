package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Product;
import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/AddProduct")
public class AddProduct extends HttpServlet{
     
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("productId"));
		String pname = req.getParameter("productName");
		long price = Long.parseLong(req.getParameter("productPrice"));
		String avible = req.getParameter("aviable");
		Product product = new Product();
		product.setProductId(id);
		product.setProductName(pname);
		product.setProductPrice(price);
		product.setProductAvailble(avible);
		customerService service = new customerService();
		service.insertProduct(product);
	}
}
