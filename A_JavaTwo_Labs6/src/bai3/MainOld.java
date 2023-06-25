package bai3;

public class MainOld {
	public static void main(String[] args) {
		OddThread oddThread = new OddThread();
		EvenThread evenThread = new EvenThread();
		Thread t1 = new Thread(oddThread);
		Thread t2 = new Thread(evenThread);
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
