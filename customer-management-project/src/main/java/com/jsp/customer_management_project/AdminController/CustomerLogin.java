package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.customer_management_project.Service.customerService;

@WebServlet(value="/customerLogin")
public class CustomerLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("customerName");
		String email = req.getParameter("email");
		customerService service = new customerService();
		String name1 = service.getByName(name);
		String email2 = service.getByEmail(email);
		HttpSession session = req.getSession();
		if(name.equals(name1)&&email.equals(email2)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("AddProduct.jsp");
			dispatcher.forward(req, resp);
			
		}
		else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("AdminLogin.jsp");
		
		}
	}
}
