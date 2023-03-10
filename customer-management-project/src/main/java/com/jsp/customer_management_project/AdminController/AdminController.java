package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Dto.Admindto;
import com.jsp.customer_management_project.Service.AdminService;
@WebServlet(value="/AdminInsert")
public class AdminController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  int id = Integer.parseInt(req.getParameter("adminId"));
		  String name = req.getParameter("adminName");
		  String email = req.getParameter("adminEmail");
		  Admindto admindto = new Admindto();
		  admindto.setAdminId(id);
		  admindto.setAdminName(name);
		  admindto.setAdminEmail(email);
		  AdminService service = new AdminService();
		  service.adminInsert(admindto);
		  
		  RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		  dispatcher.forward(req, resp);
	}
}
