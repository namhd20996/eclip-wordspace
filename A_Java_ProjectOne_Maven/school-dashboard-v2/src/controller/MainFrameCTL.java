package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lib.Auth;
import lib.MsgBox;
import test.MainFrame;
import util.EventMenuSelected;
import view.Form_ChuyenPhong;
import view.Form_DichVu;
import view.Form_DoanhThu;
import view.Form_Home;
import view.Form_NhanVien;
import view.Form_PhieuChi;
import view.Form_PhieuThuTienPhong;
import view.Form_Phong;
import view.Form_TaiSan;
import view.Form_ToaNha;
import view.NguoiThuePhongJpanel;

public class MainFrameCTL implements EventMenuSelected, ActionListener {
	private MainFrame mainFrame;

	public MainFrameCTL(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void menuSelected(int menuIndex, int subMenuIndex) {
		System.out.println("Menu index: " + menuIndex + " Sub menu " + subMenuIndex);
		if (menuIndex == 0) {
			if (subMenuIndex == -1) {
				this.mainFrame.mainForm.showForm(new Form_Home());
			}
		}

		if (menuIndex == 0) {
			if (subMenuIndex == 0) {
				if (Auth.user.isVaiTro()) {
					this.mainFrame.mainForm.showForm(new Form_ToaNha());
				} else {
					MsgBox.showMessageDialog(mainFrame, "Bạn Không có quyền xem!", "Notification");
				}
			}
		}

		if (menuIndex == 1) {
			if (subMenuIndex == 0) {
				this.mainFrame.mainForm.showForm(new Form_Phong());
			}
			if (subMenuIndex == 1) {
				this.mainFrame.mainForm.showForm(new Form_ChuyenPhong());
			}
		}

		if (menuIndex == 2) {
			if (subMenuIndex == 0) {
				this.mainFrame.mainForm.showForm(new Form_DichVu());
			}
		}

		if (menuIndex == 3) {
			if (subMenuIndex == 0) {
				this.mainFrame.mainForm.showForm(new Form_PhieuThuTienPhong());
			}
			if (subMenuIndex == 1) {
				this.mainFrame.mainForm.showForm(new Form_PhieuChi());
			}

		}

		if (menuIndex == 4) {
			if (subMenuIndex == 0) {
				this.mainFrame.mainForm.showForm(new NguoiThuePhongJpanel());
			}
		}

		if (menuIndex == 6) {
			if (subMenuIndex == 0) {
				if (Auth.user.isVaiTro()) {
					this.mainFrame.mainForm.showForm(new Form_DoanhThu());
				} else {
					MsgBox.showMessageDialog(mainFrame, "Bạn Không có quyền xem!", "Notification");
				}
			}
		}

		if (menuIndex == 7) {
			if (subMenuIndex == 0) {
				if (Auth.user.isVaiTro()) {
					this.mainFrame.mainForm.showForm(new Form_NhanVien());
				} else {
					MsgBox.showMessageDialog(mainFrame, "Bạn Không có quyền xem!", "Notification");
				}
			}
		}

		if (menuIndex == 8) {
			if (subMenuIndex == 0) {
				this.mainFrame.mainForm.showForm(new Form_TaiSan());
			}
		}

		if (menuIndex == 9) {
			if (subMenuIndex == -1) {
				this.mainFrame.logOut();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Header")) {
			this.mainFrame.actionFormSize();
		}
	}

}
