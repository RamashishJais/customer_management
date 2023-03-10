package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Product;
import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/updateProduct")
public class UpdateProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("productId"));
		System.out.println(id);
		customerService service = new customerService();
		Product product = service.getByIdprodcut(id);
		req.setAttribute("oneproduct1", product);
		RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateProduct.jsp");
		dispatcher.forward(req, resp);
		
	}
}
