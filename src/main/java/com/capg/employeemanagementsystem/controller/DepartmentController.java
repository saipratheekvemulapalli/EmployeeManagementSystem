package com.capg.employeemanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.employeemanagementsystem.entity.Department;
import com.capg.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.capg.employeemanagementsystem.services.IDepartmentService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	
	@PostMapping("/adddepartment")
	public ResponseEntity<Department>addDepartment( @RequestBody Department department){
		Department dt= departmentService.addDepartment(department);
		return new ResponseEntity<Department>(dt,HttpStatus.CREATED);
	}

	@GetMapping("/getById/{departId}")
	public ResponseEntity<Department> getDepartment(@PathVariable int departId) throws DepartmentNotFoundException{
	Department dt =departmentService.getDepartmentById(departId);
	return new ResponseEntity<Department>(dt,HttpStatus.OK);
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments() 
	{
	return departmentService.getAllDepartments();
	}
	
	@DeleteMapping("/deleteById/{departId}")
	public String deleteDepartment(@PathVariable int departId) throws DepartmentNotFoundException {
		departmentService.deleteDepartment(departId);
		return "deleted";
	}

}
