package com.capg.employeemanagementsystem.services;

import java.util.List;

import com.capg.employeemanagementsystem.entity.StatusReport;
import com.capg.employeemanagementsystem.exceptions.StatusRecordNotFoundException;

public interface IStatusReportService {

 StatusReport createStatusReport(StatusReport st);

StatusReport getStatusReportById(int statusId) throws StatusRecordNotFoundException;

String deleteStatusReportById(int statusId) throws StatusRecordNotFoundException;

List<StatusReport> getAllStatusReport();


}