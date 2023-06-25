package model;

import java.util.Objects;

public class BookModel {
	private String id;
	private String title;
	private double price;

	public BookModel() {

	}

	public BookModel(String id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookModel [id=" + id + ", title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookModel other = (BookModel) obj;
		return Objects.equals(id, other.id) && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title);
	}

}
