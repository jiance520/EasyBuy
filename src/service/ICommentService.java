package service;

import java.util.*;
import entity.*;

public interface ICommentService {

	//��ҳ
	HashMap getPageComment(int pageno,int pagesize);
		
	//�������
	int addComment(Comment c2);
}
