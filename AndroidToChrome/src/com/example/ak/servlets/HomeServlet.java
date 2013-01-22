/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.ak.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ak.database.TempDataHolder;

/**
 * Servlet that adds display number of devices and button to send a message.
 * <p>
 * This servlet is used just by the browser (i.e., not device) and contains the
 * main page of the demo app.
 */
@SuppressWarnings("serial")
public class HomeServlet extends BaseServlet {

	static final String ATTRIBUTE_STATUS = "status";

	/**
	 * Displays the existing messages and offer the option to send a new one.
	 */
	@SuppressWarnings("null")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<html><body>");
		out.print("<head>");
		out.print("  <title>Android To Chrome Sync</title>");
		out.print("  <link rel='icon' href='favicon.png'/>");
		out.print("</head>");
		String status = (String) req.getAttribute(ATTRIBUTE_STATUS);
		if (status != null) {
			out.print(status);
		}
		List<String> messages = TempDataHolder.getMessages();
		if (messages == null) {
			//TempDataHolder.initializeTempDataHolder();
			//TempDataHolder.addString("Temp");
			//messages = TempDataHolder.getMessages();
			messages = new ArrayList<String>();
		}
		// if (devices.isEmpty()) {
		// out.print("<h2>No devices registered!</h2>");
		// } else {
		out.print("<h2>" + messages.size() + " Messages are in queue</h2>");
		out.print("<form name='form' method='POST' action='deleteAll'>");
		out.print(" List of all messages <br>");
		for (String temp : messages) {
			out.print(temp);
			out.print("<br>");
		}
		out.print("<br>");
		out.print("<input type='submit' name='clear' value='Clear' />");
		out.print("<br>");
		out.print("You can click the button to Clear all the Received Messages");
		out.print("<br>");
		out.print("</form>");
		// }
		out.print("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doGet(req, resp);
	}

}
