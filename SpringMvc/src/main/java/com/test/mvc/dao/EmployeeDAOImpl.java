package com.test.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.mvc.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	public List<Employee> getAllEmployees() 
    {
        List<Employee> employees = new ArrayList<Employee>();
         
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setFirstName("Brahmaiah");
        e1.setLastName("Doma");
        employees.add(e1);
         
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setFirstName("Ram");
        e2.setLastName("Narayan");
        employees.add(e2);
         
        return employees;
    }

}
