package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Customerdto;
import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/updateCustomer")
public class UpdateCustomer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("customerId"));
		customerService service = new customerService();
		 Customerdto customerdto= service.getById(id);
		 req.setAttribute("oneCustomer", customerdto);
         RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateCustomer.jsp");
         dispatcher.forward(req, resp);
	}
	
}
