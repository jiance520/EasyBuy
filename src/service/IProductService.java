package service;

import java.util.*;

import entity.*;

public interface IProductService {

	//查父类别
	ArrayList<Cate> getParent();
		
	//根据父id找子类别
	ArrayList<Cate> getChlids(int pid);
		
	//根据类别id找类别
	Cate getCate(int id);
	
	//查主页要用的类别
	ArrayList<Cate> getAllCate();
	
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
