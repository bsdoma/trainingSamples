package com.test.springcore.di.annotatioins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Contact {
	
	   //you want autowired this field.
	   @Autowired
	   @Qualifier(value="PersonBean2")
		private Person person;
		
		private int type;
		private String action;
		
		public Contact() {
			
		}
		
		public Contact(Person person) {
			this.person= person;
		}
		public Person getPerson() {
			return person;
		}
		
//		@Autowired
//		public void setPerson(Person person) {
//			this.person = person;
//		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}

		@Override
		public String toString() {
			return "Contact [person=" + person + ", type=" + type + ", action=" + action + "]";
		}
		
		
		
		

}
