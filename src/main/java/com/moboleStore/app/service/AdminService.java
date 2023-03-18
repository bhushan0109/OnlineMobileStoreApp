package com.moboleStore.app.service;

import com.moboleStore.app.entity.Admin;
import com.moboleStore.app.exception.AdminException;


public interface AdminService {
	
	public Admin login(String email, String password)throws AdminException;
	
	public Admin addAdmin(Admin admin) throws AdminException;
	
	public Admin changePassword(Integer id, String password) ;
	

}
