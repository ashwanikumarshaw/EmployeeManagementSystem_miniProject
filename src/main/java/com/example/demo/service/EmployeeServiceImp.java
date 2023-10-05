package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeDetails;
import com.example.demo.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("EmployeeServiceImp_1")
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public EmployeeDetails AddEmp(EmployeeDetails employeedetails) {
		EmployeeDetails empDetail=employeerepository.save(employeedetails);
		log.info(empDetail.toString());
		return empDetail;
	}
	
	@Override
	public EmployeeDetails getEmp(Long empId) {
		EmployeeDetails empDetail=employeerepository.findById(empId).orElseThrow();
		log.debug(empDetail.toString());
		return empDetail;
	}

	@Override
	public EmployeeDetails getEmpByEmail(String empEmail) {
		EmployeeDetails empDetail=employeerepository.findAllByEmpEmail(empEmail);
		log.info(empDetail.toString());
		return empDetail;
	}

	@Override
	public EmployeeDetails updateEmp(EmployeeDetails employeedetails) {
		EmployeeDetails empDetail=null;
		try {
			employeerepository.findById(employeedetails.getEmpId()).orElseThrow();
			empDetail=employeerepository.save(employeedetails);

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Emp Not Found Exception Occured");
			
		}
		
		return empDetail;
	}

	@Override
	public EmployeeDetails deactivateEmp(Long empId) {
		EmployeeDetails empDetail=null;
		try {
			empDetail=employeerepository.findById(empId).orElseThrow();
			empDetail.setActive(false);
			empDetail=employeerepository.save(empDetail);

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Emp Not Found Exception Occured");
			
		}
		
		return empDetail;
	}

	@Override
	public String deleteEmp(Long empId) {
		employeerepository.deleteById(empId);
		return "Emp id: "+empId+" deleted";
	}

	@Override
	public List<EmployeeDetails> getAllEmp() {
		return employeerepository.findAll();
	}

	@Override
	public List<EmployeeDetails> getActive() {

		return employeerepository.activeEmp();
	}

}
