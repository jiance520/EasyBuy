package dao;

import java.util.*;
import entity.*;

public interface ICateDao {

	//查父类别
	ArrayList<Cate> getParent();
	
	//根据父id找子类别
	ArrayList<Cate> getChlids(int pid);
	
	//根据类别id找类别
	Cate getCate(int id);
	
}
