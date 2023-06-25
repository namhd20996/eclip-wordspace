package model;

import java.io.Serializable;
import java.util.Objects;

public class Staff implements Serializable{
	private String name;
	private double salary;

	public Staff() {

	}

	public Staff(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", salary=" + salary + "]";
	}

}
