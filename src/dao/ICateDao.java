package dao;

import java.util.*;
import entity.*;

public interface ICateDao {

	//�鸸���
	ArrayList<Cate> getParent();
	
	//���ݸ�id�������
	ArrayList<Cate> getChlids(int pid);
	
	//�������id�����
	Cate getCate(int id);
	
}
