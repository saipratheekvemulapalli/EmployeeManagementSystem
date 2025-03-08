package com.capg.employeemanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.capg.employeemanagementsystem.entity.Project;



public interface IProjectRepository extends CrudRepository<Project, Integer> {

	

}