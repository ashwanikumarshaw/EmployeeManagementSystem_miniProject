package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeDetails;
import com.example.demo.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/v-1")
public class EmployeeController {
	@Autowired
	@Qualifier("EmployeeServiceImp_1")
	private EmployeeService employeeservice;

	@GetMapping("getEmpActive")
	public List<EmployeeDetails> getAllActive() {
		return employeeservice.getActive();
	}

	@GetMapping("getEmployees")
	public List<EmployeeDetails> getEmployee() {
		return employeeservice.getAllEmp();
	}

	@PostMapping("addEmployee")
	public EmployeeDetails addEmployee(@RequestBody EmployeeDetails employeedetails) {
		return employeeservice.AddEmp(employeedetails);
	}

	@GetMapping("getEmployee/{empId}")
	public EmployeeDetails getEmployee(@PathVariable("empId") Long empId) {
		return employeeservice.getEmp(empId);
	}

	@GetMapping("getEmployeeByEmail")
	public EmployeeDetails getEmployeeByEmail(@PathParam("empEmail") String empEmail) {
		return employeeservice.getEmpByEmail(empEmail);
	}

	@PutMapping("updateEmployee")
	public EmployeeDetails updateEmployee(@RequestBody EmployeeDetails employeeDetails) {
		return employeeservice.updateEmp(employeeDetails);
	}

	@PutMapping("deactivateEmployee/{empId}")
	public EmployeeDetails deactivateEmployee(@PathVariable("empId") Long empId) {
		return employeeservice.deactivateEmp(empId);
	}

	@DeleteMapping("deleteEmp")
	public String deleteEmployee(@RequestParam("empId") Long empId) {
		return employeeservice.deleteEmp(empId);
	}

}
