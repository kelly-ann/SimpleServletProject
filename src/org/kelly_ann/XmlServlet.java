package org.kelly_ann;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class XmlServlet extends HttpServlet {
	
	// the GET method is used to show information from within the application to the browser.
	// note that in the GET method you see the request param in the URL and you do not in the POST method.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		out.println("Hello from GET method " + userName + ".");
	}
	
	// POST method is used to return information from the user to the application
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");  // this parameter name MUST match the one in SimpleForm.html
		String fullName = request.getParameter("fullName");
		out.println("Hello from POST method " + userName + "! We know your full name is " + fullName + ".");
		String prof = request.getParameter("prof");
		out.println("You are a " + prof + ".");
		//String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		out.println("You are at " + location.length + " places.");
		for(int i = 0; i < location.length; i++) {
			out.println(location[i]);
		}
	}
}
