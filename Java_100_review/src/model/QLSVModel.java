package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<SinhVienModel> dsSinhVien;
	private String luaChon;
	private String tenFile;

	public QLSVModel() {
		this.dsSinhVien = new ArrayList<SinhVienModel>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public QLSVModel(ArrayList<SinhVienModel> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<SinhVienModel> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<SinhVienModel> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public void insert(SinhVienModel sinhVien) {
		this.dsSinhVien.add(sinhVien);
	}

	public void delete(SinhVienModel sinhVien) {
		this.dsSinhVien.remove(sinhVien);
	}

//	public void update(SinhVienModel sinhVien) {
//		this.dsSinhVien.remove(sinhVien);
//		this.dsSinhVien.add(sinhVien);
//	}
	
	public void update(int index, SinhVienModel sinhVien) {
		this.dsSinhVien.set(index, sinhVien);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(SinhVienModel sv) {
		for (SinhVienModel sinhVienModel : dsSinhVien) {
			if (sinhVienModel.getMaSinhVien() == sv.getMaSinhVien()) {
				return true;
			}
		}
		return false;
	}
}
