package view;

import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

import lib.XImage;
import model.NguoiThuePhongModel;
import model.PhongModel;

import javax.swing.GroupLayout;
import javax.swing.ScrollPaneConstants;

import dao.NguoiThuePhongDao;
import dao.PhongDao;

import java.awt.Color;

public class ListPhongJPanel extends javax.swing.JPanel {
	private javax.swing.JScrollPane jScrollPane;
	private javax.swing.JPanel pnlProduct;

	public ListPhongJPanel() {
		setBackground(new Color(255, 255, 255));
		initComponents();
//		loadIMG();
	}

	public void loadIMG() {
		try {
			ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			int x = 0;
			int y = 0;
			for (int i = 0; i < list.size(); i++) {
				PhongDon obj = new PhongDon();
				obj.setMaPhong(list.get(i).getMaPhong());
				obj.setGia(list.get(i).getGiaPhong() + "");
				obj.setTrangThai(list.get(i).getTrangThai());
				obj.setTang(list.get(i).getTang() + "");
				if (list.get(i).getHinhAnh() != null) {
					Image icon = XImage.resize(XImage.createImageFromByteArray(list.get(i).getHinhAnh(), "jpg"), 128,
							77);
					ImageIcon resize = new ImageIcon(icon);
					obj.setImage(resize);
				} else {
					ImageIcon icon = new ImageIcon(
							getClass().getResource("/IMG_JavaIcon/VN-Vietnam-Flag-icon (2).png"));
					obj.setImage(icon);
				}
				NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByMaPhong(list.get(i).getMaPhong());
				if (nt != null) {
					
					obj.setMaNguoiThue(nt.getMaNguoiThue());
				} else {
					
					obj.setMaNguoiThue(null);
				}

				if(list.get(i).getTrangThai()!=null && nt !=null) {
					obj.setHoTen(nt.getHoTen());
				}else {
					obj.setHoTen(null);
				}
				gbc.gridx = x;
				gbc.gridy = y;
				pnlProduct.add(obj, gbc);
				x++;
				if (x == 4) {
					x = 0;
					y++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadIMG(int tang) {
		try {
			ArrayList<PhongModel> list = PhongDao.getInstance().selectByTang(new PhongModel(tang));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			int x = 0;
			int y = 0;
			for (int i = 0; i < list.size(); i++) {
				PhongDon obj = new PhongDon();
				obj.setMaPhong(list.get(i).getMaPhong());
				obj.setGia(list.get(i).getGiaPhong() + "");
				obj.setTrangThai(list.get(i).getTrangThai());
				obj.setTang(list.get(i).getTang() + "");
				if (list.get(i).getHinhAnh() != null) {
					Image icon = XImage.resize(XImage.createImageFromByteArray(list.get(i).getHinhAnh(), "jpg"), 128,
							77);
					ImageIcon resize = new ImageIcon(icon);
					obj.setImage(resize);
				} else {
					ImageIcon icon = new ImageIcon(
							getClass().getResource("/IMG_JavaIcon/VN-Vietnam-Flag-icon (2).png"));
					obj.setImage(icon);
				}
				NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByMaPhong(list.get(i).getMaPhong());
				if (nt != null) {
					obj.setHoTen(nt.getHoTen());
					obj.setMaNguoiThue(nt.getMaNguoiThue());
				} else {
					obj.setHoTen(null);
					obj.setMaNguoiThue(null);
				}
				gbc.gridx = x;
				gbc.gridy = y;
				pnlProduct.add(obj, gbc);
				x++;
				if (x == 4) {
					x = 0;
					y++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadIMG(String trangThai) {
		try {
			ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition(trangThai);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			int x = 0;
			int y = 0;
			for (int i = 0; i < list.size(); i++) {
				PhongDon obj = new PhongDon();
				obj.setMaPhong(list.get(i).getMaPhong());
				obj.setGia(list.get(i).getGiaPhong() + "");
				obj.setTrangThai(list.get(i).getTrangThai());
				obj.setTang(list.get(i).getTang() + "");
				if (list.get(i).getHinhAnh() != null) {
					Image icon = XImage.resize(XImage.createImageFromByteArray(list.get(i).getHinhAnh(), "jpg"), 128,
							77);
					ImageIcon resize = new ImageIcon(icon);
					obj.setImage(resize);
				} else {
					ImageIcon icon = new ImageIcon(
							getClass().getResource("/IMG_JavaIcon/VN-Vietnam-Flag-icon (2).png"));
					obj.setImage(icon);
				}
				NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByMaPhong(list.get(i).getMaPhong());
				if (nt != null) {
					obj.setHoTen(nt.getHoTen());
					obj.setMaNguoiThue(nt.getMaNguoiThue());
				} else {
					obj.setHoTen(null);
					obj.setMaNguoiThue(null);
				}
				gbc.gridx = x;
				gbc.gridy = y;
				pnlProduct.add(obj, gbc);
				x++;
				if (x == 4) {
					x = 0;
					y++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadListPhongFind(String result) {
		try {
			ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition(result);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			int x = 0;
			int y = 0;
			for (int i = 0; i < list.size(); i++) {
				PhongDon obj = new PhongDon();
				obj.setMaPhong(list.get(i).getMaPhong());
				obj.setGia(list.get(i).getGiaPhong() + "");
				obj.setTrangThai(list.get(i).getTrangThai());
				obj.setTang(list.get(i).getTang() + "");
				if (list.get(i).getHinhAnh() != null) {
					Image icon = XImage.resize(XImage.createImageFromByteArray(list.get(i).getHinhAnh(), "jpg"), 128,
							77);
					ImageIcon resize = new ImageIcon(icon);
					obj.setImage(resize);
				} else {
					ImageIcon icon = new ImageIcon(
							getClass().getResource("/IMG_JavaIcon/VN-Vietnam-Flag-icon (2).png"));
					obj.setImage(icon);
				}
				NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByMaPhong(list.get(i).getMaPhong());
				if (nt != null) {
					obj.setHoTen(nt.getHoTen());
					obj.setMaNguoiThue(nt.getMaNguoiThue());
				} else {
					obj.setHoTen(null);
					obj.setMaNguoiThue(null);
				}
				gbc.gridx = x;
				gbc.gridy = y;
				pnlProduct.add(obj, gbc);
				x++;
				if (x == 4) {
					x = 0;
					y++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadByMaToaNha(String maToaNha) {
		try {
			ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition(maToaNha);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			int x = 0;
			int y = 0;
			for (int i = 0; i < list.size(); i++) {
				PhongDon obj = new PhongDon();
				obj.setMaPhong(list.get(i).getMaPhong());
				obj.setGia(list.get(i).getGiaPhong() + "");
				obj.setTrangThai(list.get(i).getTrangThai());
				obj.setTang(list.get(i).getTang() + "");
				if (list.get(i).getHinhAnh() != null) {
					Image icon = XImage.resize(XImage.createImageFromByteArray(list.get(i).getHinhAnh(), "jpg"), 128,
							77);
					ImageIcon resize = new ImageIcon(icon);
					obj.setImage(resize);
				} else {
					ImageIcon icon = new ImageIcon(
							getClass().getResource("/IMG_JavaIcon/VN-Vietnam-Flag-icon (2).png"));
					obj.setImage(icon);
				}
				NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByMaPhong(list.get(i).getMaPhong());
				if (nt != null) {
					obj.setHoTen(nt.getHoTen());
					obj.setMaNguoiThue(nt.getMaNguoiThue());
				} else {
					obj.setHoTen(null);
					obj.setMaNguoiThue(null);
				}
				gbc.gridx = x;
				gbc.gridy = y;
				pnlProduct.add(obj, gbc);
				x++;
				if (x == 4) {
					x = 0;
					y++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane = new JScrollPane();
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlProduct = new javax.swing.JPanel();
		pnlProduct.setBackground(new Color(255, 255, 255));

		pnlProduct.setLayout(new java.awt.GridBagLayout());
		jScrollPane.setViewportView(pnlProduct);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jScrollPane,
				GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jScrollPane,
				GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE));
		this.setLayout(layout);
	}
}
