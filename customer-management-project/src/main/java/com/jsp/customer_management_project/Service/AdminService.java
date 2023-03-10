package com.jsp.customer_management_project.Service;

import java.util.List;

import com.jsp.customer_management_project.Dao.Admindao;
import com.jsp.customer_management_project.Dto.Admindto;

public class AdminService {
	Admindao admindao = new Admindao();
	public Admindto adminInsert(Admindto admindto) {
	  return  admindao.adminInsert(admindto);
	}
	
	public String getByName(String adminName) {
	return	admindao.getByName(adminName);
	}
	public Admindto getByIdAdmin(int id) {
		return admindao.getByIdAdmin(id);
	}
	
	public String getByEmail (String adminEmail) {
		return admindao.getByEmail(adminEmail);
	}
	public void adminDelete(int id) {
	 admindao.adminDelete(id);
	}
	public List<Admindto> displayAdmin() {
		return admindao.displayAdmin();
	}
	public int updateAdmin(Admindto admindto) {
		return admindao.updateAdmin(admindto);
	}
}
