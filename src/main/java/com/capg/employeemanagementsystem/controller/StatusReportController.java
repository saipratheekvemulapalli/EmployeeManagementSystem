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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.employeemanagementsystem.entity.StatusReport;
import com.capg.employeemanagementsystem.exceptions.StatusRecordNotFoundException;
import com.capg.employeemanagementsystem.services.IStatusReportService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/statusreport")
public class StatusReportController {
	@Autowired
	IStatusReportService iServiceReportService;
	@PostMapping("/create")
	public ResponseEntity<StatusReport> createStatusReport(@RequestBody StatusReport st){
		StatusReport statusReport=iServiceReportService.createStatusReport(st);
		return new ResponseEntity<StatusReport>(statusReport,HttpStatus.CREATED);
	}
	@GetMapping("StatusReport/{statusId}")
	public ResponseEntity<StatusReport> getStatusReportById(@PathVariable("statusId")int statusId) throws StatusRecordNotFoundException {
		StatusReport statusReport=iServiceReportService.getStatusReportById(statusId);
		return new ResponseEntity<StatusReport>(statusReport,HttpStatus.OK);
	}
	@DeleteMapping("/delete-StatusReport/{statusId}")
	public String deleteStatusReportById(@PathVariable("statusId")int statusId)throws StatusRecordNotFoundException {
		iServiceReportService.deleteStatusReportById(statusId);
		return "deleted";
	}
	
	@GetMapping("/getAll")
	public List<StatusReport> getAllStatusReport(){
		return iServiceReportService.getAllStatusReport();	
	}

}