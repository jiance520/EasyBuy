package service.impl;

import service.IProductService;

import java.util.*;

import entity.*;
import dao.*;
import dao.impl.*;

public class ProductService implements IProductService {

	private ICateDao  cateDao = new CateDao();
	private IProductDao  productDao = new ProductDao();
	
	public ArrayList<Cate> getParent() {
		
		return cateDao.getParent();
	}
	
	public ArrayList<Cate> getChlids(int pid) {
		
		return cateDao.getChlids(pid);
	}
	
	public Cate getCate(int id) {
		
		return cateDao.getCate(id);
	}
	
	public ArrayList<Cate> getAllCate() {
		ArrayList<Cate> all = new ArrayList<Cate>();
		
		all  = getParent(); //取父类
		
		for(Cate c2 : all){
			int pid = c2.getId();
			
			ArrayList<Cate> clist = getChlids(pid);//取子类
			
			c2.setClist(clist);
		}
		
		return all;
	}

	
	public ArrayList<Product> getProductForName(String name) {
		
		return productDao.getProductForName(name);
	}

	public Product getProductById(int id) {
		
		return productDao.getProductById(id);
	}

	public ArrayList<Product> getProductForChild(int cid) {
		
		return productDao.getProductForChild(cid);
	}
	
}
