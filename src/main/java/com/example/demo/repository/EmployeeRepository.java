package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeDetails;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {
	
		public EmployeeDetails findAllByEmpEmail(String empEmail);
		public List<EmployeeDetails> findAllByEmpName(String empName);

		@Query(value="select e from EmployeeDetails e where e.active = true")
		public List<EmployeeDetails> activeEmp();
}
