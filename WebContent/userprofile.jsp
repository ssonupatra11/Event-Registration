<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserProfile</title>
</head>
<body>
	<h1>Welcome ,
	<% out.println(session.getAttribute("userName"));
		if(session.getAttribute("userName")==null){
			response.sendRedirect("login.html");
		}
	%></h1>
	<table border="1">
		<% 
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_registration","root","chiku1234");
				Statement stmt=con.createStatement();
				String u1=(String)session.getAttribute("userName");
				String s1="select * from event_registration.user_registration where userName='"+u1+"'";
				ResultSet rs=stmt.executeQuery(s1);
				if(rs.next()){
					%>
					<tr><td>User RegistrationNumber:-</td><td><% out.println(rs.getString(1)); %></td></tr>
					<tr><td>User Name:-</td><td><% out.println(rs.getString(2)); %></td></tr>
					<tr><td>Full Name:-</td><td><% out.println(rs.getString(3)); %></td></tr>
					<tr><td>Password:-</td><td><% out.println(rs.getString(4)); %></td></tr>
					<tr><td>Address:-</td><td><% out.println(rs.getString(5)); %></td></tr>
					<tr><td>Mobile Number:-</td><td><% out.println(rs.getString(6)); %></td></tr>
					<tr><td>Gender:-</td><td><% out.println(rs.getString(7)); %></td></tr>
					<tr><td>Email:-</td><td><% out.println(rs.getString(8)); %></td></tr>
					<tr><td>Id Card:-</td><td><% out.println(rs.getString(9)); %></td></tr>
					<%
				}
			}catch(Exception e){
				System.out.println(e);
			}
		%>
	</table>
</body>
</html>