package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KidsZoneSchoolModel;

public class KidsZoneSchoolDAO implements DAOInterface<KidsZoneSchoolModel> {
	
	public static KidsZoneSchoolDAO getInstance() {
		return new KidsZoneSchoolDAO();
	}

	@Override
	public int insert(KidsZoneSchoolModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into kidszoneschool (name_User, address, parentName, phone, standard, fees) values\n"
					+ "(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getAddress());
			pst.setString(3, t.getParentName());
			pst.setString(4, t.getContactNo());
			pst.setString(5, t.getStandard());
			pst.setDouble(6, t.getFees());
			result = pst.executeUpdate();
			System.out.println("Đã nhập thành công "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(KidsZoneSchoolModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update kidszoneschool\n"
					+ "set name_User =?, address = ?, parentName =?, phone=?, standard=?, fees=?\n"
					+ "where regID = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getAddress());
			pst.setString(3, t.getParentName());
			pst.setString(4, t.getContactNo());
			pst.setString(5, t.getStandard());
			pst.setDouble(6, t.getFees());
			pst.setInt(7, t.getRegID());
			result = pst.executeUpdate();
			System.out.println("Đã update "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(KidsZoneSchoolModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from kidszoneschool where regID = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getRegID());
			result = pst.executeUpdate();
			System.out.println("Đã xóa "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<KidsZoneSchoolModel> selectAll() {
		ArrayList<KidsZoneSchoolModel> list = new ArrayList<KidsZoneSchoolModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from kidszoneschool";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int regID = rs.getInt("regID");
				String name = rs.getString("name_User");
				String address = rs.getString("address");
				String parentName = rs.getString("parentName");
				String contactNo = rs.getString("phone");
				String standard = rs.getString("standard");
				double fees = rs.getDouble("fees");
				KidsZoneSchoolModel kzs = new KidsZoneSchoolModel(regID, name, address, parentName, contactNo, standard, fees);
				list.add(kzs);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public KidsZoneSchoolModel selectByID(KidsZoneSchoolModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KidsZoneSchoolModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
