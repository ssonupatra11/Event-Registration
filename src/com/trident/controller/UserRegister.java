package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.dao.UserDao;
import com.trident.pojo.User;

@SuppressWarnings("serial")
public class UserRegister extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw =resp.getWriter();
		
		String userName = req.getParameter("uname");
		String fullName = req.getParameter("fname");
		String password = req.getParameter("pass");
		String address = req.getParameter("ad");
		String mobileNumber = req.getParameter("mobno");
		String gender = req.getParameter("gen");
		String eMail = req.getParameter("email");
		String idCard = req.getParameter("cnum");
		
		
		User u = new User(userName,fullName,password,address,mobileNumber,gender,eMail,idCard);
		UserDao.register(u);
		
		pw.println("User added Sucessfully");
		req.getRequestDispatcher("login.html").forward(req, resp);
		pw.close();
	}
}
