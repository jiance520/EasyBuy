package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import entity.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneProduct extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OneProduct() {
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

		String pid = request.getParameter("pid");
		
		int id = 0;
		try {
			 id = Integer.parseInt(pid);
		} catch (Exception e) {
			id = 0;
		}
		
		IProductService ps = new ProductService();
		
		Product pone = ps.getProductById(id); // ȡ��Ʒ����Ϣ
		
		//ȡ�����Ϣ
		List<Cate> allcate = ps.getAllCate();
		
		// ȡ��Ʒ�� ����
		Cate parentCate = ps.getCate(pone.getParentId());
		// ȡ��Ʒ�� ����
		Cate childCate = ps.getCate(pone.getChildId());
		
		if(pone.getId() > 0){
			// ����cookie : history
			//��ȡCookie
			String his = null;
			Cookie[] carr = request.getCookies(); 
			if(carr != null){
				for(Cookie cc :carr){
					if(cc.getName().equals("history")){
						his = cc.getValue();
					}
				}
			}
			//�ж��ǲ��ǵ�һ�α���
			if(his == null){
				Cookie  c2 = new Cookie("history", ""+pone.getId());
				        c2.setMaxAge(3600);
				response.addCookie(c2); // д Cookie
			}else{
				his= his + "#" + pone.getId();
				Cookie  c2 = new Cookie("history", his);
		        		c2.setMaxAge(3600);
				response.addCookie(c2); // д Cookie
			}
			// 
		}
	
		request.setAttribute("childCate", childCate);
		request.setAttribute("parentCate", parentCate);
		request.setAttribute("allcate", allcate);
		request.setAttribute("pone", pone);
		request.getRequestDispatcher("product-view.jsp").forward(request, response);
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
