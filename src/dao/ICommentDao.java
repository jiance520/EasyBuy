package dao;

import java.util.*;
import entity.*;

public interface ICommentDao {

	//��ҳ
	HashMap getPageComment(int pageno,int pagesize);
	
	//��ҳ2  pageno : �ڼ�ҳ �� pagesize �� һҳ����
	HashMap getPage2(int pageno,int pagesize);
	
	//�������
	int addComment(Comment c2);
}
