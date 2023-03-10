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

@WebServlet(value="/updateAdmin")
public class UpdateAdminNameEmail extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   AdminService service = new AdminService();
       	int id = Integer.parseInt(req.getParameter("AdminId"));
         Admindto admindto = service.getByIdAdmin(id);
         
         req.setAttribute("oneproduct", admindto);
         RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateAdminNameEmail.jsp");
         dispatcher.forward(req, resp);
    }
}
