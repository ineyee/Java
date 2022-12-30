package _04线程安全问题;

public class Main {
	// 总票数
	private static int totalTicketCount = 10; 
	
	public static void main(String[] args) {
		// 假设有10个窗口在卖票 --> 即多个线程
	    for (int i = 0; i < 10; i++) {
	    	Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					saleTicket();
				}
			});
	    	thread.start();
	    }
	}
	
	private static void saleTicket() {
		// 卖一张票
		totalTicketCount--;
		System.out.println("剩余票数：" + totalTicketCount + Thread.currentThread());
	}
}
