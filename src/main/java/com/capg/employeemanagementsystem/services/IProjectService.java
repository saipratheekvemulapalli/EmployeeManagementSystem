package com.capg.employeemanagementsystem.services;

import java.util.List;

import com.capg.employeemanagementsystem.entity.Project;



public interface IProjectService {

	Project save(Project project);

	 void deleteProjectById(int projectId); 
		
	


   void updateProject(Project project) ;
		
	

	 Project getProjectById(int projectId); 
		
	

  List<Project> getAllProject();



	

}