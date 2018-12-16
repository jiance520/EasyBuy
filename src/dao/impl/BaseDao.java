package dao.impl;

import java.sql.*;

public class BaseDao {

	protected Connection con = null;
	
	protected void init(){
		con = JdbcUtil1.getConn();
	}
	
	protected void close(){
		JdbcUtil1.closeConn();
	}
}
