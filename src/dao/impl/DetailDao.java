package dao.impl;

import dao.IDetailDao;
import entity.*;

import java.sql.*;
import java.util.*;

public class DetailDao extends BaseDao implements IDetailDao {

	public int addDetail(Detail d2) {
		int num =0;
		init();
		String sql = " insert into EASYBUY_ORDER_DETAIL "+
                     " values(order_seq.nextval, ?, ?, ?, ?) " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, d2.getOrderId());
			stmt.setInt(2, d2.getProductId());
			stmt.setInt(3, d2.getQuantity());
			stmt.setDouble(4, d2.getCost());
			
			num = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return num;
	}

}
