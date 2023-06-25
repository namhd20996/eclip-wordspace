package model;

import java.io.Serializable;
import java.util.ArrayList;

public class QLBHModel implements Serializable{
	private ArrayList<MatHangModel> list;
	private String tenFile;

	public QLBHModel() {
		this.list = new ArrayList<>();
		this.tenFile = "";
	}

	public QLBHModel(ArrayList<MatHangModel> list, String tenFile) {
		this.list = list;
		this.tenFile = tenFile;
	}

	public ArrayList<MatHangModel> getList() {
		return list;
	}

	public void setList(ArrayList<MatHangModel> list) {
		this.list = list;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void insert(MatHangModel m) {
		this.list.add(m);
	}

	public void update(int i, MatHangModel m) {
		this.list.set(i, m);
	}

	public void delete(MatHangModel m) {
		this.list.remove(m);
	}

	public boolean kiemTraTonTai(MatHangModel b) {
		for (MatHangModel matHangModel : list) {
			if(matHangModel.getMaHang().equals(b.getMaHang())) {
				return true;
			}
		}
		return false;
	}
}
