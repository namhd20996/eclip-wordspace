package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {

	public int insert(T t);

	public int update(T t);

	public int delete(T t);

	public T selectByID(T t);

	public ArrayList<T> selectAll();
	
	public ArrayList<T> selectBySQL(String sql, Object t);

	public ArrayList<T> selectByCondition(String condition);
	
	
}
