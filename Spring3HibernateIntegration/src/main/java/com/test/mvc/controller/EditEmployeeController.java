package com.test.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mvc.entity.Employee;
import com.test.mvc.service.EmployeeService;

@Controller
public class EditEmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeManager(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		
		map.addAttribute("employee", new Employee());
		map.addAttribute("employeeList", employeeService.getAllEmployees());

		return "editEmployeeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(
			@ModelAttribute(value = "employee") Employee employee,
			BindingResult result) {
		employeeService.addEmployee(employee);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
