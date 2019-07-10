package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.News;

public class NewsDao {
	JDBCUtil  jb=null;
	public NewsDao() {
		jb=new JDBCUtil();
	}
	public List<News> getAllNews(String xuz,String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select n.*,u.username from user u,news n where n.userid=u.id";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where title like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where content like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("2")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where username like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where title like ? or content like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		else if(xuz.equals("02")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where title like ? or username like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("12")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where username like ? or content like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("012")){
			sql="select n.* ,u.username  from user u join news n on n.userid=u.id where title like ? or content like ? or username like ?";
			params=new Object[3];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			params[2]="%"+query+"%";
			}
		ResultSet rs=jb.QueryData(sql, params);
		List<News> list=new ArrayList<News>();
		try {
			while(rs.next()) {
				News news=new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setUsername(rs.getString("username"));
				news.setPubtime(rs.getString("pubtime"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int updateNews(News n) {
		String sql = "update news set title=?,content=?,pubtime=? where id=?";
		Object params[] = {n.getTitle(),n.getContent(),n.getPubtime(),n.getId()};
	    return jb.updateData(sql, params);

	}
	public int DeletNews(int id) {
		String sql = "delete from news where id=?";
		Object params[] = {id};
	    return jb.updateData(sql, params);
	}
	public int AddNews(News n) {
		String sql = "insert into news(title,content,userid,pubtime)values(?,?,?,?)";
		Object params[] = { n.getTitle(), n.getContent(), n.getUserid(), n.getPubtime() };
		return jb.updateData(sql, params);
	}
	public News getview(int id) {
		String sql="select n.* ,u.username  from user u join news n on n.userid=u.id where n.id=? ";
		Object params[] = {id};
		ResultSet rs=jb.QueryData(sql, params);
		News news=new News();
		try {
			if(rs.next()) {
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setUsername(rs.getString("username"));
				news.setPubtime(rs.getString("pubtime"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

}
