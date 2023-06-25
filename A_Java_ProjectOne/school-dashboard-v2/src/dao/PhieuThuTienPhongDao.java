package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.PhieuThuTienPhongModel;

public class PhieuThuTienPhongDao implements DAOInterface<PhieuThuTienPhongModel> {
	public static PhieuThuTienPhongDao getInstance() {
		return new PhieuThuTienPhongDao();
	}

	@Override
	public int insert(PhieuThuTienPhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into PhieuThuTienPhong (maPhieuTTP, maPhong, maNhanVien, donGiaPhong, thangThu, soDienTruoc, soNuocTruoc, soDien, soNuoc, donGiaDien, donGiaNuoc, thanhTienDien, thanhTienNuoc, tienDichVu, thanhTien, ghiChu) values "
					+ "(?, ?, ?, ? ,?, ?, ?, ?, ? ,?, ?, ?, ?, ? ,?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuTTP());
			pst.setString(2, t.getMaPhong());
			pst.setString(3, t.getMaNhanVien());
			pst.setDouble(4, t.getDonGiaPhong());
			pst.setDate(5, t.getThangThu());
			pst.setDouble(6, t.getSoDienTruoc());
			pst.setDouble(7, t.getSoNuocTruoc());
			pst.setDouble(8, t.getSoDien());
			pst.setDouble(9, t.getSoNuoc());
			pst.setDouble(10, t.getDonGiaDien());
			pst.setDouble(11, t.getDonGiaNuoc());
			pst.setDouble(12, t.getThanhTienDien());
			pst.setDouble(13, t.getThanhTienNuoc());
			pst.setDouble(14, t.getTienDichVu());
			pst.setDouble(15, t.getThanhTien());
			pst.setString(16, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(PhieuThuTienPhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update PhieuThuTienPhong set maPhong=?, maNhanVien=?, donGiaPhong=?, thangThu=?, soDienTruoc=?, soNuocTruoc=?, soDien=?, soNuoc=?, donGiaDien=?, donGiaNuoc=?, thanhTienDien=?, thanhTienNuoc=?, tienDichVu=?, thanhTien=?, ghiChu=? where maPhieuTTP=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getMaNhanVien());
			pst.setDouble(3, t.getDonGiaPhong());
			pst.setDate(4, t.getThangThu());
			pst.setDouble(5, t.getSoDienTruoc());
			pst.setDouble(6, t.getSoNuocTruoc());
			pst.setDouble(7, t.getSoDien());
			pst.setDouble(8, t.getSoNuoc());
			pst.setDouble(9, t.getDonGiaDien());
			pst.setDouble(10, t.getDonGiaNuoc());
			pst.setDouble(11, t.getThanhTienDien());
			pst.setDouble(12, t.getThanhTienNuoc());
			pst.setDouble(13, t.getTienDichVu());
			pst.setDouble(14, t.getThanhTien());
			pst.setString(15, t.getGhiChu());
			pst.setString(16, t.getMaPhieuTTP());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(PhieuThuTienPhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from PhieuThuTienPhong where maPhieuTTP=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuTTP());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public PhieuThuTienPhongModel selectByID(PhieuThuTienPhongModel t) {
		PhieuThuTienPhongModel p = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from PhieuThuTienPhong where maPhieuTTP=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuTTP());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhieuTTP = rs.getString("maPhieuTTP");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				double donGiaPhong = rs.getDouble("donGiaPhong");
				Date thangThu = rs.getDate("thangThu");
				double soDienTruoc = rs.getDouble("soDienTruoc");
				double soNuocTruoc = rs.getDouble("soNuocTruoc");
				double soDien = rs.getDouble("soDien");
				double soNuoc = rs.getDouble("soNuoc");
				double donGiaDien = rs.getDouble("donGiaDien");
				double donGiaNuoc = rs.getDouble("donGiaNuoc");
				double thanhTienDien = rs.getDouble("thanhTienDien");
				double thanhTienNuoc = rs.getDouble("thanhTienNuoc");
				double tienDichVu = rs.getDouble("tienDichVu");
				double thanhTien = rs.getDouble("thanhTien");
				String ghiChu = rs.getString("ghiChu");
				p = new PhieuThuTienPhongModel(maPhieuTTP, maPhong, maNhanVien, donGiaPhong, thangThu, soDienTruoc,
						soNuocTruoc, soDien, soNuoc, donGiaDien, donGiaNuoc, thanhTienDien, thanhTienNuoc, tienDichVu,
						thanhTien, ghiChu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	@Override
	public ArrayList<PhieuThuTienPhongModel> selectAll() {
		ArrayList<PhieuThuTienPhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from PhieuThuTienPhong";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhieuTTP = rs.getString("maPhieuTTP");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				double donGiaPhong = rs.getDouble("donGiaPhong");
				Date thangThu = rs.getDate("thangThu");
				double soDienTruoc = rs.getDouble("soDienTruoc");
				double soNuocTruoc = rs.getDouble("soNuocTruoc");
				double soDien = rs.getDouble("soDien");
				double soNuoc = rs.getDouble("soNuoc");
				double donGiaDien = rs.getDouble("donGiaDien");
				double donGiaNuoc = rs.getDouble("donGiaNuoc");
				double thanhTienDien = rs.getDouble("thanhTienDien");
				double thanhTienNuoc = rs.getDouble("thanhTienNuoc");
				double tienDichVu = rs.getDouble("tienDichVu");
				double thanhTien = rs.getDouble("thanhTien");
				String ghiChu = rs.getString("ghiChu");
				PhieuThuTienPhongModel p = new PhieuThuTienPhongModel(maPhieuTTP, maPhong, maNhanVien, donGiaPhong,
						thangThu, soDienTruoc, soNuocTruoc, soDien, soNuoc, donGiaDien, donGiaNuoc, thanhTienDien,
						thanhTienNuoc, tienDichVu, thanhTien, ghiChu);
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<PhieuThuTienPhongModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhieuThuTienPhongModel> selectByCondition(String condition) {
		ArrayList<PhieuThuTienPhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from PhieuThuTienPhong where " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhieuTTP = rs.getString("maPhieuTTP");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				double donGiaPhong = rs.getDouble("donGiaPhong");
				Date thangThu = rs.getDate("thangThu");
				double soDienTruoc = rs.getDouble("soDienTruoc");
				double soNuocTruoc = rs.getDouble("soNuocTruoc");
				double soDien = rs.getDouble("soDien");
				double soNuoc = rs.getDouble("soNuoc");
				double donGiaDien = rs.getDouble("donGiaDien");
				double donGiaNuoc = rs.getDouble("donGiaNuoc");
				double thanhTienDien = rs.getDouble("thanhTienDien");
				double thanhTienNuoc = rs.getDouble("thanhTienNuoc");
				double tienDichVu = rs.getDouble("tienDichVu");
				double thanhTien = rs.getDouble("thanhTien");
				String ghiChu = rs.getString("ghiChu");
				PhieuThuTienPhongModel p = new PhieuThuTienPhongModel(maPhieuTTP, maPhong, maNhanVien, donGiaPhong,
						thangThu, soDienTruoc, soNuocTruoc, soDien, soNuoc, donGiaDien, donGiaNuoc, thanhTienDien,
						thanhTienNuoc, tienDichVu, thanhTien, ghiChu);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> selectByNam(int nam) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select sum(thanhTien) as 'thanhTien', MONTH(thangThu) as 'thangThu' from PhieuThuTienPhong\r\n"
					+ "where MONTH(thangThu) between 1 and 12 and YEAR(thangThu) ='" + nam + "'"
					+ " group by MONTH(thangThu)";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				double thanhTien = rs.getDouble("thanhTien");
				String thangThu = rs.getString("thangThu");
				Object[] vals = { thanhTien, thangThu };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> selectByThang(int thang, int nam) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select sum(thanhTien) as 'thanhTien', day(thangThu) as 'ngayThu' from PhieuThuTienPhong \r\n"
					+ "where day(thangThu) between 1 and 31 and MONTH(thangThu) ='" + thang + "' and YEAR(thangThu) ='"
					+ nam + "'" + "group by day(thangThu)";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				double thanhTien = rs.getDouble("thanhTien");
				String thangThu = rs.getString("ngayThu");
				Object[] vals = { thanhTien, thangThu };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> selectByKhoangNam(int from, int to) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select sum(thanhTien) as 'thanhTien', year(thangThu)  as 'nam' from PhieuThuTienPhong \r\n"
					+ "where year(thangThu) between " + from + " and " + to + " group by year(thangThu)";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				double thanhTien = rs.getDouble("thanhTien");
				String thangThu = rs.getString("nam");
				Object[] vals = { thanhTien, thangThu };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> selectDoanhThuAllYear() {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select sum(thanhTien) as 'thanhTien', year(thangThu)  as 'nam' from PhieuThuTienPhong \r\n"
					+ "group by year(thangThu)";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				double thanhTien = rs.getDouble("thanhTien");
				String nam = rs.getString("nam");
				Object[] vals = { thanhTien, nam };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> selectAllYear() {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select distinct year(thangThu) as 'nam' from PhieuThuTienPhong";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String nam = rs.getString("nam");
				Object[] vals = { nam };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> selectAllMonth() {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select distinct month(thangThu) as 'thang' from PhieuThuTienPhong";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String thang = rs.getString("thang");
				Object[] vals = { thang };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public void insertTExcel() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Danh sách");
			XSSFRow row = null;
			Cell cell = null;
			// Tạo 3 dòng trống và 1 một dòng để add các title dòng trong java dòng đầu = 0
			row = sheet.createRow(3);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("STT");

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("ID");

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Title");

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("Price");
			ArrayList<PhieuThuTienPhongModel> list = selectAll();

			for (int i = 0; i < list.size(); i++) {
				PhieuThuTienPhongModel p = list.get(i);
				System.out.println(p);
				row = sheet.createRow(4 + i);

				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue(i + 1);

				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(p.getMaPhieuTTP());

				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(p.getDonGiaDien());

				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(p.getMaNhanVien());

			}

			File f = new File("C:\\Users\\Pc\\Downloads\\New folder\\Danhsach.xlsx");
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ArrayList<PhieuThuTienPhongModel> list = PhieuThuTienPhongDao.getInstance().selectByCondition("maPhong='A1'");
		for (PhieuThuTienPhongModel phieuThuTienPhongModel : list) {
			System.out.println(phieuThuTienPhongModel);
		}
	}

}
