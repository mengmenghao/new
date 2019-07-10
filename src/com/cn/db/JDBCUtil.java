package com.cn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	 Connection connection=null;
	  PreparedStatement preparedStatement=null;
	  ResultSet  rSet=null;
	  public JDBCUtil() {
		  getConnection();
	  }
	  
	  public void getConnection() {
		  try {
			String url = "jdbc:mysql:localhost//:3306/new?characterEncoding=utf-8";
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public int updateData(String sql,Object[]params) {//增、删、改的方法
		 int result=-1;
		  try {
			preparedStatement=connection.prepareStatement(sql);
			  if(params!=null) {
				  for(int i=0;i<params.length;i++) {
					  preparedStatement.setObject(i+1, params[i]); 
				  }
			  }
			  result=  preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result; 
		  
	  }
	  
	  public ResultSet QueryData(String sql,Object[]params) {//查询
			 
			  try {
				preparedStatement=connection.prepareStatement(sql);
				  if(params!=null) {
					  for(int i=0;i<params.length;i++) {
						  preparedStatement.setObject(i+1, params[i]); 
					  }
				  }
				  rSet=  preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return rSet; 
			  
		  }
	  public ResultSet Select(String sql) {
		  try {
			preparedStatement=connection.prepareStatement(sql);
			 rSet=  preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;
	  }
	  public void close() {
			try {
				if (rSet != null) {
					rSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}
