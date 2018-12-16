package service;

import java.util.*;

import entity.*;

public interface IOrderService {

	//取总订单Id
	int getOrderId();
	//新增总订单
	int addOrder(Order o2);
	
	int addDetail(Detail d2);
}
