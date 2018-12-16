package dao;

import java.util.*;
import entity.*;

public interface IProductDao {
	
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
