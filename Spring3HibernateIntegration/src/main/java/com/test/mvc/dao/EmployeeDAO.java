package com.test.mvc.dao;

import java.util.List;

import com.test.mvc.entity.Employee;

public interface EmployeeDAO 
{
    public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}