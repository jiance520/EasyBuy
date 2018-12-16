package dao.impl;

import java.sql.*;

import oracle.jdbc.driver.OracleDriver;

/*
 * jdbc ������
 */
public class JdbcUtil1 {

	private static Connection con=null;
	
	private static String user="scott";
	private static String pwd="scott";
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	
	/*
	 * ������
	 */
	public static Connection getConn(){
		
		if(con == null){
			try {
				Class.forName(driver);
				
				con = DriverManager.getConnection(url, user,pwd);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
		}
		
		return con;
	}
	
	/*
	 * ������
	 */
	public static void closeConn(){
		
		if(con !=null){
			
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			//--------
		}
	}
}
