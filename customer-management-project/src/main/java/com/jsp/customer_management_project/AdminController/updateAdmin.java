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

@WebServlet(value="/UpdateAdminName")
public class updateAdmin extends HttpServlet  {
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admindto admindto = new Admindto();
		  admindto.setAdminId(Integer.parseInt(req.getParameter("adminId")));
		  admindto.setAdminName(req.getParameter("adminName"));
		  admindto.setAdminEmail(req.getParameter("adminEmail"));
		  
		  AdminService adminService = new AdminService();
		  adminService.updateAdmin(admindto);
		  RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayAdmin.jsp");
		  dispatcher.forward(req, resp);
		  
	}
}
