package com.example.ak.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {
			String uName = request.getParameter("username");
			String uPassword = request.getParameter("password");

			boolean user_valid = true;
			user_valid = checkUser(uName, uPassword);

			if (user_valid) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", "uName");
				response.sendRedirect("/home"); // logged-in page
			}

			else
				response.sendRedirect("invalidLogin.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
	public boolean checkUser(String uname, String pwd) {
		
		if("abhi".equals(uname) && "abhi".equals(pwd)) {
			return true;
		}
		else if("admin".equals(uname) && "admin".equals(pwd)) {
			return true;
		}
		return false;
		
	}
}