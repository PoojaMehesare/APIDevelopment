package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.exception.CustomException;
import com.main.model.Employee;
import com.main.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/saveemployee")
	public ResponseEntity<Employee> saveEmployee(@Validated @RequestBody Employee employee) throws CustomException {

		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
		
	}

	@GetMapping("/getEmployee")
	public List<Employee> getEmployee() throws CustomException {

		return employeeService.getEmployee();
	}

	@GetMapping("{id}")
	public Employee getbyId(@PathVariable("id") int id) throws CustomException {

		return employeeService.getbyId(id);
	}

	@PutMapping("{id}")
	public Employee updateEmployee(@Validated @PathVariable("id") int id, @RequestBody Employee employee) throws CustomException {

		return employeeService.updateEmployee(id,employee);
	}

	@DeleteMapping("{id}")
	public String deletebyId(@PathVariable("id") int id) throws CustomException {

		employeeService.deletebyId(id);
		return "Deleted Id: " + id;
	}

	@PatchMapping("{id}")
	public ResponseEntity<Employee> updatePartially(@Validated @PathVariable("id") int id, @RequestBody Employee employee) throws CustomException {

		return new ResponseEntity<Employee>(employeeService.updatePartially(id, employee), HttpStatus.OK);

	}
}
