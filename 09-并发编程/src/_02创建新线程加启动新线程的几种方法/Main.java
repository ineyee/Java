package _02创建新线程加启动新线程的几种方法;

public class Main {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	// 方法1
	public static void test1() {
		// 创建新线程
		Thread thread = new Thread(new Runnable() {
			// 新线程里想做的事
			@Override
			public void run() {
				System.out.println(Thread.currentThread());
			}
		});
		thread.setName("新线程666");
		thread.setPriority(3);
		// 启动新线程，会自动分配新线程所需要的资源，然后调用run方法
		thread.start();
	}
	
	// 方法2
	public static void test2() {
		// 创建新线程
		Thread thread = new MyThread();
		thread.setName("新线程777");
		thread.setPriority(5);
		// 启动新线程
		thread.start();
	}
}
