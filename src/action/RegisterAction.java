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

public class RegisterAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterAction() {
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
		
        String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String idCode = request.getParameter("idCode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		
		String veryCode = request.getParameter("veryCode");
		
		Object  vobj = request.getSession().getAttribute("rand");
		
		//ÑéÖ¤ÂëÅÐ¶Ï
		if(veryCode.equalsIgnoreCase((String)vobj)){
			IUserService us = new UserService();
			//×¢²á
			Users  u2 = new Users();
			       u2.setUserId(userId);
			       u2.setUserName(userName);
			       u2.setPassword(password);
			       u2.setSex(sex);
			       u2.setBirthday(birthday);
			       u2.setIdCode(idCode);
			       u2.setEmail(email);
			       u2.setMobile(mobile);
			       u2.setAddress(address);
			
			int num = us.addNormalUser(u2) ;  // ×¢²á
			if(num > 0){ // ³É¹¦
				
				response.sendRedirect("/EasyBuy/login.jsp");
			}else{
				request.setAttribute("regerror", "×¢²áÊ§°Ü");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("veryerror", "ÑéÖ¤Âë´íÎó");
			request.getRequestDispatcher("register.jsp").forward(request, response);
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
