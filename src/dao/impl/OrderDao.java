package dao.impl;

import dao.IOrderDao;
import entity.*;

import java.util.*;
import java.sql.*;

public class OrderDao extends BaseDao implements IOrderDao {

	public int getOrderId() {
		int num=0;
		init();
		String sql = " select order_seq.nextval from dual ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		close();
		return num;
	}

	
	public int addOrder(Order o2) {
		int num =0;
		init();
		String sql = " insert into EASYBUY_ORDER "+
                     " values(?, ?, ?, ?, sysdate, ?, 1, 1) ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			                  stmt.setInt(1, o2.getId());
			                  stmt.setString(2, o2.getUserId());
			                  stmt.setString(3, o2.getName());
			                  stmt.setString(4, o2.getAddress());
			                  stmt.setDouble(5, o2.getCost());
			                  
			num = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return num;
	}

}
