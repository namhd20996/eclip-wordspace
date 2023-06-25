package model;

import java.util.ArrayList;

public class QLNVModel {
	private ArrayList<NhanVienModel> dsNhanVien;
	private String tenFile;
	

	public QLNVModel() {
		this.dsNhanVien = new ArrayList<NhanVienModel>();
		this.tenFile = "";
	}

	public QLNVModel(ArrayList<NhanVienModel> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
		
	}

	public ArrayList<NhanVienModel> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVienModel> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public void insert(NhanVienModel nv) {
		this.dsNhanVien.add(nv);
	}
	
	public void delete(NhanVienModel nv) {
		this.dsNhanVien.remove(nv);
	}
//	
//	public void update(NhanVienModel nv) {
//		this.dsNhanVien.remove(nv);
//		this.dsNhanVien.add(nv);
//	}
	
	public void update(int index, NhanVienModel nv) {
		this.dsNhanVien.set(index, nv);
	}

	public boolean kiemTraTonTai(NhanVienModel nv) {
		for (NhanVienModel nhanVienModel : dsNhanVien) {
			if(nv.getMaNhanVien().equals(nhanVienModel.getMaNhanVien())) {
				return true;
			}
		}
		return false;
	}
}
