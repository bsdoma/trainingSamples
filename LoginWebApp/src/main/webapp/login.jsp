<%@ page import="java.sql.*,java.util.TimeZone"%>
<%
    String userName = request.getParameter("userName");   
    String password = request.getParameter("password");
    System.out.println("Username-->"+userName + "--->Password-->"+password);
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatraining?serverTimezone=" + TimeZone.getDefault().getID(),
            "root", "bsdoma@05");
    PreparedStatement ps = null;
    ResultSet rs = null;
    ps = con.prepareStatement("select * from user where userName= ?  and password=  ? limit 1");
	ps.setString(1, userName);
	ps.setString(2, password);
	rs = ps.executeQuery();
    if (rs.next()) {
        session.setAttribute("userName", userName);
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>