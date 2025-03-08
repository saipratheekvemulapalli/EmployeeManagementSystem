package com.capg.employeemanagementsystem.services;

import java.util.List;

import com.capg.employeemanagementsystem.entity.Department;
import com.capg.employeemanagementsystem.exceptions.DepartmentNotFoundException;

public interface IDepartmentService {
	Department addDepartment(Department department);
	Department getDepartmentById(int departId) throws DepartmentNotFoundException;
	List<Department> getAllDepartments();
	void deleteDepartment(int departId) throws DepartmentNotFoundException;

	
}
