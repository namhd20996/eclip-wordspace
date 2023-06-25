package test;

import java.sql.Connection;

import database.JDBCUtil;

public class TestOne {
	public static void main(String[] args) {
		Connection c = JDBCUtil.getConnection();
		System.out.println(c);
	}
}
