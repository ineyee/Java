package _02异常的处理;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
	public static void main(String[] args) {
		/*
		 * 程序产生了异常，我们一般称之为：抛出了异常。不管是检查型异常还是非检查型异常，都有两种处理方式：
		 * 1、try-catch捕获异常
		 * 2、throws把异常抛给上层方法
		 */
		test1();
		try {
			test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void test1() {
		/*
		 * 一、try-catch捕获异常：移动端开发的时候很少写try-catch，但是Java开发里大量使用，所以大胆地去用吧
		 * 
		 *	try {
		 *		把可能会抛出异常的代码写在try里
		 *	} catch (Exception e) {
		 *		然后在catch里看看你想对异常做些什么处理，一般我们都是做这三种处理：
		 *		 1、	System.out.println(e); // 打印异常描述
		 *		 2、System.out.println(e.getMessage()); // 打印异常名称 + 异常描述
		 *		 3、e.printStackTrace(); // 最常用：打印抛异常的堆栈信息来调试异常，这样我们就可以在控制台直接点到报错的位置
		 *	}
		 *
		 *	try {
		 *		把可能会抛出异常的代码写在try里
		 *	} catch (Exception e) {
		 *		然后在catch里看看你想对异常做些什么处理，一般我们都是做这三种处理：
		 *		 1、	System.out.println(e); // 打印异常描述
		 *		 2、System.out.println(e.getMessage()); // 打印异常名称 + 异常描述
		 *		 3、e.printStackTrace(); // 最常用：打印抛异常的堆栈信息来调试异常，这样我们就可以在控制台直接点到报错的位置
		 *	} finally {
		 *		程序不出现异常，即只走try，也会走到这里执行代码；程序出现异常，即走了catch，也会走到这里执行代码；
		 *		我们一般会在这里编写一些关闭、释放资源的代码（比如关闭文件）
		 *	}
		 */
		
		/*
		 * 如果没用try-catch的话：
		 * 1、数组没越界的话：正常打印1、2、3、4、5
		 * 2、数组越界的话：打印完1、2，程序就崩了，不会打印后面的3、4、5
		 * 
		 * 如果用了try-catch的话：
		 * 1、数组没越界的话：正常打印1、2、3、5
		 * 2、数组越界的话：打印完1、2，因为2的地方已经抛异常了，所以不会在走3的代码，而是直接走catch打印4，然后再打印5，程序就不会崩掉
		 */
		
//		System.out.println(1);
//		System.out.println(2);
//		int[] arr = { 1, 2, 3 };
////		System.out.println(arr[0]); // 没越界，不抛异常
//		System.out.println(arr[3]); // 越界，抛异常
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5);
		
		System.out.println(1);
		try {
			System.out.println(2);

			int[] arr = { 1, 2, 3 };
//			System.out.println(arr[0]); // 没越界，不抛异常
			System.out.println(arr[3]); // 越界，抛异常
			
			System.out.println(3);
		} catch (Exception e) {
			e.printStackTrace(); // 打印抛异常的堆栈信息来调试异常
			
			System.out.println(4);
		}
		System.out.println(5);
	}

	/*
	 * 二、throws把异常抛给上层方法
	 * 
	 * 用法就是在方法的参数列表和执行体中间throws一下会抛出的异常（这个地方最好写出具体的异常，而不要直接throws一个父类Exception，
	 * 这样别人再调用这个方法的时候才能更精准地针对不同的异常做不同的catch），这么做的话，test3就会把异常抛给调用它的方法test2，
	 * test2如果不处理还是会报错，所以test2也可以将异常抛给调用它的方法main，但是main如果不处理的话还是会报错，所以
	 * main方法也可以将异常继续往上抛，此时就是抛给JVM了，那么throws这一套就是如果异常都抛给JVM了，那运行时就会一旦
	 * 发生这个异常，程序就会崩溃，所以建议这其中任一环节你用try-catch处理一下这个异常，而非总是throws往上抛。
	 */
	public static void test2() throws FileNotFoundException {
		test3();
	}
	public static void test3() throws FileNotFoundException {
		String filePath = "C://text.txt";
		FileOutputStream fos = new FileOutputStream(filePath);
	}
}
