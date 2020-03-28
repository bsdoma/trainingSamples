package com.test.springcore;

public class Employee {

	private int id;
	private String name;
	private int salary;
	
	public Employee() {
		System.out.println("Employee construction...");
	}
	
	public Employee(int id, String name, int salary) {
		System.out.println("Employee construction..."+ name);
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	public void initMethod() {
		System.out.println("in init method");
	}
	
	public void destroyMethod() {
		System.out.println("in Destroy method");
	}
	
	
}
