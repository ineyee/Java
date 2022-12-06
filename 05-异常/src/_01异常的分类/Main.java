package _01异常的分类;

public class Main {
	public static void main(String[] args) {
		test7();
	}

	public static void test1() {
		/*
		 * 一、开发中的错误
		 * 在开发程序的过程中，会遇到各种各样的错误，错误主要分为三类：
		 * 
		 * 1、语法错误
		 * 比如我们把一个String类型赋值给int类型【int num = "123";】，Java语法就不允许你这么干，这就是语法错误
		 * 语法错误会导致编译错误，程序根本就运行不起来
		 * 
		 * 2、逻辑错误
		 * 比如我们本来想让【num += 1】的，但是不小心写成了【num -= 1】，从而导致结果出错了，这就是逻辑错误
		 * 逻辑错误编译是能通过的，只不过程序的结果不是我们的预期
		 * 
		 * 3、运行时错误————也叫做异常
		 * 比如数组越界了、空指针了等等，这些都是在程序运行过程中才产生的意外，这就是运行时错误，运行时错误也叫做异常
		 * 运行时错误编译是能通过的，但运行时会导致程序崩溃
		 */
	}
	
	public static void test2() {
		/*
		 * 二、异常
		 * 
		 * Object
		 * 	————Throwable
		 * 		————Exception
		 * 			————RuntimeException
		 * 			————...
		 * 		————Error
		 * 			————...
		 * 
		 * Java中所有的异常都最终继承自java.lang.Throwable，它虽然叫Throwable，但不是接口而是一个类。
		 * 也就是说程序在运行时有可能抛出Exception这种类型的异常，也有可能抛出Error这种类型的异常，总得来说它们都是异常，即Throwable可被抛出的。
		 * 
		 * 异常的分类：
		 * 1、检查型异常
		 * 所谓检查型异常是指如果开发者没有处理这类异常，编译器就会报错，开发者如果处理了，编译器就不会报错的异常。
		 * 上面除了RuntimeException和Error以外的异常都是检查型异常，这类异常程序员一般难以通过把代码写健壮的方式来避免，而是必须得通过那两种异常处理的方式来搞。
		 * 比如下面的test3例子
		 * 
		 * 2、非检查型异常
		 * 所谓非检查型异常是指如果开发者没有处理这类异常，编译器也不会报错的异常，那运行时这种异常一旦发生，程序将会崩溃，所以建议对非检查型异常做处理。
		 * 上面RuntimeException和Error都是非检查型异常，这类异常程序员只要写代码健壮一些是可以避免的，当然也可以通过异常处理的两种方式来处理。
		 * 比如下面的test4、test5、test6、test6例子都是一些经典的非检查型异常
		 */	
	}
	
	public static void test3() throws ClassNotFoundException {
		// 假设这个字符串是我们从服务器请求过来的
		String clsName = "Dog";
		
		/*
		 * 然后我们要拿服务器传给我们的字符串来反射出一个类
		 * 你会发现编译器立马报了一个“ClassNotFoundException”的异常，并且还提示我们可以用异常处理的两种方式来搞定这个异常，果然
		 * 我们任意采用一种方式处理，编译器就不抛这个异常了，这就是一个典型的检查型异常
		 * 
		 * 再来理解一下检查型异常：我们写的代码是没有问题的，只是因为这个字符串是服务器传递给我们的，我们程序员撑死了是对这个字符串
		 * 做做判空操作，而没法通过代码判断我们项目的类里是不是真得有服务器传过来的字符串对应的类，有当然好，那没有的话程序不就崩了嘛，
		 * 所以编译器就强制帮我们对这种异常做了检查，让我们必须处理掉这些场景
		 */
		Class cls = Class.forName(clsName);
//		try {
//			Class cls = Class.forName(clsName);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	public static void test4() {
		System.out.println(1);
		
		for (int i = 0; i < 200; i++) {
			/*
			 * 比如我们创建了这么一个数组，空间这么大，编译时是不会报错的，但运行时就报OOM了，因为堆内存溢出了
			 * 
			 * java.lang.OutOfMemoryError extends Error
			 * 
			 * 这种异常如果我们写代码注意一点，比如申请空间小一些，就可以避免，或者也可以通过异常处理的两种方式来处理一下
			 */
			long[] arr = new long[1000000000];
		}
		
		System.out.println(2);
	}
	
	public static void test5() {
		/*
		 * 比如我们这里写的一个无限递归，因为方法调用是会分配栈空间的，所以无限递归总有一天会把栈空间消耗尽，
		 * 但编译时也是不会报错的，但运行时就报StackOverFlow了，因为栈内存溢出了
		 * 
		 * java.lang.StackOverflowError extends Error
		 * 
		 * 这种异常如果我们写代码注意一点，比如写一个结束递归的条件，就可以避免，或者也可以通过异常处理的两种方式来处理一下
		 */
		test5();
	}
	
	public static void test6() {
		/*
		 * 比如我们这里让一个null去做运算或调用方法，编译时也是不会报错的，但运行时就报空指针异常了，因为Java里是不允许使用
		 * 空指针做运算或调用方法的
		 * 
		 * java.lang.NullPointerException extends RuntimeException
		 * 
		 * 这种异常如果我们写代码注意一点，比如做做判空，就可以避免，或者也可以通过异常处理的两种方式来处理一下
		 */
		Integer num = null;
		num += 1;
		System.out.println(num);
	}
	
	public static void test7() {
		/*
		 * 又比如数组越界
		 * 
		 * java.lang.ArrayIndexOutOfBoundsException extends RuntimeException
		 */
		int[] arr = { 1, 2, 3 };
		System.out.println(arr[3]);
 	}
}
