package dao;

import java.util.*;
import entity.*;

public interface INewDao {

	//最新7条新闻
	ArrayList<News> getSevenNews();
	
	//所有新闻
	ArrayList<News> getAllNews();
	
	//单条新闻
	News getOneNew(int id);
	
}
