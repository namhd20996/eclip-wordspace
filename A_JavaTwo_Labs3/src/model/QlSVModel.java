package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QlSVModel {
	private ArrayList<SinhVienModel> dsSinhVien;
	
	public QlSVModel() {
		this.dsSinhVien  = new ArrayList<SinhVienModel>();
	}

	public QlSVModel(ArrayList<SinhVienModel> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<SinhVienModel> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<SinhVienModel> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public void insert(SinhVienModel sv) {
		this.dsSinhVien.add(sv);
	}
	
	public void delete(SinhVienModel sv) {
		this.dsSinhVien.remove(sv);
	}
	
	public void update(SinhVienModel sv) {
		this.dsSinhVien.remove(sv);
		this.dsSinhVien.add(sv);
	}

	public boolean kiemTraTonTai(SinhVienModel sv) {
		for (SinhVienModel sinhVienModel : dsSinhVien) {
			if(sinhVienModel.getHoVaTen().equals(sv.getHoVaTen())) {
				return true;
			}
		}
		return false;
	}
	
	public void sapXepSinhVienTheoTen() {
		Collections.sort(this.dsSinhVien, new Comparator<SinhVienModel>() {

			@Override
			public int compare(SinhVienModel o1, SinhVienModel o2) {
				return o1.getHoVaTen().compareTo(o2.getHoVaTen());
			}
		});
	}
	
	public void sapXepSinhVienTheoDiem() {
		Collections.sort(this.dsSinhVien, new Comparator<SinhVienModel>() {

			@Override
			public int compare(SinhVienModel o1, SinhVienModel o2) {
				if(o1.getDiem() > o2.getDiem()) {
					return 1;
				}else if(o1.getDiem() < o2.getDiem()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
	}
}
