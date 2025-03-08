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

import com.capg.employeemanagementsystem.entity.Compliance;
import com.capg.employeemanagementsystem.exceptions.ComplianceNotFoundException;
import com.capg.employeemanagementsystem.services.IComplianceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/compliance")
public class ComplianceController {

	@Autowired
	IComplianceService complianceService;

	
	@PostMapping("/create")
	private ResponseEntity<Compliance> createRL(@RequestBody Compliance co) {
		Compliance compliance=complianceService.save(co);
		return new ResponseEntity<Compliance>(compliance,HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	private List<Compliance> getAllRL() {
		return complianceService.getAllRL();
	}

	
	  @GetMapping("/compliance/{complianceId}") 
	  public ResponseEntity<Compliance> getComplianceById(@PathVariable("complianceId") int complianceId) throws ComplianceNotFoundException { 
		  Compliance compliance=complianceService.getComplianceById(complianceId);
		  return new ResponseEntity<Compliance>(compliance,HttpStatus.OK);
	  }
	  
	  
	 

	@PutMapping("/update")
	public Compliance updateBug(@RequestBody Compliance compliance) {
		complianceService.updateCompliance(compliance);
		return compliance;

	}

	@DeleteMapping("/compliance/{complianceId}")
	public String deleteComplianceById(@PathVariable("complianceId") int complianceId) throws ComplianceNotFoundException {
		complianceService.deleteComplianceById(complianceId);
		return "deleted";
	}
}
