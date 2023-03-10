package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/DeleteProduct")
public class DeleteProduct extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("productId"));
		customerService customerService = new customerService();
		customerService.deleteProduct(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayProduct.jsp");
    	dispatcher.forward(req, resp);
	}
}
