package com.trident.dao;
import java.sql.*;

public class Db {
	public static  Connection getCon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_registration","root","chiku1234");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
}
