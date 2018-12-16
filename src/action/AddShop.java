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

public class AddShop extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddShop() {
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
       
		String ids = request.getParameter("pid");
		
		//响应乱码处理
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		// 页面输出对象
		PrintWriter out = response.getWriter();
		
		int pid = 0;
		try{
			pid = Integer.parseInt(ids);
		}catch(Exception e){
			pid = 0;
		}
		
	    if(pid > 0){
	    	IProductService ps = new ProductService();
	    	Product pone = ps.getProductById(pid);
	    	
	    	// 先取 集合 有就加入， 没有新建
	    	Object sobj = request.getSession().getAttribute("shoplist");
	    	if(sobj != null){
	    		Map<Integer,Product> mp  = (Map<Integer,Product>)sobj;
	    		                     mp.put(pone.getId(), pone);
	    		                     
	    		request.getSession().setAttribute("shoplist",mp);                     
	    	}else{
	    		Map<Integer,Product> mp  = new HashMap<Integer, Product>();
                mp.put(pone.getId(), pone);
                
                request.getSession().setAttribute("shoplist",mp);    
	    	}
	    	
			String js = "<script>"+
					    "alert('加入购物车成功！');"+
	                    "window.location.href='/EasyBuy/OneProduct?pid="+pid+"';"+
	                    "</script>";
	    	out.print(js);
	    	//response.sendRedirect("/EasyBuy/OneProduct?pid="+pid);
		}else{
			out.print("<script>alert('加入购物车失败！！');</script>");
		}
		
	    out.flush();
	    out.close();
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
