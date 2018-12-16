package dao;

import java.util.*;
import entity.*;

public interface ICommentDao {

	//分页
	HashMap getPageComment(int pageno,int pagesize);
	
	//分页2  pageno : 第几页 ， pagesize ： 一页几行
	HashMap getPage2(int pageno,int pagesize);
	
	//添加留言
	int addComment(Comment c2);
}
