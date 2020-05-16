package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trident.dao.UserDao;

@SuppressWarnings("serial")
public class UserLogin extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		String userName = req.getParameter("uname");
		String password = req.getParameter("pass");
		
		if(UserDao.authenticate(userName, password)) {
			HttpSession session =req.getSession();
			session.setAttribute("userName", userName);
			req.getRequestDispatcher("index.html").include(req, resp);
		}
		else {
			req.getRequestDispatcher("error.html").include(req, resp);
			out.println("username and password invalid");
		}
	}

}
