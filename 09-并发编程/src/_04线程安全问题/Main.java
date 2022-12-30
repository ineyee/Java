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
	
	/*
	 * 线程同步方案一：synchronized语句，类似于OC里的@synchronized，小括号里可以是任意一个Java对象
	 * 
	 * synchronized的原理：每一个Java对象都有一个与之相关的内部锁或者叫监视器锁，那么当第一条线程
	 * 执行到synchronized的时候就会获取到这个Java对象的内部锁，然后把代码锁住，此时其它线程就无法
	 * 获取这个Java对象的内部锁了，除非代码执行完锁解开，然后阻塞的那些线程就会看运气谁先拿到锁谁就
	 * 先被执行
	 */
	// 任意创建一个Java对象作为锁对象，当然如果saleTicket是个实例方法的话，小括号里直接放this就行了
//	private static Object lock = new Object();
//	private static void saleTicket() {
//		synchronized (lock) {
//			// 卖一张票
//			totalTicketCount--;
//			System.out.println("剩余票数：" + totalTicketCount + Thread.currentThread());
//		}
//	}
	
	/*
	 * 线程同步方案二：synchronized方法，直接在方法的返回值前面加一个synchronized关键字就可以了
	 * 
	 * synchronized的本质：
	 * 1、如果方法是个实例方法，那么synchronized方法完全等价于synchronized语句那种写法小括号里写了个(this)
	 * 2、如果方法是个静态方法，那么synchronized方法完全等价于synchronized语句那种写法小括号里写了个(当前类的类对象，例如Main.class)
	 *
	 * synchronized方法明显没有synchronized语句灵活，因为synchronized方法会把整个方法里的代码都锁住，
	 * 而synchronized语句则可以更精准地锁住我们需要被锁住的代码
	 */
	private static synchronized void saleTicket() {
		// 卖一张票
		totalTicketCount--;
		System.out.println("剩余票数：" + totalTicketCount + Thread.currentThread());
	}
}
