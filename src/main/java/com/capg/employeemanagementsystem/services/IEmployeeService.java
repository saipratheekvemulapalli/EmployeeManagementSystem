package com.capg.employeemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import com.capg.employeemanagementsystem.entity.Employee;
import com.capg.employeemanagementsystem.exceptions.EmployeeRecordNotFoundException;

public interface IEmployeeService {

	Employee addEmployee(Employee employee);

	Employee getEmployee(int userId) throws EmployeeRecordNotFoundException;

	public List<Employee> getAllEmployee();

	public void deleteEmployee(int userId) throws EmployeeRecordNotFoundException;

	public Employee updateEmployee(int userId) throws EmployeeRecordNotFoundException;
	
	public boolean validateEmployee(String username, String password);
}
