package model;

import java.util.StringTokenizer;

public class ThucDonModel {
	private String luaChon_MonChinh;
	private String luaChon_MonPhu;
	private double toTal;

	public ThucDonModel() {
		this.luaChon_MonChinh = "";
		this.luaChon_MonPhu = "";
		this.toTal = 0;
	}

	public String getLuaChon_MonChinh() {
		return luaChon_MonChinh;
	}

	public void setLuaChon_MonChinh(String luaChon_MonChinh) {
		this.luaChon_MonChinh = luaChon_MonChinh;
	}

	public String getLuaChon_MonPhu() {
		return luaChon_MonPhu;
	}

	public void setLuaChon_MonPhu(String luaChon_MonPhu) {
		this.luaChon_MonPhu = luaChon_MonPhu;
	}

	public double getToTal() {
		return toTal;
	}

	public void setToTal(double toTal) {
		this.toTal = toTal;
	}

	public void tinhTongTien() {
		double toTal = 0;
		if (this.luaChon_MonChinh.equals("Cơm")) {
			toTal += 20000;
		} else if (this.luaChon_MonChinh.equals("Phở")) {
			toTal += 25000;
		} else if (this.luaChon_MonChinh.equals("Bún")) {
			toTal += 30000;
		}

		StringTokenizer stk = new StringTokenizer(this.luaChon_MonPhu, ";");
		while (stk.hasMoreElements()) {
			String monPhu = stk.nextToken();
			monPhu = monPhu.trim();
			if (monPhu.equals("Chè")) {
				toTal += 10000;
			} else if (monPhu.equals("Trà sữa")) {
				toTal += 15000;
			} else if (monPhu.equals("Coca")) {
				toTal += 20000;
			} else if (monPhu.equals("Pepsi")) {
				toTal += 25000;
			}
		}
		this.toTal = toTal;
	}

}
