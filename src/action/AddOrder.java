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

public class AddOrder extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddOrder() {
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

		String[] pids = request.getParameterValues("pid"); //产品 id
		String[] numbers = request.getParameterValues("number"); // 购买数量
		
		IProductService ps = new ProductService();
		IOrderService os = new OrderService();
		
		//取用户信息
		Users u2 = (Users)request.getSession().getAttribute("userinfo");
		//取总订单id
		int orderid = os.getOrderId();
		
		//算总价
		double cost = 0;
		for(int i=0;i<pids.length;i++){
			int pid = Integer.parseInt(pids[i]);
			int number = Integer.parseInt(numbers[i]);
			
			Product temp = ps.getProductById(pid);
			
			cost += temp.getPrice() * number ;
		}
		// 保存总订单
		Order o2 = new Order();
		      o2.setId(orderid);
		      o2.setUserId(u2.getUserId());
		      o2.setName(u2.getUserName());
		      o2.setAddress(u2.getAddress());
		      o2.setCost(cost);
		      
		int onum = os.addOrder(o2);
		//保存子订单
		if(onum > 0){
		    
			for(int i=0;i<pids.length;i++){
				int pid = Integer.parseInt(pids[i]);
				int number = Integer.parseInt(numbers[i]);
				
				Product temp = ps.getProductById(pid);
				
				Detail d2 = new Detail();
				       d2.setOrderId(orderid);
				       d2.setProductId(pid);
				       d2.setQuantity(number);
				double price = temp.getPrice() * number ;
				       d2.setCost(price);
				 
				os.addDetail(d2);
			}
			
		}else{
			throw new ServletException("保存总订单失败！！！");
		}
		// 清空 session 中 的 shoplist
		request.getSession().removeAttribute("shoplist");
		
		response.sendRedirect("shopping-result.jsp");
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
