package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.User;

public class DButil {
	private String user ="root";
	private String pwd = "123";
	private String url ="jdbc:mysql://localhost:3306/ggb";
	private String driver ="com.mysql.jdbc.Driver";
	
		static Connection con = null;
		static PreparedStatement statement = null;
		static ResultSet rest = null;

	public Connection getConnerction() throws Exception{
		Class.forName(driver);
		return con = DriverManager.getConnection(url, user, pwd); 
	}
	public List login(Connection con,User user) throws Exception {
		List<User> list = new ArrayList<User>();
		statement = con.prepareStatement("select * from user where username=? and pwd=?");
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPwd());
		rest = statement.executeQuery();
		if(rest.next()) {
			list.add(user);
		}
		return list;
	}
	public void closeAll() throws Exception {
		rest.close();
		statement.close();
		con.close();
	}
}
