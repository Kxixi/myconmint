package com.servuce;

import java.sql.Connection;
import java.util.List;

import com.domain.User;
import com.util.DButil;

public class loginservice {
	public List login(User user) throws Exception {
		DButil dButil = new DButil();
		Connection connerction = dButil.getConnerction();
		List list = dButil.login(connerction, user);
		dButil.closeAll();
		return list;
	}
}
