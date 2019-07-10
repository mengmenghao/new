package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.User;

public class UserDao {
	JDBCUtil  jb=null;
	public UserDao() {
		jb=new JDBCUtil();
	}
	
	public  User  selectUser(String user,String pass,String type) {//µÇÂ¼
		String sql="select * from user where username=? and password=? and type=?";
		Object params[]= {user,pass,type};
		ResultSet rSet= jb.QueryData(sql, params);
		User u=null;
		try {
			while(rSet.next()) {
				u=new User();
				u.setUsername(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setType(rSet.getString("type"));
				u.setFavourite(rSet.getString("favourite"));
				u.setProfession(rSet.getString("profession"));
				u.setSex(rSet.getString("sex"));
				u.setId(rSet.getInt("id"));
				System.out.println(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public  int addUser(User u) {
	String sql="insert into user(username,password,sex,profession,favourite,note)values(?,?,?,?,?,?)";
	Object  params[]= {u.getUsername(),u.getPassword(),u.getSex(),u.getProfession(),u.getFavourite(),u.getNote()};
	int i=jb.updateData(sql, params);
	return i;
	}
	public boolean checkuser(String user) {
		String sql="select * from user where username=?";
		Object params[]= {user};
		ResultSet rs= jb.QueryData(sql, params);
		boolean b=false;
		try {
			if(rs.next()) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public List<User> getAllUser(String xuz,String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select * from user";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select * from user where username like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select * from user where sex like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("2")){
			sql="select * from user where profession like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select * from user where username like ? or sex like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		else if(xuz.equals("02")){
			sql="select * from user where username like ? or profession like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("12")){
			sql="select * from user where profession like ? or sex like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("012")){
			sql="select * from user where profession like ? or sex like ? or username like ?";
			params=new Object[3];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			params[2]="%"+query+"%";
			}
		ResultSet rSet= jb.QueryData(sql, params);
		List<User> list=new ArrayList<User>();
		try {
			while(rSet.next()) {
				User user=new User();
				user.setId(rSet.getInt("id"));
				user.setUsername(rSet.getString("username"));
				user.setPassword(rSet.getString("password"));
				user.setSex(rSet.getString("sex"));
				user.setProfession(rSet.getString("profession"));
				user.setFavourite(rSet.getString("favourite"));
				user.setNote(rSet.getString("note"));
				user.setType(rSet.getString("type"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public User getUserByName(String name) {
		String sql="select * from user where username=?";
		Object params[] = {name};
		ResultSet resultSet=jb.QueryData(sql, params);
		User user=new User();
		try {
			if(resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setPassword(resultSet.getString("password"));
				user.setSex(resultSet.getString("sex"));
				user.setType(resultSet.getString("type"));
				user.setUsername(resultSet.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public  int updateUser(String username,String password,String sex,String type,int id) {
		String sql="update user u set u.username=?,u.password=?,u.sex=?,u.type=? where u.id=?";
		Object params[] = {username,password,sex,type,id};
		int i=jb.updateData(sql, params);
		return i;
	}
	public int updatepass(int id,String password2) {
		String sql="update user u set u.password=? where u.id=?";
		Object params[] = {password2,id};
		int i=jb.updateData(sql, params);
		return i;
	}
	public int userupdate(User u) {
		String sql="update user set username=?,sex=?,profession=?,favourite=?,note=? where id=?";
		Object  params[]= {u.getUsername(),u.getSex(),u.getProfession(),u.getFavourite(),u.getNote(),u.getId()};
		int i=jb.updateData(sql, params);
		return i;
	}
	public  int deleteUser(int id) {
		String sql="delete from user where id=?";
		Object params[] = {id};
		int i = jb.updateData(sql, params);
		return i;
	}
	public User getview(int id) {
		String sql="select *  from user where id=? ";
		Object params[] = {id};
		ResultSet rs=jb.QueryData(sql, params);
		User user=new User();
		try {
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setProfession(rs.getString("profession"));
				user.setFavourite(rs.getString("favourite"));
				user.setNote(rs.getString("note"));
				user.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public int updateType(User u) {//¸ü¸Ä
		
		String sql = "update user set type = ?  where id = ?";
		Object params[] = {u.getType(),u.getId()};
		return jb.updateData(sql, params);
		
	}
	
}

