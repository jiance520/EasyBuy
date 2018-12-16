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

public class IndexAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IndexAction() {
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

		IProductService ps = new ProductService();
		// �ؼ���Ʒ
        List<Product> tjlist = ps.getProductForName("�ؼ�");
		// ������Ʒ
        List<Product> rmlist = ps.getProductForName("����");
		// ȡ��� 
        List<Cate> allcate = ps.getAllCate();
        
		INewService ns = new NewService();
		// ���� 7������
        List<News> sevennews = ns.getSevenNews();
        // ��������
        List<News> allnews = ns.getAllNews();
        
       // �� Cookie 
       //��ȡCookie
		String his = null;
		Cookie[] carr = request.getCookies(); 
		if(carr != null){
			for(Cookie cc :carr){
				if(cc.getName().equals("history")){
					his = cc.getValue();
					System.out.println("his"+his);
				}
			}
		}
        
		List<Product> hislist = new ArrayList<Product>();
		//�ж�
		if(his != null){
			// ���
			String[] harr = his.split("#");//��һ���ַ����ָ�Ϊ���ַ���,Ȼ�󽫽����Ϊ�ַ������鷵�ء� 
			System.out.println(" harr = " + Arrays.toString(harr));
			if(harr.length > 1){
				// ȡ��� 2 �� 
				int id1 = Integer.parseInt(harr[harr.length-1]);
				int id2 = Integer.parseInt(harr[harr.length-2]);
				
				Product p1 = ps.getProductById(id1);
				Product p2 = ps.getProductById(id2);
				
				hislist.add(p1);
				hislist.add(p2);
			}else{
				int id = Integer.parseInt(harr[0]);
				Product p1 = ps.getProductById(id);
				hislist.add(p1);
			}
		}
		
		request.setAttribute("hislist", hislist);
        request.setAttribute("allnews", allnews);
        request.setAttribute("sevennews", sevennews);
        request.setAttribute("allcate", allcate);
        request.setAttribute("tjlist", tjlist);
        request.setAttribute("rmlist", rmlist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
