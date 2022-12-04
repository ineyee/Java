package _04Math_Random;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		test1();
		test2();
	}

	
	public static void test1() {
		/*
		 * Java.lang.Math这个包里提供了常见的数学计算功能
		 */
		System.out.println(Math.abs(-100.2)); // 求绝对值，100.2
		System.out.println(Math.max(100, 200)); // 求最大值，200
		System.out.println(Math.min(100, 200)); // 求最小值，100
		System.out.println(Math.floor(3.9)); // 向下取整，3.0
		System.out.println(Math.ceil(3.1)); // 向上取整，4.0
		System.out.println(Math.round(3.5)); // 四舍五入，4
	}
	
	public static void test2() {
		/*
		 * Java.util.Random这个包可以帮我们方便地生成各种随机数
		 */
		// 随机生成[0, 100)的整数
		int num = new Random().nextInt(100); // 默认都是从0开始，包含0，但是不包含我们传进去这个数
		// 随机生成[10, 100）的整数
		int num1 = 10 + new Random().nextInt(90);
		
		System.out.println(num);
		System.out.println(num1);
	}
}
