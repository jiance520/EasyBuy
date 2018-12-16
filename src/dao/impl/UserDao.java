package dao.impl;

import dao.IUserDao;
import entity.*;

import java.sql.*;
import java.util.*;

public class UserDao extends BaseDao implements IUserDao {

	public int addNormalUser(Users u2) {
		init();
		int num = 0;
		String sql = " insert into EASYBUY_USER values( ?, ?, ?, ?, to_date(?,'yyyy-MM-dd'), ?, ?, ?, ?, 1) ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u2.getUserId());
			stmt.setString(2, u2.getUserName());
			stmt.setString(3, u2.getPassword());
			stmt.setString(4, u2.getSex());
			stmt.setString(5, u2.getBirthday());
			stmt.setString(6, u2.getIdCode());
			stmt.setString(7, u2.getEmail());
			stmt.setString(8, u2.getMobile());
			stmt.setString(9, u2.getAddress());
			
			num = stmt.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		return num;
	}

	
	public Users ifLogin(String userId, String password) {
		Users temp = null;
		init();
		String sql = " select to_char(u.eu_birthday,'yyyy-MM-dd') as btime "+
                   " ,u.* from EASYBUY_USER u "+
                   " where u.eu_user_id = ? and u.eu_password = ? " ;
		try {
			PreparedStatement  stmt = con.prepareStatement(sql);
			                   stmt.setString(1, userId);
			                   stmt.setString(2, password);
			ResultSet  rs = stmt.executeQuery();
			while(rs.next()){
				temp = new Users();
				
				temp.setUserId(rs.getString("EU_USER_ID"));
				temp.setUserName(rs.getString("EU_USER_NAME"));
				temp.setPassword(rs.getString("EU_PASSWORD"));
				temp.setSex(rs.getString("EU_SEX"));
				temp.setBirthday(rs.getString("btime"));
				temp.setIdCode(rs.getString("EU_IDENTITY_CODE"));
				temp.setEmail(rs.getString("EU_EMAIL"));
				temp.setMobile(rs.getString("EU_MOBILE"));
				temp.setAddress(rs.getString("EU_ADDRESS"));
				temp.setStatus(rs.getInt("EU_STATUS"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		close();
		return temp;
	}

	
	public Users getUser(String userId) {
		Users temp = new Users();
	
		init();
		String sql = " select to_char(u.eu_birthday,'yyyy-MM-dd') as btime "+
                   " ,u.* from EASYBUY_USER u "+
                   " where u.eu_user_id = ? " ;
		try {
			PreparedStatement  stmt = con.prepareStatement(sql);
			                   stmt.setString(1, userId);
			                
			ResultSet  rs = stmt.executeQuery();
			while(rs.next()){
				
				temp.setUserId(rs.getString("EU_USER_ID"));
				temp.setUserName(rs.getString("EU_USER_NAME"));
				temp.setPassword(rs.getString("EU_PASSWORD"));
				temp.setSex(rs.getString("EU_SEX"));
				temp.setBirthday(rs.getString("btime"));
				temp.setIdCode(rs.getString("EU_IDENTITY_CODE"));
				temp.setEmail(rs.getString("EU_EMAIL"));
				temp.setMobile(rs.getString("EU_MOBILE"));
				temp.setAddress(rs.getString("EU_ADDRESS"));
				temp.setStatus(rs.getInt("EU_STATUS"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		close();
		return temp;
	}

}
