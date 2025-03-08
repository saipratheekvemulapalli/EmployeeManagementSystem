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

import com.capg.employeemanagementsystem.entity.Project;
import com.capg.employeemanagementsystem.exceptions.ProjectNotFoundException;
import com.capg.employeemanagementsystem.services.IProjectService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	IProjectService iProjectService;
	
	@PostMapping("/addProject")
	private ResponseEntity<Project>addProject(@RequestBody Project project ){
		Project project1	= iProjectService.save(project);
		return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/project/{projectId}")
	public String deleteProjectById(@PathVariable("projectId") int projectId) throws ProjectNotFoundException {
		iProjectService.deleteProjectById(projectId);
		return "deleted";
	}
	
	@PutMapping("/updateproject")
	public Project updateProject(@RequestBody Project project) {
		iProjectService.updateProject(project);
		return project;
	}
	@GetMapping("/project/{projectId}")
	public ResponseEntity<Project>getProjectById(@PathVariable("projectId")int projectId)throws ProjectNotFoundException{
		Project project = iProjectService.getProjectById(projectId);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		
	}
	@GetMapping("/getAll")
	public List<Project> getAllProject(){
		return iProjectService.getAllProject();	
	}
	
	


}
