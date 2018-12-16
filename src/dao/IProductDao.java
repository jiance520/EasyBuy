package dao;

import java.util.*;
import entity.*;

public interface IProductDao {
	
	/*
	 * 按描述找产品
	 */
	ArrayList<Product> getProductForName(String name);
	
	/*
	 * 按产品 id 找 产品
	 */
	Product getProductById(int id);
	
	/*
	 * 子类别id 找产品
	 */
	ArrayList<Product> getProductForChild(int cid);
}
