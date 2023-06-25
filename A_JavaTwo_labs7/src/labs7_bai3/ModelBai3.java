package labs7_bai3;

public class ModelBai3 {
	private double value1;
	private double value2;
	
	public ModelBai3() {
		
	}

	public ModelBai3(double value1, double value2, double result) {
		this.value1 = value1;
		this.value2 = value2;
	}

	public double getValue1() {
		return value1;
	}

	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double value2) {
		this.value2 = value2;
	}

	
	public double sqrtA() {
		double result = Math.sqrt(this.getValue1());
		return result;
	}
	
	public double exponential() {
		double result = Math.pow(this.getValue1(), this.getValue2());
		return result;
	}
	
	public double minNum() {
		double result = Math.min(this.getValue1(), this.getValue2());
		return result;
	}
	
	public double maxNum() {
		double result = Math.max(this.getValue1(), this.getValue2());
		return result;
	}
}
