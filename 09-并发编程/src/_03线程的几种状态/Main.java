package _03线程的几种状态;

public class Main {
	public static void main(String[] args) {
		/*
		 * Java里线程一共有6种状态：
		 * 
		 * 1、NEW: 新建的线程，尚未启动
		 * 2、RUNNABLE: 可运行的线程或正在运行的线程，之所以说是“可运行的线程”，是因为如果是单核CPU，那么这个线程就很
		 * 有可能是在等待别的线程执行完毕，也就是说这条线程就是处于可运行但未运行的状态，但实际上如果是多核CPU，那么这个
		 * 状态就是指“正在运行的线程”
		 * 3、BLOCKED：正在阻塞的线程，正在等待监视器锁（内部锁）
		 * 4、WAITING：正在等待另一条线程
         * 5、TIMED_WAITING：定时等待状态
         * 6、TERMINATED：已经执行完毕的线程，终止状态
		 */
		Thread mainThread = Thread.currentThread();
		System.err.println(mainThread.getState()); // RUNNABLE
		
		Thread thread = new Thread();
		System.err.println(thread.getState()); // NEW
	}
}
