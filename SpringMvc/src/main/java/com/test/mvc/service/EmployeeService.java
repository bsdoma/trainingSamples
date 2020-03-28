package com.test.mvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mvc.dao.EmployeeDAO;
import com.test.mvc.model.Employee;
 
 
@Service
public class EmployeeService {
 
    @Autowired
    EmployeeDAO dao;
     
    public List<Employee> getAllEmployees() 
    {
        return dao.getAllEmployees();
    }
}
