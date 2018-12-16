package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import entity.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ajax 测试
public class CheckAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("uid");
		System.out.println(" --- uid = "+uid);
		/*int id = 0;
		try {
			id = Integer.parseInt(uid);
		} catch (Exception e) {
			id = 0;
		}*/
		
		IUserService us = new UserService();
		Users u2 = us.getUser(uid);
		
		String js = "true" ;
		
		if(u2.getUserId() == null && u2.getUserName() == null){
			js = "false" ;
		}
		
		out.print(js);
		
		out.flush();
		out.close();
		
		// ajax 不能转发和重定向
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
