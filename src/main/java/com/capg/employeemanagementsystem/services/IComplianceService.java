package com.capg.employeemanagementsystem.services;


import java.util.List;

import com.capg.employeemanagementsystem.entity.Compliance;
import com.capg.employeemanagementsystem.exceptions.ComplianceNotFoundException;

public interface IComplianceService {
	

	Compliance save(Compliance co);

	List<Compliance> getAllRL();

	void updateCompliance(Compliance compliance);

	Compliance getComplianceById(int complianceId)throws ComplianceNotFoundException ;

	void deleteComplianceById(int complianceId) throws ComplianceNotFoundException;

}
