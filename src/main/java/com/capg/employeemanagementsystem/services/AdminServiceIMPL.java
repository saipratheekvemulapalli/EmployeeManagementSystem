package com.capg.employeemanagementsystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.employeemanagementsystem.entity.Admin;
import com.capg.employeemanagementsystem.exceptions.AdminFoundException;
import com.capg.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.capg.employeemanagementsystem.repository.IAdminRepository;

@Service
public class AdminServiceIMPL {
	
	@Autowired
	private IAdminRepository adminrepo;

	public Admin addAdmin(Admin admin) {
		Admin obj = adminrepo.findByAdminUsername(admin.getAdminUsername());
		if(obj != null)
			throw new AdminFoundException("Admin already created");
		return adminrepo.save(admin);
	}

	public boolean validateAdmin(String username, String password) throws AdminNotFoundException {
		Optional<Admin> admin = adminrepo.findByAdminUsernameAndAdminpassword(username, password);
		if(admin.get() == null)
			throw new AdminNotFoundException("Admin not created");
		else
			return true;
	}

	public Optional<Admin> viewByAdminUserName(String username, String password) throws AdminNotFoundException {
		Optional<Admin> admin = adminrepo.findByAdminUsernameAndAdminpassword(username, password);
		if(admin.get() == null)
			throw new AdminNotFoundException("Admin not created");
		return admin;		
	}


}