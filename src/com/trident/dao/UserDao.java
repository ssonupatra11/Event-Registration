package com.trident.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.trident.pojo.User;

public class UserDao {
	public static int register(User u) {
		Integer status = 0;
		try {
			Connection con = Db.getCon();
			int regdNo = 0;
			PreparedStatement ps = con.prepareStatement("select max(regdNo) from event_registration.user_registration");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				regdNo = rs.getInt(1);
				regdNo++;
				System.out.println(regdNo);
				
				PreparedStatement p = con.prepareStatement("insert into event_registration.user_registration values(?,?,?,?,?,?,?,?,?)");
				p.setInt(1,regdNo);
				p.setString(2, u.getUserName());
				p.setString(3, u.getFullName());
				p.setString(4, u.getPassword());
				p.setString(5, u.getAddress());
				p.setString(6, u.getMobileNumber());
				p.setString(7, u.getGender());
				p.setString(8, u.geteMail());
				p.setString(9, u.getIdCard());
				status = p.executeUpdate();
				con.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean authenticate(String userName,String password) {
		boolean status = false;
		try {
			Connection con = Db.getCon();
			PreparedStatement ps = con.prepareStatement("select userName,password from event_registration.user_registration where userName=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
				System.out.println("Sucessfully login");
			}
			else {
				System.out.println("username password invalid");
			}
		}catch(Exception e) {
			System.out.println("Db Related Error");
			e.printStackTrace();
		}
		return status;
	}
}
