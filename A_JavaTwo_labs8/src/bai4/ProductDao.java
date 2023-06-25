package bai4;

import java.io.Serializable;

import bai3.DAOObject;
import bai3.Product;

public class ProductDao extends DAOObject<Product> {

	@Override
	public void update(Product entity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(entity.getName())) {
				list.set(i, entity);
			}
		}
	}

	@Override
	public Product find(Serializable id) {
		for (Product p : list) {
			if (p.getName().equals(id)) {
				return p;
			}
		}
		return null;
	}

}
