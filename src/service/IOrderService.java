package service;

import java.util.*;

import entity.*;

public interface IOrderService {

	//ȡ�ܶ���Id
	int getOrderId();
	//�����ܶ���
	int addOrder(Order o2);
	
	int addDetail(Detail d2);
}
