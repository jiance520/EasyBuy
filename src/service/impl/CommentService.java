package service.impl;

import java.util.*;

import dao.*;
import dao.impl.*;
import entity.*;
import service.ICommentService;

public class CommentService implements ICommentService{

	private ICommentDao dao = new CommentDao();
	
	public HashMap getPageComment(int pageno, int pagesize) {
		
		//return dao.getPageComment(pageno, pagesize);
		return dao.getPage2(pageno, pagesize);
	}

	
	public int addComment(Comment c2) {
		
		return dao.addComment(c2);
	}

}
