package com.example.ak.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ak.database.TempDataHolder;

@SuppressWarnings("serial")
public class RemoveCustomMessageServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		TempDataHolder.removeAll();
		getServletContext().getRequestDispatcher("/home")
		.forward(req, resp);
	}

}
