package dao;

import java.util.ArrayList;

import model.Sach;

public class SachDao implements DAOInterface<Sach>{
	
	public static SachDao getInstane() {
		return new SachDao();
	}
	
	@Override
	public int insert(Sach t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Sach t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Sach t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sach selectByID(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
