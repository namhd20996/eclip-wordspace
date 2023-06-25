package model;

import java.util.ArrayList;

public class ListKidsZoneSchoolModel {
	private ArrayList<KidsZoneSchoolModel> listKidsZoneSchool;

	public ListKidsZoneSchoolModel() {
		this.listKidsZoneSchool = new ArrayList<KidsZoneSchoolModel>();
	}

	public ListKidsZoneSchoolModel(ArrayList<KidsZoneSchoolModel> listKidsZoneSchool) {
		this.listKidsZoneSchool = listKidsZoneSchool;
	}

	public ArrayList<KidsZoneSchoolModel> getListKidsZoneSchool() {
		return listKidsZoneSchool;
	}

	public void setListKidsZoneSchool(ArrayList<KidsZoneSchoolModel> listKidsZoneSchool) {
		this.listKidsZoneSchool = listKidsZoneSchool;
	}

	public void insert(KidsZoneSchoolModel kzs) {
		this.listKidsZoneSchool.add(kzs);
	}

	public void delete(KidsZoneSchoolModel kzs) {
		this.listKidsZoneSchool.remove(kzs);
	}

	public void update(int index, KidsZoneSchoolModel kzs) {
		this.listKidsZoneSchool.set(index, kzs);
	}
}
