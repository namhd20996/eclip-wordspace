package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.JDBCUtil;

public class JDBCHelper {
	public static PreparedStatement getStmt(String sql, Object... args) {
		PreparedStatement pst = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			if (sql.trim().startsWith("{")) {
				pst = connection.prepareCall(sql);
			} else {
				pst = connection.prepareStatement(sql);
			}
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pst;
	}

	public static int update(String sql, Object... args) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = getStmt(sql, args);
			try {
				result = pst.executeUpdate();
			} finally {
				JDBCUtil.closeConnection(connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet query(String sql, Object... args) {
		ResultSet rs = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement pst = getStmt(sql, args);
			rs = pst.executeQuery();
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static Object value(String sql, Object... args) {
		try {
			Connection connection = JDBCUtil.getConnection();
			ResultSet rs;
			rs = query(sql, args);
			if (rs.next()) {
				return rs.getObject(0);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
