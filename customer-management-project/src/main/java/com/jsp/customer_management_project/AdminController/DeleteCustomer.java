package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("customerId"));
		System.out.println(id);
		customerService customerService= new customerService();
		customerService.deleteCustomer(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayCustomer.jsp");
		dispatcher.forward(req, resp);
	}
}
