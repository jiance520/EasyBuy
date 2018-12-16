package service.impl;

import entity.*;
import java.util.*;
import dao.*;
import dao.impl.*;
import service.IUserService;

public class UserService implements IUserService {

	private IUserDao dao = new UserDao();
	
	public int addNormalUser(Users u2) {
		
		return dao.addNormalUser(u2);
	}

	
	public Users ifLogin(String userId, String password) {
		
		return dao.ifLogin(userId, password);
	}

	
	public Users getUser(String userId) {
		
		return dao.getUser(userId);
	}

}
