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
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class Compliance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int complianceId;
	private String rlType;
	private String details;
	private LocalDate createDate=LocalDate.now();
	@OneToOne
	@JoinColumn(name = "DeptId_fk", referencedColumnName="departId")
	private Department department;
	private int empCount;
	private int stscCount;
	private String status;
	

}
