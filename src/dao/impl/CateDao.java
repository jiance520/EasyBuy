package dao.impl;

import dao.ICateDao;

import java.sql.*;

import entity.*;

import java.util.*;

public class CateDao extends BaseDao implements ICateDao {

	public ArrayList<Cate> getParent() {
		init();
		ArrayList<Cate>  list = new ArrayList<Cate>();
		String sql = " select * from easybuy_product_category where epc_id = epc_parent_id ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cate cc = new Cate();
				     cc.setId(rs.getInt("EPC_ID"));
				     cc.setName(rs.getString("EPC_NAME"));
				     cc.setPid(rs.getInt("EPC_PARENT_ID"));
				
				list.add(cc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}


	public ArrayList<Cate> getChlids(int pid) {
		init();
		ArrayList<Cate>  list = new ArrayList<Cate>();
		String sql = " select * from easybuy_product_category "+
        " where epc_id != epc_parent_id and epc_parent_id = ? " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, pid);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cate cc = new Cate();
				     cc.setId(rs.getInt("EPC_ID"));
				     cc.setName(rs.getString("EPC_NAME"));
				     cc.setPid(rs.getInt("EPC_PARENT_ID"));
				
				list.add(cc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}

	
	public Cate getCate(int id) {
		init();
		Cate cc = new Cate();
		String sql = " select * from easybuy_product_category "+
				     " where epc_id = ? ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				
				     cc.setId(rs.getInt("EPC_ID"));
				     cc.setName(rs.getString("EPC_NAME"));
				     cc.setPid(rs.getInt("EPC_PARENT_ID"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return cc;
	}
	
	
}
