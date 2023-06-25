package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import database.JDBCUtil;
import model.LoaiHangModel;

public class LoaiHangDao implements DAOInterface<LoaiHangModel> {

	public static LoaiHangDao getInstance() {
		return new LoaiHangDao();
	}

	@Override
	public int insert(LoaiHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into loaihang(maLoaiHang, tenLoaiHang, ghiChu, hinhAnh) values (?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaLoaiHang());
			pst.setString(2, t.getTenLoaiHang());
			pst.setString(3, t.getGhiChu());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(4, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(4, hinhAnh);
			}
			result = pst.executeUpdate();
			System.out.println("Đã thực thi "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(LoaiHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update loaihang " + "set tenLoaiHang=?, ghiChu=?, hinhAnh=? " + "where maLoaiHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenLoaiHang());
			pst.setString(2, t.getGhiChu());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(3, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(3, hinhAnh);
			}
			pst.setString(4, t.getMaLoaiHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(LoaiHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from loaihang where maLoaiHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaLoaiHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public LoaiHangModel selectByID(LoaiHangModel t) {
		LoaiHangModel lh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from loaihang where maLoaiHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaLoaiHang());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maLoaiHang = rs.getString("maLoaiHang");
				String tenLoaiHang = rs.getString("tenLoaiHang");
				String ghiChu = rs.getString("ghiChu");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				lh = new LoaiHangModel(maLoaiHang, tenLoaiHang, ghiChu, hinhAnh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lh;
	}

	@Override
	public ArrayList<LoaiHangModel> selectAll() {
		ArrayList<LoaiHangModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from loaihang";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maLoaiHang = rs.getString("maLoaiHang");
				String tenLoaiHang = rs.getString("tenLoaiHang");
				String ghiChu = rs.getString("ghiChu");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				LoaiHangModel lh = new LoaiHangModel(maLoaiHang, tenLoaiHang, ghiChu, hinhAnh);
				list.add(lh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<LoaiHangModel> selectByCondition(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
