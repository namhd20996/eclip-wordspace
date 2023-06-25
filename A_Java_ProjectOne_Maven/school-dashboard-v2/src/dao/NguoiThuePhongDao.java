package dao;

import java.sql.Blob;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import lib.XDate;
import model.NguoiThuePhongModel;

public class NguoiThuePhongDao implements DAOInterface<NguoiThuePhongModel> {

	public static NguoiThuePhongDao getInstance() {
		return new NguoiThuePhongDao();
	}

	@Override
	public int insert(NguoiThuePhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into NguoiThuePhong (maNguoiThue,soCCCDNT, maPhong, maNhanVien, hinhNT, matTruocCC, matSauCC, hoTen, ngaySinh, noiSinh, gioiTinh, phuong_Xa, quan_Huyen, tinh_TP, noiDangKyHK, soDienThoai, email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc, ghiChu) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			pst.setString(2, t.getSoCCCDNT());
			pst.setString(3, t.getMaPhong());
			pst.setString(4, t.getMaNhanVien());
			if (t.getHinhNT() != null) {
				Blob hinhNT = new SerialBlob(t.getHinhNT());
				pst.setBlob(5, hinhNT);
			} else {
				Blob hinhNT = null;
				pst.setBlob(5, hinhNT);
			}
			if (t.getMatTruocCC() != null) {
				Blob hinhMT = new SerialBlob(t.getMatTruocCC());
				pst.setBlob(6, hinhMT);
			} else {
				Blob hinhMT = null;
				pst.setBlob(6, hinhMT);
			}
			if (t.getMatSauCC() != null) {
				Blob hinhMS = new SerialBlob(t.getMatSauCC());
				pst.setBlob(7, hinhMS);
			} else {
				Blob hinhMS = null;
				pst.setBlob(7, hinhMS);
			}
			pst.setString(8, t.getHoTen());
			pst.setDate(9, t.getNgaySinh());
			pst.setString(10, t.getNoiSinh());
			pst.setString(11, t.getGioiTinh());
			pst.setString(12, t.getPhuong_Xa());
			pst.setString(13, t.getQuan_Huyen());
			pst.setString(14, t.getTinh_TP());
			pst.setString(15, t.getNoiDangKyHK());
			pst.setString(16, t.getSoDienThoai());
			pst.setString(17, t.getEmail());
			pst.setDate(18, t.getNgayCapCC());
			pst.setString(19, t.getNoiCap());
			pst.setDate(20, t.getNgayBatDauThue());
			pst.setDate(21, t.getNgayHetHanThue());
			pst.setDouble(22, t.getTienCoc());
			pst.setString(23, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(NguoiThuePhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NguoiThuePhong "
					+ "set soCCCDNT=?, maPhong=?, maNhanVien=?, hinhNT=?, matTruocCC=?, matSauCC=?, hoTen=?, ngaySinh=?, noiSinh=?, gioiTinh=?, phuong_Xa=?, quan_Huyen=?, tinh_TP=?, noiDangKyHK=?, soDienThoai=?, email=?, ngayCapCC=?, noiCap=?, ngayBatDauThue=?, ngayHetHanThue=?, tienCoc=?, ghiChu=? "
					+ "where maNguoiThue=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getSoCCCDNT());
			pst.setString(2, t.getMaPhong());
			pst.setString(3, t.getMaNhanVien());
			if (t.getHinhNT() != null) {
				Blob hinhNT = new SerialBlob(t.getHinhNT());
				pst.setBlob(4, hinhNT);
			} else {
				Blob hinhNT = null;
				pst.setBlob(4, hinhNT);
			}
			if (t.getMatTruocCC() != null) {
				Blob hinhMT = new SerialBlob(t.getMatTruocCC());
				pst.setBlob(5, hinhMT);
			} else {
				Blob hinhMT = null;
				pst.setBlob(5, hinhMT);
			}
			if (t.getMatSauCC() != null) {
				Blob hinhMS = new SerialBlob(t.getMatSauCC());
				pst.setBlob(6, hinhMS);
			} else {
				Blob hinhMS = null;
				pst.setBlob(6, hinhMS);
			}
			pst.setString(7, t.getHoTen());
			pst.setDate(8, t.getNgaySinh());
			pst.setString(9, t.getNoiSinh());
			pst.setString(10, t.getGioiTinh());
			pst.setString(11, t.getPhuong_Xa());
			pst.setString(12, t.getQuan_Huyen());
			pst.setString(13, t.getTinh_TP());
			pst.setString(14, t.getNoiDangKyHK());
			pst.setString(15, t.getSoDienThoai());
			pst.setString(16, t.getEmail());
			pst.setDate(17, t.getNgayCapCC());
			pst.setString(18, t.getNoiCap());
			pst.setDate(19, t.getNgayBatDauThue());
			pst.setDate(20, t.getNgayHetHanThue());
			pst.setDouble(21, t.getTienCoc());
			pst.setString(22, t.getGhiChu());
			pst.setString(23, t.getMaNguoiThue());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int updateTraPhong(NguoiThuePhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NguoiThuePhong " + "set  maPhong=?, maNhanVien=? " + "where maNguoiThue=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getMaNhanVien());
			pst.setString(3, t.getMaNguoiThue());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(NguoiThuePhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from NguoiThuePhong where maNguoiThue=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NguoiThuePhongModel selectByID(NguoiThuePhongModel t) {
		NguoiThuePhongModel nt = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong where maNguoiThue=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT, matTruocCC, matSauCC,
						hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP, noiDangKyHK, soDienThoai,
						email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nt;
	}
	
	public NguoiThuePhongModel findOneByMaPhongAndMaNguoiThue(NguoiThuePhongModel t) {
		NguoiThuePhongModel nt = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong where maNguoiThue=? and maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			pst.setString(2, t.getMaPhong());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT, matTruocCC, matSauCC,
						hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP, noiDangKyHK, soDienThoai,
						email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nt;
	}
	
	
	public NguoiThuePhongModel findOneByMaPhongNullAndMaNguoiThue(NguoiThuePhongModel t) {
		NguoiThuePhongModel nt = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong where maNguoiThue=? and maPhong is null";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT, matTruocCC, matSauCC,
						hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP, noiDangKyHK, soDienThoai,
						email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nt;
	}

	public NguoiThuePhongModel selectByMaPhong(String t) {
		NguoiThuePhongModel nt = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT, matTruocCC, matSauCC,
						hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP, noiDangKyHK, soDienThoai,
						email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nt;
	}

	@Override
	public ArrayList<NguoiThuePhongModel> selectAll() {
		ArrayList<NguoiThuePhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				NguoiThuePhongModel nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT,
						matTruocCC, matSauCC, hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP,
						noiDangKyHK, soDienThoai, email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc,
						ghiChu);
				list.add(nt);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<NguoiThuePhongModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NguoiThuePhongModel> selectByCondition(String condition) {
		ArrayList<NguoiThuePhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong where " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				NguoiThuePhongModel nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT,
						matTruocCC, matSauCC, hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP,
						noiDangKyHK, soDienThoai, email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc,
						ghiChu);
				list.add(nt);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<NguoiThuePhongModel> selectByName(String condition) {
		ArrayList<NguoiThuePhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiThuePhong where hoTen like ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + condition + "%");
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String soCCCDNT = rs.getString("soCCCDNT");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				Blob hinh = rs.getBlob("hinhNT");
				byte[] hinhNT = null;
				if (hinh != null) {
					hinhNT = hinh.getBytes(1, (int) hinh.length());
				}
				Blob hinhMT = rs.getBlob("matTruocCC");
				byte[] matTruocCC = null;
				if (hinhMT != null) {
					matTruocCC = hinhMT.getBytes(1, (int) hinhMT.length());
				}
				Blob hinhMS = rs.getBlob("matSauCC");
				byte[] matSauCC = null;
				if (hinhMS != null) {
					matSauCC = hinhMS.getBytes(1, (int) hinhMS.length());
				}
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String noiSinh = rs.getString("noiSinh");
				String gioiTinh = rs.getString("gioiTinh");
				String phuong_Xa = rs.getString("phuong_Xa");
				String quan_Huyen = rs.getString("quan_Huyen");
				String tinh_TP = rs.getString("tinh_TP");
				String noiDangKyHK = rs.getString("noiDangKyHK");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				Date ngayCapCC = rs.getDate("ngayCapCC");
				String noiCap = rs.getString("noiCap");
				Date ngayBatDauThue = rs.getDate("ngayBatDauThue");
				Date ngayHetHanThue = rs.getDate("ngayHetHanThue");
				double tienCoc = rs.getDouble("tienCoc");
				String ghiChu = rs.getString("ghiChu");
				NguoiThuePhongModel nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT,
						matTruocCC, matSauCC, hoTen, ngaySinh, gioiTinh, noiSinh, phuong_Xa, quan_Huyen, tinh_TP,
						noiDangKyHK, soDienThoai, email, ngayCapCC, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc,
						ghiChu);
				list.add(nt);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<NguoiThuePhongModel> list = NguoiThuePhongDao.getInstance().selectByName("H");
		System.out.println(list.size());
	}
}
