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

public class Guestbook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Guestbook() {
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
		// ȡ��� 
        List<Cate> allcate = ps.getAllCate();
        
        int pageno=1; 
        int pagesize=3;
        //����ҳ��
        String pno = request.getParameter("pno");
        try{
        	pageno = Integer.parseInt(pno);
        }catch(Exception e){
        	pageno = 1;
        }
        
        ICommentService cs = new CommentService();
	    //ȡ��ҳ����
        HashMap hm = cs.getPageComment(pageno, pagesize);
        
        int pagenum = (Integer)hm.get("pagenum") ; //�ڼ�ҳ����֤��ģ�
		int pagecount = (Integer)hm.get("pagecount")  ;//��ҳ��
		List<Comment> list = (List<Comment>)hm.get("list"); // ҳ������
        
		request.setAttribute("pagenum", pagenum);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("list", list);
        request.setAttribute("allcate", allcate);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
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
