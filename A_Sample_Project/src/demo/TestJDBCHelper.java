package demo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.NguoiHocDAO;
import dao.NhanVienDAO;

import dao_helper.NguoiHocDAOHelper;
import dao_helper.NhanVienDAOHelper;
import dao_helper.ThongKeDAOHelper;
import database.JDBCUtil;
import lib.XDate;
import lib.JDBCHelper;
import lib.XDate;
import model.NguoiHocModel;
import model.NhanVienModel;

public class TestJDBCHelper {
	public static void main(String[] args) {
		// Thêm mới 5 người học
		NguoiHocModel nh1 = new NguoiHocModel("Ps25979", "Hoàng Duy Nam", XDate.dateFormat("20/09/1996"), true,
				"0968997434", "namhdps25979@gmail.com", "487 Lê hồng phong", "Ps001", XDate.now());
		NguoiHocModel nh2 = new NguoiHocModel("Ps25980", "Hoàng Duy Nam", XDate.dateFormat("20/09/1996"), true,
				"0968997434", "namhdps25979@gmail.com", "487 Lê hồng phong", "Ps001", XDate.now());
		NguoiHocModel nh3 = new NguoiHocModel("Ps25981", "Hoàng Duy Nam", XDate.dateFormat("20/09/1996"), true,
				"0968997434", "namhdps25979@gmail.com", "487 Lê hồng phong", "Ps001", XDate.now());
		NguoiHocModel nh4 = new NguoiHocModel("Ps25982", "Hoàng Duy Nam", XDate.dateFormat("20/09/1996"), true,
				"0968997434", "namhdps25979@gmail.com", "487 Lê hồng phong", "Ps001", XDate.now());
		NguoiHocModel nh5 = new NguoiHocModel("Ps25983", "Hoàng Duy Nam", XDate.dateFormat("20/09/1996"), true,
				"0968997434", "namhdps25979@gmail.com", "487 Lê hồng phong", "Ps001", XDate.now());
//		NguoiHocDAOHelper.getInstance().insert(nh1);
//		NguoiHocDAOHelper.getInstance().insert(nh2);
//		NguoiHocDAOHelper.getInstance().insert(nh3);
//		NguoiHocDAOHelper.getInstance().insert(nh4);
//		NguoiHocDAOHelper.getInstance().insert(nh5);

		// Cập nhật thông tin người học theo mã
//		NguoiHocDAOHelper.getInstance().update(nh1);
//		NguoiHocDAOHelper.getInstance().update(nh2);
//		NguoiHocDAOHelper.getInstance().update(nh3);
//		NguoiHocDAOHelper.getInstance().update(nh4);
//		NguoiHocDAOHelper.getInstance().update(nh5);

//      Xóa người học theo mã
//		NguoiHocDAOHelper.getInstance().delete(nh5);
		
		// Truy vấn người học theo mã
		NguoiHocModel nh_model = NguoiHocDAOHelper.getInstance().selectByID(nh1);
		System.out.println(nh_model);
		
		// Truy vấn tất cả người học
		ArrayList<NguoiHocModel> list = NguoiHocDAOHelper.getInstance().selectAll();
		for (NguoiHocModel nguoiHocModel : list) {
			System.out.println(nguoiHocModel);
		}
		
		// Gọi thủ tục luu sp_ThongKeNguoiHoc()
		List<Object[]> list1 = ThongKeDAOHelper.getInstance().getLuongNguoiHoc();
		for (Object[] objects : list1) {
			System.out.println(objects[0]+" "+ objects[1]+" - "+objects[2]+"- "+objects[3]);
		}
	}
}
