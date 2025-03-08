package com.capg.employeemanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.employeemanagementsystem.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByAdminUsername(String adminUsername);

	Optional<Admin> findByAdminUsernameAndAdminpassword(String adminUsername, String adminpassword);

}
