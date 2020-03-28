package com.test.mvc.service;

import java.util.List;

import com.test.mvc.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
