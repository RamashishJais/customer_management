package com.jsp.customer_management_project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.customer_management_project.Connection.MakeConnection;
import com.jsp.customer_management_project.Dto.Admindto;

public class Admindao {
//adminInsert method
	public Admindto adminInsert(Admindto admindto) {
		Connection conn = MakeConnection.getConnection();
		String insertAdmin = "Insert into admin values(?,?,?)";
		try {
			PreparedStatement presmt = conn.prepareStatement(insertAdmin);
			presmt.setInt(1, admindto.getAdminId());
			presmt.setString(2, admindto.getAdminName());
			presmt.setString(3, admindto.getAdminEmail());
			
			presmt.execute();
			return admindto;
		} 
		catch(SQLException e ) {
			e.printStackTrace();
		}
		return admindto;
	}
	//AdminGet by name method 
	public String getByName(String adminName) {
		Connection conn = MakeConnection.getConnection();
		String getName = "Select * from admin where AdminName=?";
		try {
			PreparedStatement presm = conn.prepareStatement(getName);
			presm.setString(1, adminName);
		ResultSet res=	 presm.executeQuery();
		while(res.next()) {
			int id1 = res.getInt("AdminId");
		String	 name1 = res.getString("AdminName");
			String email = res.getString("AdminEmail");
			
			return name1;
		}
		
	   
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}
	//AdminGet by email method
	public String getByEmail (String adminEmail) {
		Connection conn = MakeConnection.getConnection();
		String getEmail = "Select * from admin where AdminEmail=?";
		
		try {
			PreparedStatement pres = conn.prepareStatement(getEmail);
			pres.setString(1, adminEmail);
			ResultSet res = pres.executeQuery();
			while(res.next()) {
				int id1 = res.getInt("AdminId");
			String	 name1 = res.getString("AdminName");
				String email = res.getString("AdminEmail");
				
				return email;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//AdminDelete method by the by id
	
	public void adminDelete(int id) {
	  Connection conn =	MakeConnection.getConnection();
	  String admindelete = "Delete from admin where AdminId=?";
	  try {
		  PreparedStatement prewsmt = conn.prepareStatement(admindelete);
		  prewsmt.setInt(1, id);
		 int id1= prewsmt.executeUpdate();
		 if(id1>0) {
				System.out.println("Data is Deleted");
			} else {
				System.out.println("Data is not deleted");
			} 
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
	
	}
	//display method in Admin
	public List<Admindto> displayAdmin() {
		Connection conn = MakeConnection.getConnection();
		List<Admindto> admins = new ArrayList();
		
		String displayAdmin = "Select * from admin";
		 try {
			 PreparedStatement pres = conn.prepareStatement(displayAdmin);
			 ResultSet res = pres.executeQuery();
			 while(res.next()) {
				 Admindto admindto = new Admindto();
				admindto.setAdminId(res.getInt("AdminId"));
				admindto.setAdminName(res.getString("AdminName"));
				admindto.setAdminEmail(res.getString("AdminEmail"));
				admins.add(admindto);
			 }
			 return admins;
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return admins;
	}
	//update method in Admin 
	public int updateAdmin(Admindto admindto) {
		Connection conn= MakeConnection.getConnection();
		String Updateadmin = "Update admin set AdminName=?, AdminEmail=? where AdminId=?";
		 try {
			PreparedStatement  pres = conn.prepareStatement(Updateadmin);
			pres.setString(1, admindto.getAdminName());
			pres.setString(2, admindto.getAdminEmail());
			pres.setInt(3, admindto.getAdminId());
			pres.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//get by Id in admin
	
	public Admindto getByIdAdmin(int id) {
		Connection conn = MakeConnection.getConnection();
		String getById = "Select * from admin where AdminId=?";
		try {
			PreparedStatement pres = conn.prepareStatement(getById);
			pres.setInt(1, id);
			ResultSet res = pres.executeQuery();
			res.next();
				Admindto admindto = new Admindto();
				admindto.setAdminId(res.getInt("AdminId"));
				admindto.setAdminName(res.getString("AdminName"));
				admindto.setAdminEmail(res.getString("AdminEmail"));
				return admindto;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
