package service;

import java.util.*;

import entity.*;

public interface IUserService {

	//����ǰ̨�û�
	int addNormalUser(Users u2);
		
	//��¼
	Users ifLogin(String userId,String password);
		
	//��userId���û�
	Users getUser(String userId);
	
}
