package service;

import java.util.*;

import entity.*;

public interface IUserService {

	//新增前台用户
	int addNormalUser(Users u2);
		
	//登录
	Users ifLogin(String userId,String password);
		
	//按userId查用户
	Users getUser(String userId);
	
}
