package dao;

import java.util.*;
import entity.*;

public interface INewDao {

	//����7������
	ArrayList<News> getSevenNews();
	
	//��������
	ArrayList<News> getAllNews();
	
	//��������
	News getOneNew(int id);
	
}
