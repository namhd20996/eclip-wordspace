package labs7_bai1;

public class PolyStudent {
	private String fullName;
	private Career career;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public void print() {
		System.out.println("Fullname: " + this.fullName);
		switch (this.career) {
		case UDPM:
			System.out.println(">Career: Ứng dụng phần mềm");
			break;
		case TKTW:
			System.out.println(">Career: Thiết kế trang web");
			break;
		case LTDĐ:
			System.out.println(">Career: Lập trình di động");
			break;
		case TKĐH:
			System.out.println(">Career: Thiết kế đồ họa");
			break;
		}
	}
}
