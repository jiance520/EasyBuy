package dao;

import java.util.*;
import entity.*;

public interface IOrderDao {

	//ȡ�ܶ���Id
	int getOrderId();
	
	//�����ܶ���
	int addOrder(Order o2);
}
