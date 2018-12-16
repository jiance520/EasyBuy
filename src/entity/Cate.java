package entity;

import java.util.*;
/*
 * 商品类别
 */
public class Cate {

	private int id ;
	private String name;
	private int pid ;
	
	private ArrayList<Cate> clist = new ArrayList<Cate>();
	
	public ArrayList<Cate> getClist() {
		return clist;
	}

	public void setClist(ArrayList<Cate> clist) {
		this.clist = clist;
	}

	public Cate(int id, String name, int pid) {
		this();
		setId(id);
		setName(name);
		setPid(pid);
	}
	
	public Cate() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
