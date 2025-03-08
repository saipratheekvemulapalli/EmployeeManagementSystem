package com.capg.employeemanagementsystem.services;

import java.util.Optional;

import com.capg.employeemanagementsystem.entity.Admin;

public interface IAdminService {
	public Admin addAdmin(Admin admin);

	public boolean validateAdmin(String username, String password);

	public Optional<Admin> viewByAdminUserName(String username, String password);

}
