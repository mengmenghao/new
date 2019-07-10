package com.cn.service;

import java.util.List;

import com.cn.dao.UserDao;
import com.cn.vo.User;

public class UserService {
	UserDao uDao = null;

	public UserService() {
		uDao = new UserDao();

	}

	public User login(String user, String pass,String type) {
         return  uDao.selectUser(user, pass,type);
	}
	public int addUser(User u) {
		return  uDao.addUser(u);
	}
	public int userupdate(User u) {
		return  uDao.userupdate(u);
	}
	public int deletUser(int id) {
		return  uDao.deleteUser(id);
	}
	public boolean checkuser(String user) {
		return uDao.checkuser(user);
	}
	public List<User> getAllUser(String xuz,String query){
		return uDao.getAllUser(xuz,query);
	}
	public User getUserByName(String name){
		return uDao.getUserByName(name);
	}
	public int updateuser(String username,String password,String sex,String type,int id) {
		return uDao.updateUser(username, password,sex, type, id);
	}
	public int updatepass(int id,String password2) {
		return uDao.updatepass(id, password2);
	}
	public User seleteUser(int id) {
		return  uDao.getview(id);
	}
	public int updateType(User u) {
		return uDao.updateType(u);
	}
}
