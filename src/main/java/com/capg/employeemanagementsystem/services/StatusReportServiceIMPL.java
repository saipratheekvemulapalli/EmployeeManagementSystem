package com.capg.employeemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.employeemanagementsystem.entity.StatusReport;
import com.capg.employeemanagementsystem.exceptions.StatusRecordNotFoundException;
import com.capg.employeemanagementsystem.repository.IStatusReportRepository;



@Service
public class StatusReportServiceIMPL implements IStatusReportService    {
	@Autowired
	IStatusReportRepository iStatusReportRepository;
	@Override
	public StatusReport createStatusReport(StatusReport st) {
		return iStatusReportRepository.save(st);
	}
	@Override
	public StatusReport getStatusReportById(int statusId) throws StatusRecordNotFoundException {
		if(iStatusReportRepository.findById(statusId).isPresent()) {
		StatusReport statusReport=iStatusReportRepository.findById(statusId).get();
		return statusReport;
	}
		else
		{
			throw  new StatusRecordNotFoundException("StatusReport with id:"+ statusId +" doesnot exist");
		}
		}
	
		@Override
	public String deleteStatusReportById(int statusId) throws StatusRecordNotFoundException{
		if(iStatusReportRepository.findById(statusId).isPresent()) {
			iStatusReportRepository.deleteById(statusId);
			return "deleted";
		}
		else
		{
			throw  new StatusRecordNotFoundException("StatusReport with id:"+ statusId +" doesnot exist");
		}
		
	}

		@Override
		public List<StatusReport> getAllStatusReport() {
			List<StatusReport> list = new ArrayList<StatusReport>();
			iStatusReportRepository.findAll().forEach(statusReportAll ->list.add(statusReportAll));
			return list;
		}

	

}
