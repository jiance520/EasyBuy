package dao.impl;

import dao.IProductDao;

import java.sql.*;

import entity.*;

import java.util.*;

public class ProductDao extends BaseDao implements IProductDao {

	public ArrayList<Product> getProductForName(String name) {
		ArrayList<Product> list = new ArrayList<Product>();
		init();
		String sql = " select p.* from easybuy_product p "+  
                     " where p.ep_description like ? " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			                  stmt.setString(1, "%"+name+"%");
			                  
			ResultSet  rs = stmt.executeQuery();
			while(rs.next()){
				Product temp = new Product();
				temp.setId(rs.getInt("EP_ID"));
				temp.setName(rs.getString("EP_NAME"));
				temp.setDescription(rs.getString("EP_DESCRIPTION"));
				temp.setFileName(rs.getString("EP_FILE_NAME"));
				temp.setPrice(rs.getDouble("EP_PRICE"));
				temp.setStock(rs.getInt("EP_STOCK"));
				temp.setParentId(rs.getInt("EPC_ID"));
				temp.setChildId(rs.getInt("EPC_CHILD_ID"));
				
				list.add(temp);
			}               
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}

	
	public Product getProductById(int id) {
		Product temp = new Product();
		init();
		String sql =" select p.* from easybuy_product p " + 
                    " where p.ep_id = ? " ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			                  stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				temp.setId(rs.getInt("EP_ID"));
				temp.setName(rs.getString("EP_NAME"));
				temp.setDescription(rs.getString("EP_DESCRIPTION"));
				temp.setFileName(rs.getString("EP_FILE_NAME"));
				temp.setPrice(rs.getDouble("EP_PRICE"));
				temp.setStock(rs.getInt("EP_STOCK"));
				temp.setParentId(rs.getInt("EPC_ID"));
				temp.setChildId(rs.getInt("EPC_CHILD_ID"));
			}               
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return temp;
	}

	
	public ArrayList<Product> getProductForChild(int cid) {
		ArrayList<Product> list = new ArrayList<Product>();
		init();
		String sql = " select p.* from easybuy_product p " + 
					 " where p.epc_child_id = ? " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			                  stmt.setInt(1, cid);
			                  
			ResultSet  rs = stmt.executeQuery();
			while(rs.next()){
				Product temp = new Product();
				temp.setId(rs.getInt("EP_ID"));
				temp.setName(rs.getString("EP_NAME"));
				temp.setDescription(rs.getString("EP_DESCRIPTION"));
				temp.setFileName(rs.getString("EP_FILE_NAME"));
				temp.setPrice(rs.getDouble("EP_PRICE"));
				temp.setStock(rs.getInt("EP_STOCK"));
				temp.setParentId(rs.getInt("EPC_ID"));
				temp.setChildId(rs.getInt("EPC_CHILD_ID"));
				
				list.add(temp);
			}               
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}
	
	
}
