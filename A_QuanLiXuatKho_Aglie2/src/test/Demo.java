package test;

import java.util.ArrayList;

import javax.swing.UIManager;

import dao.ChiTietPhieuXuatDao;
import dao.CuaHangDao;
import dao.HangHoaDao;
import dao.LoaiHangDao;
import dao.UserDao;
import model.ChiTietPhieuXuatModel;
import model.CuaHangModel;
import model.HangHoaModel;
import model.LoaiHangModel;
import model.UserModel;
import view.MainJframe;

public class Demo {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MainJframe();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
