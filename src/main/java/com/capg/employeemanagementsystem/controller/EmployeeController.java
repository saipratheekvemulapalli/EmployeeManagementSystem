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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.employeemanagementsystem.entity.Employee;
import com.capg.employeemanagementsystem.exceptions.EmployeeRecordNotFoundException;
import com.capg.employeemanagementsystem.services.EmployeeServiceIMPL;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private int validUser = 0;
	private Integer validId = 0;
	@Autowired
	private EmployeeServiceIMPL employeeService;

	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@GetMapping("/getById/{userId}")
	private ResponseEntity<?> getEmployee1(@PathVariable int userId) throws EmployeeRecordNotFoundException {
		if(validUser == 1) {
		Employee employee1 = employeeService.getEmployee(userId);
		return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
		}else {
			return ResponseEntity.ok("Not Logged In");
		}
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@DeleteMapping("/deleteById/{userid}")
	private String deleteEmployee(@PathVariable int userid) throws EmployeeRecordNotFoundException {
		employeeService.deleteEmployee(userid);
		return "deleted";
	}

	@PutMapping("/update-employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> validateUser(@PathVariable("username") String username,
			@PathVariable("password") String password) throws EmployeeRecordNotFoundException {
		boolean value = employeeService.validateEmployee(username, password);
		if (value == true) {
			validUser = 1;
			Employee employee = employeeService.viewByUserName(username, password).get();
			validId = employee.getUserId();

			return ResponseEntity.ok("welcome" + validId + "\n FirstName : " + employee.getFirstname()
					+ "\n LastName : " + employee.getLastname());
		} else
			return ResponseEntity.ok("Invalid Credentials");
	}
}