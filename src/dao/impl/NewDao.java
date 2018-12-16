package dao.impl;

import java.util.*;
import java.sql.*;

import dao.INewDao;
import entity.*;

public class NewDao extends BaseDao implements INewDao {

	public ArrayList<News> getSevenNews() {
		init();
		ArrayList<News> list = new ArrayList<News>();
		String sql =" select * from ( "+       
        " select to_char(n.en_create_time,'yyyy-MM-dd') as ctime "+
        " ,n.* from easybuy_news n order by n.en_id desc "+
        " ) t where rownum <=7 ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				News temp = new News();
				     temp.setId(rs.getInt("EN_ID"));
				     temp.setTitle(rs.getString("EN_TITLE"));
				     temp.setContent(rs.getString("EN_CONTENT"));
				     temp.setCtime(rs.getString("ctime"));
				     
			   list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}

	
	public ArrayList<News> getAllNews() {
		init();
		ArrayList<News> list = new ArrayList<News>();
		String sql =" select to_char(n.en_create_time,'yyyy-MM-dd') as ctime "+
                  " ,n.* from easybuy_news n order by n.en_id desc ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				News temp = new News();
				     temp.setId(rs.getInt("EN_ID"));
				     temp.setTitle(rs.getString("EN_TITLE"));
				     temp.setContent(rs.getString("EN_CONTENT"));
				     temp.setCtime(rs.getString("ctime"));
				     
			   list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}

	
	public News getOneNew(int id) {
		init();
		News temp = new News();
		String sql =" select to_char(n.en_create_time,'yyyy-MM-dd') as ctime "+
		       " ,n.* from easybuy_news n "+
		       " where n.en_id = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			                  stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				     temp.setId(rs.getInt("EN_ID"));
				     temp.setTitle(rs.getString("EN_TITLE"));
				     temp.setContent(rs.getString("EN_CONTENT"));
				     temp.setCtime(rs.getString("ctime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return temp;
	}

}
