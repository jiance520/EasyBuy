package service;

import java.util.*;

import entity.*;

public interface INewService {

	//����7������
	ArrayList<News> getSevenNews();
		
	//��������
	ArrayList<News> getAllNews();
		
	//��������
	News getOneNew(int id);
}
