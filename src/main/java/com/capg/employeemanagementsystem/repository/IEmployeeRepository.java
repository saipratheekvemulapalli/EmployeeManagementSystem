package com.capg.employeemanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.employeemanagementsystem.entity.Employee;



public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
	
	Optional<Employee> findByUsernameAndPassword(String username, String password);

}
