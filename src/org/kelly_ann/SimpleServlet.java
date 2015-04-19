package org.kelly_ann;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * How to write a servlet:
 * Step 1:  Extend the "HttpServlet" class.
 * Step 2:  Add the @WebServlet annotation to your class and include the "urlPatterns" property.
 * Step 3:  Need a "doGet() method since this is the default method that gets called by any browser.
 * 
 * How a servlet works:
 * In the URL "http://localhost:8080/SimpleServletProject/SimpleServlet" the application context accesses
 * the "SimpleServletProject" and the servlet context accesses the @WebServlet annotation which has 
 * the "urlPatterns = {/SimpleServlet"} that tells Tomcat to execute this java class. 
 * Once this class is accessed, by default, it accesses the doGet method.
 * Note!  The "urlPatterns" can be anything.  It does NOT have match with the class name.  
 * It is a String[] so if you supply it with multiple urlPatterns all of them can be used to access this class.
 */

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServlet", "/AdvancedServlet"})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this will print both to the console and server log files
		System.out.println("Hello from Servlet GET method.");
		// this will print to the web page 
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Hello from Servlet GET method -- on the web page!</h3>");
	}

}
