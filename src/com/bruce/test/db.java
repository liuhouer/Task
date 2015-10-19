package com.bruce.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class db {
	 
	public static Connection getConnection() {
		// (1)加载MySQL的JDBC的驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 取得连接的url,能访问MySQL数据库的用户名,密码,数据库名
		String url = "jdbc:mysql://localhost:3306/"
				+ "test?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "root";
		// (2)创建与MySQL数据库的连接类的实例

		Connection con =null;
		try {
			con = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con==null){
			con = getConnection();
		}
		return con;
	}

}
