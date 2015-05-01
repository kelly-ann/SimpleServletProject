package org.kelly_ann;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@WebServlet(description = "A simple servlet", urlPatterns = {"/SimpleServlet", "/AdvancedServlet", "/SimpleServletPath"},
			initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * How this works:
		 * the "?ParamNameHere=blah" that can be added to the URL when calling it.  After you have called it once it will store/cache it
		 * in the HttpSession object which you get via the HttpServletRequest object.  Therefore, if you remove the param from 
		 * the URL after that the browser will still have the previously cached value in the session object even though the 
		 * request parameter is blank.  This will stay stored until the session variable expires or is overwritten by another 
		 * supplied param value.  
		 * Ex: ".../SimpleServletPath?name=kelly"  will store "kelly" in both the request and the "session" objects below.
		 * 
		 * HttpSession object use cases: login screens, shopping carts, etc.
		 * A session object is per user/machine.  It is also only useful via the same browser on a user's machine.
		 * 
		 * Context object use cases: initialization code (e.g. 1 SHARED db connection for all users), community bulletin board, etc.
		 * A context object is shared (globally) across the application for ALL users and machines and browsers.
		 * 
		 * The servlet class inheritance tree is (from top down): GenericServlet --> HttpServlet --> MyServletName (ex: SimpleServlet).
		 * 
		 * The init() method is the first one executed by any servlet.  It can be overridden.
		 * It is used for initialization code and executes once per servlet.  Init() parameters can be configured using annotations or
		 * in the web.xml file using <init-param>.
		 * 
		 * The second method executed is service().  It checks for what type of HTTP request it is and returns the correct HTTP method
		 * (i.e. doPost(), doGet(), etc.).  If the MyServletName class does not override the doXXX() methods an Unsupported exception is
		 * thrown by the HttpServlet parent class.
		 * 
		 */
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		
		writer.println("Request parameter has username as " + userName + ". ");
		writer.println("Session parameter has username as " + (String) session.getAttribute("savedUserName") + ". ");
		writer.println("Context parameter has username as " + (String) context.getAttribute("savedUserName") + ". ");
		writer.println("Init parameter has default username as " + getServletConfig().getInitParameter("defaultUser") + ". ");
	}

}
