package com.jsp.customer_management_project.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management_project.Service.AdminService;

@WebServlet(value="/deleteAdmin")
public class DeleteAdmin extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id = Integer.parseInt(req.getParameter("AdminId"));
    	AdminService service = new AdminService();
    	service.adminDelete(id);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayAdmin.jsp");
    	dispatcher.forward(req, resp);
    }
}
