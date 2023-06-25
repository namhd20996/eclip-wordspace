package bai3;

public class OddThread extends Thread{
	
	@Override
	public void run() {
		// synchronized đồng bộ hóa tài nguyên khí function chưa có thì nó sẽ chạy song song but khi thêm vào nó
		// sẽ chạy theo thứ tự được start
		for(int i=0; i<10; i++) {
			if(i%2!=0) {
				System.out.print(" "+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
			}
		}
	}
}
