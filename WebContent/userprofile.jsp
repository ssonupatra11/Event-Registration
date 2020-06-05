<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>UserProfile</title>
        <style>
            * {
                color: white;
                margin: 0%;
                padding: 0%;
            }
            
            body {
                background-image: url("home.jpg");
                background-attachment: fixed;
                background-size: cover;
            }
            
            table {
                height: 350px;
                width: 55%;
                background-color: rgba(13, 39, 41, 0.877);
                padding: 1%;
                font-size: 20px;
                color: rgb(255, 255, 255);
                font-family: 'Courier New', Courier, monospace;
                border: none;
                border-radius: 7px;
                margin: 5% auto;
            }
            
            div {
                padding: 1%;
            }
            
            .btn {
                color: white;
                background-color: chartreuse;
                width: 150px;
                height: 40px;
                font-size: 21px;
                font-family: 'Times New Roman', Times, serif;
                border: none;
                border-radius: 5px;
            }
            
            caption {
                font-size: 25px;
                font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            }
            
            @media screen and (max-width: 870px) {
                table {
                    width: 90%;
                    margin: 8% auto;
                }
            }
            
            @media screen and (max-width: 500px) {
                table {
                    font-size: 100%;
                    width: 100%;
                    margin: 8% auto;
                }
            }
        </style>
    </head>

    <body>
        <div>
            <a href="index.html"><button class="btn">Back</button></a>
            <h1>Welcome ,
                <% out.println(session.getAttribute("userName"));
		if(session.getAttribute("userName")==null){
			response.sendRedirect("login.html");
		}
	%>
            </h1>
        </div>
        <table>
            <caption>YOUR PROFILE</caption>
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
                <tr>
                    <td>User Registration Number:-</td>
                    <td>
                        <% out.println(rs.getString(1)); %>
                    </td>
                </tr>
                <tr>
                    <td>User Name:-</td>
                    <td>
                        <% out.println(rs.getString(2)); %>
                    </td>
                </tr>
                <tr>
                    <td>Full Name:-</td>
                    <td>
                        <% out.println(rs.getString(3)); %>
                    </td>
                </tr>
                <tr>
                    <td>Password:-</td>
                    <td>
                        <% out.println(rs.getString(4)); %>
                    </td>
                </tr>
                <tr>
                    <td>Address:-</td>
                    <td>
                        <% out.println(rs.getString(5)); %>
                    </td>
                </tr>
                <tr>
                    <td>Mobile Number:-</td>
                    <td>
                        <% out.println(rs.getString(6)); %>
                    </td>
                </tr>
                <tr>
                    <td>Gender:-</td>
                    <td>
                        <% out.println(rs.getString(7)); %>
                    </td>
                </tr>
                <tr>
                    <td>Email:-</td>
                    <td>
                        <% out.println(rs.getString(8)); %>
                    </td>
                </tr>
                <tr>
                    <td>Id Card:-</td>
                    <td>
                        <% out.println(rs.getString(9)); %>
                    </td>
                </tr>
                <%
				}
			}catch(Exception e){
				System.out.println(e);
			}
		%>
        </table>
    </body>

    </html>