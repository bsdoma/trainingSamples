<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="empInfo" class="com.sample.EmployeeDetails"></jsp:useBean> 
<jsp:setProperty property="*" name="empInfo"/> 
You have enterted below details:<br> 
<jsp:getProperty property="empName" name="empInfo"/><br> 
<jsp:getProperty property="password" name="empInfo"/><br> 
<jsp:getProperty property="age" name="empInfo" /><br>