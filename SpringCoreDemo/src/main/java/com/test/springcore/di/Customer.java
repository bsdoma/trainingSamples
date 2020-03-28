package com.test.springcore.di;

public class Customer {
	
	private int custId;
	private String customerName;
	private Address address;
	
	public Customer() {
		
	}
	//Constructor Based Injection
	public Customer(Address address) {
		this.address = address;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Address getAddress() {
		return address;
	}
	//Setter Based Injection
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", customerName=" + customerName + ", address=" + address + "]";
	}
	
	
	

}
