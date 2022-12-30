package _02创建新线程加启动新线程的几种方法;

/*
 * 自定义一个线程，重写run方法，把想在新线程做的事情写在run方法里
 */
public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	}
}
