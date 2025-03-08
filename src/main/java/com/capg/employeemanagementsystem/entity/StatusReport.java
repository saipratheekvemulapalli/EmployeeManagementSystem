package com.capg.employeemanagementsystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity 
@Data
public class StatusReport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int statusId;
	private String comments;
	private String details;
	private LocalDate createDate=LocalDate.now();
	private int userId;
	
	@OneToOne
	@JoinColumn(name = "sd_fk", referencedColumnName="departId")
	private Department department;
	
	

}
