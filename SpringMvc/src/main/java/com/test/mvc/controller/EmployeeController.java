package com.test.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mvc.service.EmployeeService;
 
 
@Controller
@RequestMapping("/employee-module")
public class EmployeeController 
{
    @Autowired
    EmployeeService empService;
 
    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model)
    {
        model.addAttribute("employees", empService.getAllEmployees());
        return "employeesListDisplay";
    }
    
    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    public String getAllEmployee(Model model)
    {
    	System.out.println("get Employee execution");
        model.addAttribute("employees", empService.getAllEmployees());
        return "employeesListDisplay";
    }
}