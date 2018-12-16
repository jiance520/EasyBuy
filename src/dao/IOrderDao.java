package dao;

import java.util.*;
import entity.*;

public interface IOrderDao {

	//取总订单Id
	int getOrderId();
	
	//新增总订单
	int addOrder(Order o2);
}
