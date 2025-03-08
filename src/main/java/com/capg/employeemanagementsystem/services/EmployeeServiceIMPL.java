package com.capg.employeemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.employeemanagementsystem.entity.Employee;
import com.capg.employeemanagementsystem.exceptions.EmployeeRecordNotFoundException;
import com.capg.employeemanagementsystem.repository.IEmployeeRepository;

@Service
public class EmployeeServiceIMPL implements IEmployeeService {
	@Autowired

	IEmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(int userId) throws EmployeeRecordNotFoundException {
		if (employeeRepository.findById(userId).isPresent()) {
			return employeeRepository.findById(userId).get();
		} else {
			throw new EmployeeRecordNotFoundException("user with id " + userId + "does not exist");
		}
	}

	public List<Employee> getAllEmployee() {
		List<Employee> employee = new ArrayList<Employee>();
		return (List<Employee>) employeeRepository.findAll();
	}

	public void deleteEmployee(int userId) throws EmployeeRecordNotFoundException {
		if (employeeRepository.findById(userId).isPresent()) {
			employeeRepository.deleteById(userId);
		} else {
			throw new EmployeeRecordNotFoundException("user with id " + userId + "deleted");
		}
	}

	public Employee updateEmployee(int userId) throws EmployeeRecordNotFoundException {
		if (employeeRepository.findById(userId).isPresent()) {
			return employeeRepository.findById(userId).get();
		} else {
			throw new EmployeeRecordNotFoundException("user with id " + userId + "already exists");
		}
	}
	
	public Optional<Employee> viewByUserName(String username, String password) throws EmployeeRecordNotFoundException {
		Optional<Employee> employee = employeeRepository.findByUsernameAndPassword(username, password);
		if(employee.get() == null)
			throw new EmployeeRecordNotFoundException("Customer not created");
		return employee;		
	}
	
	@Override
	public boolean validateEmployee(String username, String password) {
		Optional<Employee> customer = employeeRepository.findByUsernameAndPassword(username, password);
		if(customer.get() == null)
			return false;
		else
			return true;
	}
}
