package labs1_bai2;

public class CalculatorModel {
	private double valueOne;
	private double valueTwo;
	private double result;
	
	public CalculatorModel() {
		
	}

	public CalculatorModel(double valueOne, double valueTwo, double result) {
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
		this.result = result;
	}

	public double getValueOne() {
		return valueOne;
	}

	public void setValueOne(double valueOne) {
		this.valueOne = valueOne;
	}

	public double getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(double valueTwo) {
		this.valueTwo = valueTwo;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public void addition () {
		this.result = this.getValueOne() + this.getValueTwo();
	}
	
	public void subtraction  () {
		this.result = this.getValueOne() - this.getValueTwo();
	}
	
	public void multiplication  () {
		this.result = this.getValueOne() * this.getValueTwo();
	}
	
	public void division  () {
		this.result = this.getValueOne() / this.getValueTwo();
	}
}
