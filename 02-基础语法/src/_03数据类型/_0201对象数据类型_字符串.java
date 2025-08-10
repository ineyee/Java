package _03数据类型;

public class _0201对象数据类型_字符串 {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	/*
	 * 一、不可变字符串String
	 */
	public static void test1() {
		/*
		 * 1、用字面量初始化
		 * 
		 * 所有字符串字面量（比如“123”、“abc”）都是String类的实例，你可以简单地理解为：
		 * 编译器自动帮我们用构造方法new了一个String的对象出来，然后把"123"这个值交给了这个对象的value属性
		 * 但严格来说并不是这么简单，往下看就能知道区别
		 */
		String str1 = "123"; 
		String str2 = "123";

		/*
		 * equals判断的true，不需要多说
		 * ==判断的true，代表str1和str2指向的是同一个对象，接下来我们从内存的角度分析一下为什么会返回true
		 * 
		 * （1）首先我们要知道无论什么语言大概都差不多是这个样子：
		 * 一个字符串对象通常是存储在堆区的，它的内存中会存储很多东西，其中有个属性value的值就是我们通常写出来的"123"、"abc"这种字面量
		 * （2）然后我们知道内存的五大分区里有个常量区
		 * （3）然后str1是个局部变量，它存储在栈区
		 * （4）字符串常量池（String Constant Pool，SCP）：然后编译器每当遇到“用字面量初始化字符串”这种方式时，它不是直接去堆区创建一个字符串对象，而是先去常量区看看，如果
		 * 发现常量区里有某个字符串对象value属性的值跟字面量"123"一样，那就直接返回这个字符串对象，否则才会创建一个字符串对象，
		 * 并把这个字面量"123"交给这个字符串对象的value属性来存储，并直接把这个字符串对象存储在常量区，也就是说通过字面量创建出来
		 * 的字符串对象不是存储在堆区的，而是存储在常量区
		 * （5）所以str1 = "123"的时候，是在常量区新建了一个字符串对象
		 * （6）而str2 = "123"的时候，是直接把常量区value属性的值为“123”的字符串对象的地址给了str2
		 * （7）所以str1和str2存储的其实是同一个常量区的地址，所以才打印了true
		 */
		System.out.println(str1.equals(str2)); // true，代表内容一样
		System.out.println(str1 == str2); // true，代表指针一样
		
		/*
		 * 2、用构造方法初始化
		 * 
		 * 通过构造方法创建的字符串对象肯定是存储在堆区的
		 */
		String str3 = new String("123"); 
		String str4 = new String("123"); 
		
		System.out.println(str2.equals(str3)); // true，代表内容一样
		System.out.println(str2 == str3); // false，代表指针不一样
		
		
		System.out.println(str3.equals(str4)); // true，代表内容一样
		System.out.println(str3 == str4); // false，代表指针不一样
	}

	/*
	 * 二、可变字符串StringBuilder
	 */
	public static void test2() {
		/*
		 * 1、String类似于OC里的不可变字符串
		 * 也就是说你定义的是一个字符串常量，后面不能对它
		 * 进行什么插入insert、删除delete、拼接append、替换replace、翻转reverse等操作
		 * 
		 * 而StringBuilder就类似于OC里的可变字符串
		 * 定义的才是一个字符串变量，定义后能对它进行各种操作
		 * 
		 * String虽然看起来能用 + 来进行拼接，但实际上这不是真正的拼接操作
		 * 而是销毁了原来"123"寄生的那个字符串对象，并且重新创建了一个"123456"这样的对象，并让str1指向这个新对象
		 * 
		 * 而StringBuilder的拼接才是真正的拼接操作，因为它就是在原来堆区同一个对象的基础上拼接了新的内容
		 */
		String str1 = "123";
		str1 += "456";
		System.out.println(str1); // 123456
		
		StringBuilder str2 = new StringBuilder("123");
		str2.append("456");
		System.out.println(str2); // 123456
				
		/*
		 * 2、对String做的任何操作都面临对象的反复创建和销毁，因此很耗性能
		 * 而StringBuilder操作的都是同一个对象，所以几乎不耗性能
		 */
		long begin = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < 50000; i++) {
			str += i; // 耗时：565毫秒
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "毫秒");

		long begin11 = System.currentTimeMillis();
		StringBuilder str11 = new StringBuilder(); // 默认会给个""的值，而不是null
		for (int i = 0; i < 50000; i++) {
			str11.append(i); // 耗时：2毫秒
		}
		long end11 = System.currentTimeMillis();
		System.out.println("耗时：" + (end11 - begin11) + "毫秒");
	}
	
}
