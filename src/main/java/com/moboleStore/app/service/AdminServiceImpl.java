//package com.moboleStore.app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.moboleStore.app.entity.Admin;
//import com.moboleStore.app.exception.AdminException;
//import com.moboleStore.app.repositiory.AdminRespository;
//
//@Service
//public class AdminServiceImpl implements AdminService{
//
//	@Autowired
//	private AdminRespository adminRepository;
//	@Override
//	public Admin login(String email, String password) throws AdminException {
//         Admin admin = adminRepository.findByEmail(email);
//		
//		if(admin == null) {
//			throw new AdminException("email Id doesnt exist");
//		}
//		else if(admin.getPassword()==null || !admin.getPassword().equals(password)) {
//			throw new AdminException("password is incorrect");
//		}
//		return admin;
//	}
//	@Override
//	public Admin addAdmin(Admin admin) throws AdminException {
//		if(adminRepository.findByEmail(admin.getEmail())!= null){
//			throw new AdminException("email already exists, try another email");
//		}
//		adminRepository.save(admin);
//		return admin;
//	}
//	
//	
//	@Override
//	public Admin changePassword(Integer id, String password) {
//		if(adminRepository.existsById(id)) {
//			Admin admin = adminRepository.findById(id).get();
//			admin.setPassword(password);
//			return admin;
//		}else {
//		return null;
//	}
//	}
//		
//
//	
//
//}
