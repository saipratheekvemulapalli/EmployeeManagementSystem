package com.capg.employeemanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.capg.employeemanagementsystem.entity.Department;

public interface IDepartmentRepository extends CrudRepository<Department, Integer> {
               
}