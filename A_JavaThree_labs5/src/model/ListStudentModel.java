package model;

import java.util.ArrayList;

public class ListStudentModel {
	private ArrayList<StudentModel> listStudents;
	
	public ListStudentModel() {
		this.listStudents = new ArrayList<StudentModel>();
	}

	public ListStudentModel(ArrayList<StudentModel> listStudents) {
		this.listStudents = listStudents;
	}

	public ArrayList<StudentModel> getListStudents() {
		return listStudents;
	}

	public void setListStudents(ArrayList<StudentModel> listStudents) {
		this.listStudents = listStudents;
	}
	
	public void insert(StudentModel st) {
		this.listStudents.add(st);
	}
	
	public void delete(StudentModel st) {
		this.listStudents.remove(st);
	}
	
	public void update(int index, StudentModel st) {
		this.listStudents.set(index, st);
	}

	public boolean kiemTraTonTai(String maSV) {
		for (StudentModel studentModel : listStudents) {
			if(maSV.equals(studentModel.getMaSV())) {
				return true;
			}
		}
		return false;
	}
	
}
