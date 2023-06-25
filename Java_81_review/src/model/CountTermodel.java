package model;

public class CountTermodel {
	private int value;
	
	public CountTermodel() {
		this.value = 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void increement() {
		this.value++;
	}
	
	public void decrement() {
		this.value--;
	}
	
	public void reset() {
		this.value = 0;
	}
}	
