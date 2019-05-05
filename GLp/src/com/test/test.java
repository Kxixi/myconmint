package com.test;

import java.sql.Connection;
import java.util.List;

import com.domain.User;
import com.util.DButil;

public class test {
	public static void main(String[] args) throws Exception {
		DButil util =new DButil();
		Connection connerction = util.getConnerction();
		User user = new User();
		user.setUsername("zs");
		user.setPwd("123");
		List list = util.login(connerction, user);
		if(list.isEmpty()) {
			System.out.println("²»´æÔÚ");
		}else {
			User user1=  (User)list.get(0);
			System.out.println(user1.getUsername());
		}
		util.closeAll();
	}
}
