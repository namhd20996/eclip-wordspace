package bai3;

public class EvenThread extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			if(i%2==0) {
				System.out.print(" "+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
			}
		}
	}
}
