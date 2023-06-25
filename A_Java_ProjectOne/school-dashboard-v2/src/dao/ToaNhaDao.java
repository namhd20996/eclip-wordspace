package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import model.ToaNhaModel;

public class ToaNhaDao implements DAOInterface<ToaNhaModel> {
	public static ToaNhaDao getInstance() {
		return new ToaNhaDao();
	}

	@Override
	public int insert(ToaNhaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into ToaNha ( maToaNha, tenToaNha, hinhAnh, soPhong, phuong_Xa, quan_Huyen, tinh_TP, ghiChu) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaToaNha());
			pst.setString(2, t.getTenToaNha());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(3, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(3, hinhAnh);
			}
			pst.setInt(4, t.getSoPhong());
			pst.setString(5, t.getPhuong());
			pst.setString(6, t.getQuan());
			pst.setString(7, t.getTinh());
			pst.setString(8, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ToaNhaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update ToaNha set tenToaNha=?, hinhAnh=?, soPhong=?, phuong_Xa=?, quan_Huyen=?, tinh_TP=?, ghiChu=? where maToaNha=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenToaNha());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(2, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(2, hinhAnh);
			}
			pst.setInt(3, t.getSoPhong());
			pst.setString(4, t.getPhuong());
			pst.setString(5, t.getQuan());
			pst.setString(6, t.getTinh());
			pst.setString(7, t.getGhiChu());
			pst.setString(8, t.getMaToaNha());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}

	@Override
	public int delete(ToaNhaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from ToaNha where maToaNha=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaToaNha());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}

	@Override
	public ToaNhaModel selectByID(ToaNhaModel t) {
		ToaNhaModel tm = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ToaNha where maToaNha=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaToaNha());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maToaNha = rs.getString("maToaNha");
				String tenToaNha = rs.getString("tenToaNha");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				int soPhong = rs.getInt("soPhong");
				String phuong = rs.getString("phuong_Xa");
				String quan = rs.getString("quan_Huyen");
				String tinh = rs.getString("tinh_TP");
				String ghiChu = rs.getString("ghiChu");
				tm = new ToaNhaModel(maToaNha, tenToaNha, hinhAnh, soPhong, phuong, quan, tinh, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tm;
	}

	@Override
	public ArrayList<ToaNhaModel> selectAll() {
		ArrayList<ToaNhaModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ToaNha";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maToaNha = rs.getString("maToaNha");
				String tenToaNha = rs.getString("tenToaNha");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				int soPhong = rs.getInt("soPhong");
				String phuong = rs.getString("phuong_Xa");
				String quan = rs.getString("quan_Huyen");
				String tinh = rs.getString("tinh_TP");
				String ghiChu = rs.getString("ghiChu");
				ToaNhaModel tm = new ToaNhaModel(maToaNha, tenToaNha, hinhAnh, soPhong, phuong, quan, tinh, ghiChu);
				list.add(tm);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ToaNhaModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ToaNhaModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<ToaNhaModel> list = ToaNhaDao.getInstance().selectAll();
		for (ToaNhaModel toaNhaModel : list) {
			System.out.println(toaNhaModel);
		}
	}

}
