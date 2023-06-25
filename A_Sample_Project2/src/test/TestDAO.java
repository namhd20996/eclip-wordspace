package test;

import java.util.ArrayList;

import java.util.List;

import dao.NguoiHocDAO;
import dao.ThongKeDAO;
import dao_helper.ThongKeDAOHelper;
import lib.XDate;
import lib.XDate;
import model.NguoiHocModel;

public class TestDAO {
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
		
//		NguoiHocDAO.getInstance().insert(nh1);
//		NguoiHocDAO.getInstance().insert(nh2);
//		NguoiHocDAO.getInstance().insert(nh3);
//		NguoiHocDAO.getInstance().insert(nh4);
//		NguoiHocDAO.getInstance().insert(nh5);
		
		// Cập nhật thông tin người học theo mã
		NguoiHocDAO.getInstance().update(nh1);
		NguoiHocDAO.getInstance().update(nh2);
		NguoiHocDAO.getInstance().update(nh3);
		NguoiHocDAO.getInstance().update(nh4);
		NguoiHocDAO.getInstance().update(nh5);
		
		// Xóa người học theo mã
		NguoiHocDAO.getInstance().delete(nh1);
		NguoiHocDAO.getInstance().delete(nh2);
		NguoiHocDAO.getInstance().delete(nh3);
		NguoiHocDAO.getInstance().delete(nh4);
		NguoiHocDAO.getInstance().delete(nh5);
		
		// Truy vấn người học theo mã
		NguoiHocModel nh_new = new NguoiHocModel();
		nh_new.setMaNguoiHoc("Ps01638");
		NguoiHocModel nh_model = NguoiHocDAO.getInstance().selectByID(nh_new);
		System.out.println(nh_model);
		
		// Truy vấn tất cả người học
		ArrayList<NguoiHocModel> list = NguoiHocDAO.getInstance().selectAll();
		for (NguoiHocModel nguoiHocModel : list) {
//			System.out.println(nguoiHocModel);
		}
		
		// Gọi thủ tục luu sp_ThongKeNguoiHoc()
		List<Object[]> sp_List = ThongKeDAO.getInstance().getLuongNguoiHoc();
		for (Object[] objects : sp_List) {
			System.out.println(objects[0]+" -- "+objects[1]+" -- "+objects[2]+" -- "+objects[3]);
		}
		
		List<Object[]> sp_List1 = ThongKeDAOHelper.getInstance().getDoanhThu(2018);
		for (Object[] objects : sp_List1) {
			System.out.println(objects[0]+" -- "+objects[1]+" -- "+objects[2]+" -- "+objects[3]);
		}
	}
}
