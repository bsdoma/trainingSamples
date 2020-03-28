package com.test.springcore.di;

public class Address {
	private String city;
	private String state;
	private String zipCode;
	
	public Address() {
		System.out.println("in Address initialization");
	}
	public Address(String city,String state, String zipCode) {
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
	
	

}
