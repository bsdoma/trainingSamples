package com.training.hibernate;

public class StaticTest {
	
	 int a = 10;

	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		System.out.println(st.a);
		
		StaticTest st1 = new StaticTest();
		st1.a = 20;
		
		System.out.println(st1.a);
		
		

	}

}
