package bai3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOObject<Entity> {
	protected List<Entity> list = new ArrayList<>();

	public void add(Entity entity) {
		this.list.add(entity);
	}

	public void remove(Entity entity) {
		this.list.remove(entity);
	}

	public abstract void update(Entity entity);

	// Serializable để có thể truyền được nhiều kiểu dữ liệu khác nhau
	public abstract Entity find(Serializable id);

	public List<Entity> getList() {
		return this.list;
	}

	public void store(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Entity>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void load(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
