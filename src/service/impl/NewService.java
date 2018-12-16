package service.impl;

import java.util.*;

import dao.*;
import dao.impl.*;
import entity.*;
import service.INewService;

public class NewService implements INewService {

	private INewDao dao = new NewDao();
	
	public ArrayList<News> getSevenNews() {
		
		return dao.getSevenNews();
	}

	
	public ArrayList<News> getAllNews() {
		
		return dao.getAllNews();
	}

	
	public News getOneNew(int id) {
		
		return dao.getOneNew(id);
	}

}
