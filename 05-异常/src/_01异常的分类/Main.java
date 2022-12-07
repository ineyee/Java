package _01异常的分类;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
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
		 * 比如OOM了、StackOverFlow了、数组越界了、空指针了等等，这些都是在程序运行过程中才产生的意外，这就是运行时错误，运行时错误也叫做异常
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
		 * 所谓检查型异常是指如果开发者没有处理这类异常，编译器就会报错，开发者必须通过try-catch或者throws处理一下的异常。
		 * 检查型异常，就算你写的代码再规范再健壮也无法100%避免，下面我们会举一些经典的检查型异常：test10、test11。
		 * 上面除了RuntimeException和Error以外的异常都是检查型异常。
		 * 
		 * 2、非检查型异常
		 * 所谓非检查型异常是指即便开发者没有处理这里异常，编译器也不会报错的异常，但是这种异常一旦在程序运行的时候发生，程序就会崩溃，所以建议通过try-catch或者throws处理一下。
		 * 非检查型异常，我们在编码的时候写得规范些、健壮些就可以100%地避免，下面我们会举一些经典的非检查型异常：test20、test21、test22、test23。
		 * 上面RuntimeException和Error都是非检查型异常。
		 */	
	}
	
	void test10() throws FileNotFoundException {
		// 假设这个字符串是别人传递给我们的
		String filePath = "C://text.txt";
		
		/*
		 * FileOutputStream，文件输出流类，我们拿到这个类的对象之后，就可以往filePath里写数据
		 * 
		 * 这样写编译时就报错了，抛出一个异常是“FileNotFoundException”——文件找不到异常，这个异常就是个检查型异常
		 * 
		 * 那这个异常为什么会抛出呢？是因为我们根本无法确定别人会把什么字符串传递给我们，假设它传了个乱七八糟的字符串，
		 * 那就肯定找不到这个文件啊，你可能会想那我们可以先判断一下文件目录里有没有“filePath”这个文件啊，有的话再执
		 * 行这个操作，没有的话就创建一下这个文件再执行这个操作不就算是通过代码规范和代码健壮性来避免掉这个异常了嘛。
		 * 想法是好的，但是很可惜，编译器是聪明的，它知道我们根本没有办法获取到全部的文件，比如有很多文件是隐藏的，所以
		 * 你那个【判断有没有这个文件的操作】本身就不是绝对严谨，所以它还是抛出了异常，强制要求我们try-catch或者throws处理才行
		 */
		FileOutputStream fos = new FileOutputStream(filePath);
	}
	
	 void test11() {
	  // 假设这个字符串是别人传递给我们的
	  String clsName = "com.exception.Dog123";
	  
	  /*
	   * 这样写编译时就报错了，抛出一个异常是“ClassNotFoundException”——类找不到异常，这个异常就是个检查型异常
	   * 
	   * 这个异常是个检查型异常，所谓检查型异常是指就算你写的代码再规范再健壮也无法避免，意思就是这种异常是我们程序员永远无法100%避免的
	   * 
	   * 那这个异常为什么会抛出呢？是因为我们根本无法确定别人会把什么字符串传递给我们，别人有可能给我们传"Dog"，也有可能给我们传"Dog123"，所以
	   * 很可能我们的项目里根本就没有与这个字符串对应的一个类，你可能会想那我们获取一下项目里所有类的字符串数组，判断一下这个包含不包含这个字符串不就完了，
	   * 包含的话再反射，不包含就不反射，不就算是通过代码规范和代码健壮性来避免掉这个异常了嘛。想法是好的，但是很可惜，编译器是聪明的，它知道我们根本没有
	   * 办法获取到全部的类，比如还有一些三方库的类、动态库的类等等，所以你那个【判断一下这个包含不包含这个字符串】这个操作本身也不是严谨的，所以编译器就
	   * 报错了，强制要求我们try-catch或者throws处理才行
	   */
	  	try {
		  Class cls1 = Class.forName(clsName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	
	public static void test20() {
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
	
	public static void test21() {
		/*
		 * 比如我们这里写的一个无限递归，因为方法调用是会分配栈空间的，所以无限递归总有一天会把栈空间消耗尽，
		 * 但编译时也是不会报错的，但运行时就报StackOverFlow了，因为栈内存溢出了
		 * 
		 * java.lang.StackOverflowError extends Error
		 * 
		 * 这种异常如果我们写代码注意一点，比如写一个结束递归的条件，就可以避免，或者也可以通过异常处理的两种方式来处理一下
		 */
		test21();
	}
	
	public static void test22() {
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
	
	public static void test23() {
		/*
		 * 又比如数组越界
		 * 
		 * java.lang.ArrayIndexOutOfBoundsException extends RuntimeException
		 */
		int[] arr = { 1, 2, 3 };
		System.out.println(arr[3]);
 	}
}
