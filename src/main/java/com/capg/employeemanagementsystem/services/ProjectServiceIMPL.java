package com.capg.employeemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.employeemanagementsystem.entity.Project;
import com.capg.employeemanagementsystem.exceptions.ProjectNotFoundException;
import com.capg.employeemanagementsystem.repository.IProjectRepository;




@Service
public class ProjectServiceIMPL implements IProjectService {
	
	@Autowired
	IProjectRepository iProjectRepository;

	@Override
	public Project save(Project project) {
	
		return iProjectRepository.save(project);
	}

	@Override
	public void deleteProjectById(int projectId) throws ProjectNotFoundException{
		if(iProjectRepository.findById(projectId).isPresent()) {
			iProjectRepository.deleteById(projectId);
	}
		else
		{
			throw new ProjectNotFoundException("Project with id:"+projectId+"doesnot exist!!");
			
		}
	
	}

	@Override
	public void updateProject(Project project) {
		iProjectRepository.save(project);
		
	}

	@Override
	public Project getProjectById(int projectId) throws ProjectNotFoundException {
		if(iProjectRepository.findById(projectId).isPresent()) {
			Project project = iProjectRepository.findById(projectId).get();
			return project;
		}
		else
		{
			throw new ProjectNotFoundException("Project with id:"+projectId+"doesnot exist!!");
		}
		
		
	}

	
	

	@Override
	public List<Project> getAllProject() {
		List<Project> list = new ArrayList<Project>();
		iProjectRepository.findAll().forEach(projectall ->list.add(projectall));
		return list;
		
	}

	
}