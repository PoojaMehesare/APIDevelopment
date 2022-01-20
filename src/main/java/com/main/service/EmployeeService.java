package com.main.service;

import java.util.List;


import com.main.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public List<Employee> getEmployee();

	public Employee getbyId(int id);

	Employee updateEmployee(int id, Employee employee);
	
	void deletebyId(int id);

	public Employee updatePartially(int id, Employee employee);
}
