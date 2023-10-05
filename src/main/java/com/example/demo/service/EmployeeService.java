package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeDetails;

@Service
public interface EmployeeService {

	public EmployeeDetails AddEmp(EmployeeDetails employeedetails);

	public EmployeeDetails getEmp(Long empId);

	public List<EmployeeDetails> getAllEmp();

	public EmployeeDetails getEmpByEmail(String empEmail);

	public EmployeeDetails updateEmp(EmployeeDetails employeedetails);

	public EmployeeDetails deactivateEmp(Long empId);

	public String deleteEmp(Long empId);
	
	public List<EmployeeDetails> getActive();
}
