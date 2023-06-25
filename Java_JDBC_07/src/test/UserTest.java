package test;

import java.util.ArrayList;

import dao.UserDao;
import dao.UserDao_Pr;
import model.User;

public class UserTest {
	public static void main(String[] args) {
//		User user = new User("x\" or 1=1; -- ", "", "");
//		User user_Find = UserDao.getInstane().selectByID(user);
//		System.out.println(user_Find);
		
		
		User user = new User("1", "10", "Nam");
		UserDao_Pr.getInstane().delete(user);
		
		ArrayList<User> ds = UserDao_Pr.getInstane().selectAll();
		for (User user2 : ds) {
			System.out.println(user2);
		}
		
		
		
	}
}	
