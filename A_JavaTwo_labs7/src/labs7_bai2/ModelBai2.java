package labs7_bai2;

public class ModelBai2 {
	private double value1;
	private double value2;
	private double result;
	
	public ModelBai2(double value1, double value2, double result) {
		this.value1 = value1;
		this.value2 = value2;
		this.result = result;
	}

	public ModelBai2() {
		
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

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public double sumValue() {
		this.result = this.getValue1() + this.getValue2();
		return result;
	}
}
