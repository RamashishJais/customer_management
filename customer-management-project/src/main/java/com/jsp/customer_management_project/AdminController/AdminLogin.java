package com.jsp.customer_management_project.AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.customer_management_project.Service.AdminService;
@WebServlet(value="/adminLogin")
public class AdminLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Username");
		String email = req.getParameter("Useremail");
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		AdminService service = new AdminService();
		String name1 = service.getByName(name);
		String email2 = service.getByEmail(email);
		System.out.println("Name1 : "+name1);
		System.out.println("Email2 : "+email2);
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		out.write("<html><body>");
		if(name.equals(name1) && email.equals(email2)) {
			session.setAttribute("loginobj", name);
			resp.sendRedirect("CustomerLogin.jsp");
//			RequestDispatcher dispatcher = req.getRequestDispatcher("CustomerLogin.jsp");
//			dispatcher.forward(req, resp);
			
			
		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("AdminLogin.jsp");
		}
		out.write("</html></body>");
	}

}
