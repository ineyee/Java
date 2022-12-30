package _05死锁;

public class Main {
	public static void main(String[] args) {
		/*
		 * 所谓死锁就是指两个或多个线程在互相等待对方线程解锁，从而导致大家都解不了锁，进而导致程序卡死在那儿了，开发中我们要避免死锁的发生
		 * 
		 * 比方说下面的例子，有两个线程thread1和thread2，程序跑起来后假设先执行了线程1的代码，thread1获取字符串对象"1"的内部锁，打印了
		 * "thread1 - 111"，然后thread1就去休眠了，此时开始执行线程2的代码了，thread2获取字符串对象"2"的内部锁，打印了
		 * "thread2 - 111"，然后thread2也去休眠了，此时thread1休眠完毕继续往下执行，发现又要获取字符串对象"2"的内部锁，结果发现字符串对象"2"的内部锁
		 * 已经被thread2获取了，于是无法往下执行，就卡在这等待，此时thread2休眠完毕继续往下执行，发现又要获取字符串对象"1"的内部锁，结果发现字符串对象"1"的内部锁
		 * 已经被thread1获取了，于是无法往下执行，就卡在这等待，这就是个死锁的例子，两个线程都在等待彼此的锁解掉、从而导致都无法解掉、程序卡死
		 */
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized ("1") {
					System.out.println("thread1 - 111");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized ("2") {
						System.out.println("thread1 - 222");
					}
				}				
			}
		});
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized ("2") {
					System.out.println("thread2 - 111");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized ("1") {
						System.out.println("thread2 - 222");
					}
				}				
			}
		});
		thread2.start();
	}
}
