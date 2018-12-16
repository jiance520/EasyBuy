package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import service.*;
import service.impl.*;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
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
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String veryCode = request.getParameter("veryCode");
		
		Object  vobj = request.getSession().getAttribute("rand");
		
		//验证码判断
		if(veryCode.equalsIgnoreCase((String)vobj)){
			IUserService us = new UserService();
			Users u2 = us.ifLogin(userName, passWord);
			if(u2 != null){ // 成功

				// user 放 session
				request.getSession().setAttribute("userinfo", u2);
				response.sendRedirect("IndexAction");
			}else{
				request.setAttribute("loginerror", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("veryerror", "验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
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
