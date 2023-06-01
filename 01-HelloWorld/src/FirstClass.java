// 1、用public关键字修饰的class的类名必须跟文件名一样，否则报错
// 2、不同于我们使用的其它语言，Java有个特点：方法必须写在类里面，不能写在类外面，也就是说必须先有类，再有方法，因为Java做面向对象做的更彻底，不允许有类和对象以外的东西存在，像C++就是面向过程和面向对象都可以
public class FirstClass {
	
	// 3、main方法，Java程序的入口（方法和函数怎么叫？面向过程的语言里叫函数，面向对象的语言里叫方法）
	public static void main(String[] args) {
		System.out.println("FirstClass --- Hello World!");
	}
	
}
