package service.impl;

import entity.*;

import java.util.*;

import dao.*;
import dao.impl.*;
import service.IOrderService;

public class OrderService implements IOrderService {

	private IOrderDao orderDao = new OrderDao();
	private IDetailDao  detailDao = new DetailDao();
	
	public int getOrderId() {
		
		return orderDao.getOrderId();
	}

	
	public int addOrder(Order o2) {
		
		return orderDao.addOrder(o2);
	}

	
	public int addDetail(Detail d2) {
		
		return detailDao.addDetail(d2);
	}

}
