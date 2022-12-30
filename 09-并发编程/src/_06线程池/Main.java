package _06线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		/*
		 * 前面我们使用的都是普通线程，所谓普通线程就是指这个线程在执行完它的任务后生命周期就结束了，不能再执行别的任务，
		 * 这样在大型的应用程序中因为有很多任务要做，所以如果我们频繁地创建和销毁线程对象就会带来很大地内存管理开销。
		 * 
		 * 此时使用线程池就可以了，所谓线程池就像个池子一样，这个池子里有一堆线程，只不过线程池里的线程不是普通线程，而是
		 * 工作线程，工作线程在执行完一个任务后不会销毁，而是会一直存在在哪里等，来了任务就干活，没任务就等，于是使用线程池
		 * 就可以很大程度地减少线程创建和销毁所带来的开销
		 */
		
		// 创建一个线程池，这个线程池里有5条工作线程
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		// 直接调用线程池的execute方法往线程池里抛任务就可以了，系统会自动安排线程池里的线程来执行任务
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(2);
			}
		});
		// 当我们不再需要线程池执行任务的时候，需要关闭一下线程池，这样它里面的线程就都结束生命周期了
		threadPool.shutdown();
	}
}
