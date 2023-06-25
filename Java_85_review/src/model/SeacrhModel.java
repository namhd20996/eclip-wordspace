package model;

public class SeacrhModel {
	private String tuKhoa;
	private String vanBan;
	private String ketQua;
	
	public SeacrhModel() {
		this.tuKhoa = "";
		this.vanBan = "";
		this.ketQua = "";
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getVanBan() {
		return vanBan;
	}

	public void setVanBan(String vanBan) {
		this.vanBan = vanBan;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	
	public void search() {
		int count = 0;
		int viTri = 0;
		while(true) {
			int i = this.vanBan.indexOf(this.tuKhoa, viTri);
			if(i==-1) {
				break;
			}else {
				count++;
				viTri = i + 1;
			}
		}
		this.ketQua = "Kết Quả: " + count + this.tuKhoa;
		System.out.println(ketQua);
	}
}
