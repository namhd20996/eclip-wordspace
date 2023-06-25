package bai1;

public class MainClass {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		Thread t2 = new Thread(myThread);
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}
