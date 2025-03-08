package com.capg.employeemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capg.employeemanagementsystem.entity.Compliance;
import com.capg.employeemanagementsystem.exceptions.ComplianceNotFoundException;
import com.capg.employeemanagementsystem.repository.IComplianceRepository;

@Service
public class ComplianceServiceIMPL implements IComplianceService {
	
	@Autowired
	IComplianceRepository complianceRepository;
	

		@Override
	public Compliance save(Compliance co) {
		return complianceRepository.save(co);
		
	}

        @Override
		public List<Compliance> getAllRL() {
			List<Compliance> list = new ArrayList<Compliance>();
			complianceRepository.findAll().forEach(complianceall ->list.add(complianceall));
			return list;
		}
        
        @Override
    	public Compliance getComplianceById(int complianceId) throws ComplianceNotFoundException {
        	if(complianceRepository.findById(complianceId).isPresent()) {
				Compliance compliance = complianceRepository.findById(complianceId).get();
				return compliance;
				}
				else
				{
					throw new ComplianceNotFoundException("Compliance with Id: " + complianceId + " doesn't exist!!");
				}
	  }
        
        

		@Override
		public void updateCompliance(Compliance compliance) {
			complianceRepository.save(compliance);
			
		}


		@Override
		public void deleteComplianceById(int complianceId) throws ComplianceNotFoundException {
			if(complianceRepository.findById(complianceId).isPresent()) {
				complianceRepository.deleteById(complianceId);
				}
				else
				{
					throw new ComplianceNotFoundException("Compliance with Id: " + complianceId + " doesn't exist!!");
				}
			
		}

		

		

        


		
	
	

}
