package com.capg.employeemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.employeemanagementsystem.entity.Department;
import com.capg.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.capg.employeemanagementsystem.repository.IDepartmentRepository;



@Service
public class DepartmentServiceIMPL implements IDepartmentService 
{
	@Autowired
     IDepartmentRepository departmentrepository;
	@Override
	public Department addDepartment(Department department) {
		
		return departmentrepository.save(department);
	}
	@Override
	public Department getDepartmentById(int departId) throws DepartmentNotFoundException {
		if(departmentrepository.findById(departId).isPresent()) {
			Department dt=departmentrepository.findById(departId).get();
			return dt;
			}
			else {
				throw new DepartmentNotFoundException("department with id "+departId+" does not exist");
			}
	}
	@Override
	public List<Department> getAllDepartments() {
		
		return (List<Department>) departmentrepository.findAll();
	
	}
	@Override
	public void deleteDepartment(int departId)throws DepartmentNotFoundException {
		if(departmentrepository.findById(departId).isPresent()){
			departmentrepository.deleteById(departId);
			
			}
			else {
				throw new DepartmentNotFoundException("department with id "+departId+" does not exist");
			}
		
		
	}

	

}
