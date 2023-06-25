package model;

import java.util.ArrayList;

public class QLUser {
	private ArrayList<User> dsUser;

	public QLUser() {
		this.dsUser = new ArrayList<User>();
	}

	public QLUser(ArrayList<User> dsUser) {
		this.dsUser = dsUser;
	}

	public ArrayList<User> getDsUser() {
		return dsUser;
	}

	public void setDsUser(ArrayList<User> dsUser) {
		this.dsUser = dsUser;
	}

	public void insert(User user) {
		this.dsUser.add(user);
	}

	public void delete(User user) {
		this.dsUser.remove(user);
	}

	public void update(User user) {
		this.dsUser.remove(user);
		this.dsUser.add(user);
	}

	public boolean kiemTraTonTai(User u) {
		for (User user : dsUser) {
			if (user.getUserName().equals(u.getUserName())) {
				return true;
			}
		}
		return false;
	}
}
