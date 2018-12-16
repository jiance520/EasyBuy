package service;

import java.util.*;
import entity.*;

public interface ICommentService {

	//∑÷“≥
	HashMap getPageComment(int pageno,int pagesize);
		
	//ÃÌº”¡Ù—‘
	int addComment(Comment c2);
}
