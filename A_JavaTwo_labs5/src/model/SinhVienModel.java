package model;

import java.io.Serializable;
import java.util.Objects;

public class SinhVienModel implements Serializable{
	private String name;
	private double marks;
	private String major;

	public SinhVienModel() {

	}

	public SinhVienModel(String name, double marks, String major) {
		this.name = name;
		this.marks = marks;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		if (this.marks < 3) {
			return "Kém";
		}
		if (this.marks < 5) {
			return "Yếu";
		}
		if (this.marks < 6.5) {
			return "Trung bình";
		}
		if (this.marks < 7.5) {
			return "Khá";
		}
		if (this.marks < 9) {
			return "Giỏi";
		}
		return "Xuất sắc";
	}

	public boolean isBonus() {
		return this.marks >= 7.5;
	}

	@Override
	public String toString() {
		return "SinhVienModel [name=" + name + ", marks=" + marks + ", major=" + major + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(major, marks, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVienModel other = (SinhVienModel) obj;
		return Objects.equals(major, other.major)
				&& Double.doubleToLongBits(marks) == Double.doubleToLongBits(other.marks)
				&& Objects.equals(name, other.name);
	}
	
}
