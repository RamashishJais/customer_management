package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Product;
import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/UpdateProduct1")
public class UpdateproductPage  extends HttpServlet {
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		product.setProductId(Integer.parseInt(req.getParameter("productId1")));
		product.setProductName(req.getParameter("productName"));
		product.setProductPrice(Long.parseLong(req.getParameter("productPrice")));
		product.setProductAvailble(req.getParameter("aviable"));
		customerService service = new customerService();
		service.updateProdcut(product);
	}
}
