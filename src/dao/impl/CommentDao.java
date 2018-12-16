package dao.impl;

import java.sql.*;
import java.util.*;

import dao.ICommentDao;
import entity.*;

public class CommentDao extends BaseDao implements ICommentDao {

	public HashMap getPageComment(int pageno, int pagesize) {
	    HashMap hm = new HashMap();
		init();
		int pagenum =1;//真实页数，不能大于最大页数
		int pagecount =1;//最大页数
		ArrayList<Comment> list = new ArrayList<Comment>();//留言的集合
		//--------------------------------------------
		String sql = " select count(ec_id) from easybuy_comment ";//用总记录数来算出总页数
		//1.取总记录数
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			int count = 0;
			if(rs.next()){
				count = rs.getInt(1);
			}
			//判断
			if(count > 0){
			//2 .取总页数
				if(count % pagesize == 0){
					pagecount = count / pagesize ;
				}else{
					pagecount = count / pagesize  +  1 ;
				}
			//3.看传下来的页数在  1 - pagecount 之间
				if(pageno < 1){
					
					pagenum = 1;
				}else if(pageno > pagecount){
					
					pagenum = pagecount;
				}else{
					
					pagenum = pageno;
				}
			//4.取数据	
				sql = " select to_char(cc.ec_create_time,'yyyy-MM-dd hh24:mi:ss') as ctime, "+
					  " to_char(cc.ec_reply_time,'yyyy-MM-dd hh24:mi:ss') as rtime, "+
					  " cc.* from ( "+
					  " select row_number() over(order by c2.ec_id desc) as rid "+
					  " ,c2.* from easybuy_comment c2 "+
					  " ) cc where cc.rid>? and cc.rid <=? ";
				System.out.println(" --- sql = "+sql);
				
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, (pagenum-1)*pagesize);
				stmt.setInt(2, pagenum*pagesize);
				
				rs = stmt.executeQuery();
				while(rs.next()){
					Comment cc = new Comment();
					cc.setId(rs.getInt("EC_ID"));
					cc.setContent(rs.getString("EC_CONTENT"));
					cc.setCtime(rs.getString("ctime"));
					cc.setReply(rs.getString("EC_REPLY"));
					cc.setRtime(rs.getString("rtime"));
					cc.setName(rs.getString("EC_NICK_NAME"));
					
					list.add(cc);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    //------------------------------------------
		hm.put("pagenum", pagenum);
		hm.put("pagecount", pagecount);
		hm.put("list", list);
		
		close();
		return hm;
	}

	public int addComment(Comment c2) {
		int num = 0;
		init();
		String sql = " insert into EASYBUY_COMMENT "+
        " values(news_seq.nextval, ?, sysdate, null, null, ?) " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			                  stmt.setString(1, c2.getContent());
			                  stmt.setString(2, c2.getName());
			                  
			num = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return num;
	}

	// 分页2
	public HashMap getPage2(int pageno, int pagesize) {
		HashMap hm = new HashMap();
		init();
		int pagenum = 1 ; //第几页（验证后的）
		int pagecount = 1 ;//总页数
		List<Comment> list = new ArrayList<Comment>(); // 页面数据
		//------------------------------------------------
		//分页流程
		try {
			String sql = " select count(ec_id) from easybuy_comment " ;
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			//1 . 找总记录数 
			int allnum = 0;
			while(rs.next()){
				allnum = rs.getInt(1);
			}
			// 判断 总记录数  > 0
			if(allnum > 0){
			 // 2.	计算总页数 
				if(allnum % pagesize==0){
					pagecount = allnum / pagesize ;
				}else{
					pagecount = allnum / pagesize  + 1 ;
				}
			// 3. 验证页码
				if(pageno < 1){ 
					pagenum = 1 ;
				}else if(pageno > pagecount){
					pagenum = pagecount ;
				}else{
					pagenum = pageno ;
				}
			// 4. 取页面数据  	
				sql =" select to_char(t2.ec_create_time,'yyyy-mm-dd hh24:mi:ss') as ctime, "+
					 " t2.* from ( "+
					 " select row_number() over(order by ec_id desc) as rid , "+
					 " e.* from easybuy_comment e "+
					 " ) t2 where t2.rid >? and t2.rid <=? " ;
				System.out.println(" sql = "+sql);
				//执行查询
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, (pagenum-1)*pagesize); //思考下
				stmt.setInt(2, pagenum*pagesize); //mysql pagesize
				
				rs = stmt.executeQuery();
				while(rs.next()){
					Comment temp = new Comment();
					temp.setId(rs.getInt("EC_ID"));
					temp.setContent(rs.getString("EC_CONTENT"));
					temp.setCtime(rs.getString("ctime"));
					temp.setReply(rs.getString("EC_REPLY"));
					temp.setName(rs.getString("EC_NICK_NAME"));
					
					list.add(temp);//加入集合 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//------------------------------------------------
		hm.put("pagenum", pagenum);
		hm.put("pagecount", pagecount);
		hm.put("list", list);
		
		close();
		return hm;
	}

}
