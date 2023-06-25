package model;

import java.util.ArrayList;

public class QLNVModel {
	private ArrayList<Staff> dsNhanVien;
	private String tenFile;

	public QLNVModel() {
		this.dsNhanVien = new ArrayList<Staff>();
		this.tenFile = "";
	}

	public QLNVModel(ArrayList<Staff> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<Staff> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<Staff> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		tenFile = tenFile;
	}

	public void insert(Staff st) {
		this.dsNhanVien.add(st);
	}

	public void delete(Staff st) {
		this.dsNhanVien.remove(st);
	}

	public void update(Staff st) {
		this.dsNhanVien.remove(st);
		this.dsNhanVien.add(st);
	}

	public boolean kiemTraTonTai(Staff st) {
		for (Staff staff : dsNhanVien) {
			if (staff.getName().equals(st.getName())) {
				return true;
			}
		}
		return false;
	}
}
