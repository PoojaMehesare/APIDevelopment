package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Employee;
import com.main.repository.EmployeeRepository;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public EmplyeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee addEmployee(Employee employee) {
	
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee getbyId(int id) {
		
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
	
		Employee newEmployee = employeeRepo.findById(id).get();
		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setLastName (employee.getLastName());
		return employeeRepo.save(newEmployee);
		
	}

	@Override
	public void deletebyId(int id) {
		
		employeeRepo.deleteById(id);
		
	}

	@Override
	public Employee updatePartially(int id, Employee employee) {
		
		Employee newEmployee = employeeRepo.findById(id).get();
		newEmployee.setFirstName(employee.getFirstName());
		return employeeRepo.save(newEmployee);
	}
	
	
}
