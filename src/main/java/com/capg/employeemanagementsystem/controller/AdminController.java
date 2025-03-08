package com.capg.employeemanagementsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.employeemanagementsystem.entity.Admin;
import com.capg.employeemanagementsystem.entity.Department;
//import com.capg.employeemanagementsystem.entity.Employee;
import com.capg.employeemanagementsystem.entity.Project;
import com.capg.employeemanagementsystem.exceptions.AdminNotFoundException;
import com.capg.employeemanagementsystem.exceptions.ComplianceNotFoundException;
import com.capg.employeemanagementsystem.exceptions.DepartmentNotFoundException;
import com.capg.employeemanagementsystem.exceptions.EmployeeRecordNotFoundException;
import com.capg.employeemanagementsystem.exceptions.ProjectNotFoundException;
import com.capg.employeemanagementsystem.services.AdminServiceIMPL;
//import com.capg.employeemanagementsystem.services.ComplianceServiceIMPL;
import com.capg.employeemanagementsystem.services.IComplianceService;
import com.capg.employeemanagementsystem.services.IDepartmentService;
import com.capg.employeemanagementsystem.services.IEmployeeService;
import com.capg.employeemanagementsystem.services.IProjectService;
@CrossOrigin(origins ="http://localhost:56143")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
private int validAdmin = 0; //flag variable
	
	@Autowired
	private AdminServiceIMPL adminservice;
	@Autowired
	private IComplianceService complianceService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IProjectService iProjectService;
	
	
	/*---------------------------------------- Admin------------------------------------------------- */
	
//	@GetMapping("/login/{username}/{password}")
//	public ResponseEntity<?> loginAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
	//	if(adminservice.validateAdmin(username, password) == true) {
	//		validAdmin = 1;
	//		Admin admin = adminservice.viewByAdminUserName(username, password).get();
		//	String welcome = "Welcome \n........................\n";
	//		return ResponseEntity.ok(welcome + "Id : " + admin.getAdminId() + "\nUsername : " + admin.getAdminUsername());
		//} else
		//	return ResponseEntity.ok("Invalid credentials");
	//}
	@PostMapping("/login")
	//@CrossOrigin("http://localhost:4200")
	public boolean doLogin(@RequestBody Admin adm,HttpServletRequest req)throws AdminNotFoundException
	{
		String username = adm.getAdminUsername();
		String password = adm.getAdminpassword();
		
		if(adminservice.validateAdmin(username, password) == true)
		{
			validAdmin = 1;
			Admin admin = adminservice.viewByAdminUserName(username, password).get();

				return true;
		}
		else
		{
			return false;
			}
		}
	
	
//	@PostMapping("/add")
//	public Admin addAdmin(@Validated @RequestBody Admin admin) {
//		Admin admins= adminservice.addAdmin(admin);
	//	return ResponseEntity
//	}
	@PostMapping("/add")
	//@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		Admin adm = adminservice.addAdmin(admin);
		return new ResponseEntity<Admin>(adm, HttpStatus.CREATED);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		if(validAdmin == 1) {
			validAdmin = 0;
			return ResponseEntity.ok("Logged out...");		
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
	/*---------------------------Compliance--------------------------------*/
	
	@DeleteMapping("/compliance/{complianceId}")
	public String deleteComplianceById(@PathVariable("complianceId") int complianceId) throws ComplianceNotFoundException {
		if(validAdmin == 1) {
			complianceService.deleteComplianceById(complianceId);
			return "deleted";
		}else {
			return "Invalid Credentials";
		}
		
	}
	
	
	/*------------------------------ Employee----------------------------------- */
	@DeleteMapping("/deleteById/{userid}")
	private String deleteEmployee(@PathVariable int userid) throws EmployeeRecordNotFoundException {
		if(validAdmin == 1) {
		employeeService.deleteEmployee(userid);
		return "deleted";
		}else {
			return "Invalid Credentials";
		}
	}
	
	/*------------------------------ Department------------------------------------- */
	
	@PostMapping("/adddepartment")
	public ResponseEntity<?>addDepartment( @RequestBody Department department){
		if(validAdmin == 1) {
		Department dt= departmentService.addDepartment(department);
		return new ResponseEntity<Department>(dt,HttpStatus.CREATED);
		}else {
			return ResponseEntity.ok("Invalid Credentials");
		}
	}
	
	
	@DeleteMapping("/deleteById/{departId}")
	public String deleteDepartment(@PathVariable int departId) throws DepartmentNotFoundException {
		if(validAdmin == 1) {
		departmentService.deleteDepartment(departId);
		return "deleted";
		}else {
			return "Invalid Credentials";
		}
	}
	
	/* ----------------------------------Project ----------------------------------------*/
	
	@PostMapping("/addProject")
	private ResponseEntity<?>addProject(@RequestBody Project project ){
		if(validAdmin == 1) {
		Project project1	= iProjectService.save(project);
		return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
		}else {
			return ResponseEntity.ok("Invalid Credentials");
		}
		
	}
	
	
	@DeleteMapping("/project/{projectId}")
	public String deleteProjectById(@PathVariable("projectId") int projectId) throws ProjectNotFoundException {
		if(validAdmin == 1) {
		iProjectService.deleteProjectById(projectId);
		return "deleted";
		}else {
			return "Invalid Credentials";
		}
	}
	
	
}