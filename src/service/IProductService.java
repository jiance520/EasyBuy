package service;

import java.util.*;

import entity.*;

public interface IProductService {

	//�鸸���
	ArrayList<Cate> getParent();
		
	//���ݸ�id�������
	ArrayList<Cate> getChlids(int pid);
		
	//�������id�����
	Cate getCate(int id);
	
	//����ҳҪ�õ����
	ArrayList<Cate> getAllCate();
	
	/*
	 * �������Ҳ�Ʒ
	 */
	ArrayList<Product> getProductForName(String name);
	
	/*
	 * ����Ʒ id �� ��Ʒ
	 */
	Product getProductById(int id);
	
	/*
	 * �����id �Ҳ�Ʒ
	 */
	ArrayList<Product> getProductForChild(int cid);
}
