package com.sample.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = new ArrayList<Student>();
		Student student1 = new Student();
		student1.setId(1); 
		student1.setName("Brahmaiah");
		student1.setRole("Developer");
		Student student2 = new Student();
		student2.setId(2); 
		student2.setName("swathi");
		student2.setRole("Leader");
		studentList.add(student1);
		studentList.add(student2);
		
		request.setAttribute("studentList", studentList);
		
		request.setAttribute("htmlTagData", "<br/> creates a new line.");
		request.setAttribute("url", "https://www.google.com");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentDetails.jsp");
		rd.forward(request, response);
	}

}
