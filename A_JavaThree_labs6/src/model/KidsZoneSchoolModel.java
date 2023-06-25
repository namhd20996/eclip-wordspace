package model;

import java.sql.Date;
import java.util.Objects;

public class KidsZoneSchoolModel {
	private int regID;
	private String name;
	private String address;
	private String parentName;
	private String contactNo;
	private String standard;
	private double fees;

	public KidsZoneSchoolModel() {

	}

	public KidsZoneSchoolModel(int regID, String name, String address, String parentName, String contactNo,
			String standard, double fees) {
		this.regID = regID;
		this.name = name;
		this.address = address;
		this.parentName = parentName;
		this.contactNo = contactNo;
		this.standard = standard;
		this.fees = fees;
	}

	public KidsZoneSchoolModel(String name, String address, String parentName, String contactNo, String standard,
			double fees) {
		this.regID = regID;
		this.name = name;
		this.address = address;
		this.parentName = parentName;
		this.contactNo = contactNo;
		this.standard = standard;
		this.fees = fees;
	}

	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "KidsZoneSchoolModel [regID=" + regID + ", name=" + name + ", address=" + address + ", parentName="
				+ parentName + ", contactNo=" + contactNo + ", standard=" + standard + ", fees=" + fees + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contactNo, fees, name, parentName, regID, standard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KidsZoneSchoolModel other = (KidsZoneSchoolModel) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNo, other.contactNo)
				&& Double.doubleToLongBits(fees) == Double.doubleToLongBits(other.fees)
				&& Objects.equals(name, other.name) && Objects.equals(parentName, other.parentName)
				&& regID == other.regID && Objects.equals(standard, other.standard);
	}

}
