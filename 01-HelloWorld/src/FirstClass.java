// 1、public class的类名必须跟文件名一样，否则报错
// 2、不同于我们使用的其它语言，Java有个特点：方法必须写在类里面，不能写在类外面，也就是说必须先有类，再有方法
public class FirstClass {
	// 3、main方法，Java程序的入口（方法和函数怎么叫？面向过程的语言里叫函数，面向对象的语言里叫方法）
	public static void main(String[] args) {
		System.out.println("FirstClass --- Hello World!");
	}

	// 4、Java的注释一共有三种：
	// 单行注释
	// 多行注释
	// 文档注释（用来描述一个类、类的属性、类的方法是干嘛用的，别人一用就能看到。在Eclipse这个开发工具里，我们只需要在定义好的哪个方法上面敲一下/**，然后回车一下，就会自动生成这个方法的文档注释了）

	// 这是一个单行注释

	/*
	 * 这是一个多行注释 这是一个多行注释 这是一个多行注释
	 */

	/**
	 * 计算两个整数的和
	 * 
	 * @param a 第一个整数
	 * @param b 第二个整数
	 * @return 2个整数的和
	 */
	public static int add(int a, int b) {
		return a + b;
	}
}
