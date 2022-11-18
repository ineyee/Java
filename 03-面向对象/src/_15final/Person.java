package _15final;

public class Person {	
	/*
	 * 跟Dart一样，Java里也有const和final两个关键字，但是const关键字并没有被使用起来，所以我们主要就是用final关键字
	 * 
	 * const和final都可以用来定义常量，但是const常量要求必须在编译时就有明确的值，而final常量则编译时和运行时都可以，只
	 * 要最终能有个确定的值就行了，既然是常量也就意味着它们只能被赋值一次以后不能再被修改
	 * 
	 * 按照定义来说，只要用final修饰的变量就是一个常量，也就是说下面的age也是个常量，这句话没错
	 * 但是在Java里更约定俗成的、final关键字更多的使用场景却是跟static连用，即static final修饰的变量我们才称之为常量,
	 * 而且常量一般都会定义成某个类的类属性，就像Math.PI一样，而不会对一个局部变量搞成常量
	 * 
	 * 同时Java里的常量就像C语言里的宏定义一样，编译器会直接把编译时就能确定下来的（条件1，比如你搞了一个函数算出来一个常量值，那就不行）、
	 * 基本数据类型和字符串（条件二、其它引用类型不行的）的常量给替换成相应的字面量，这样代码的执行效率就会更高
	 */
	// 虽然确实是个常量，但实际开发中我们一般不这么做
	public final int age = 18;
	// 真正的常量
	public static final int COUNT = 0;
	
	public static void run() {
		System.out.println(COUNT);
		// 编译器会在编译时直接把COUNT替换成18
		System.out.println(18);
	}
	
	/*
	 * 额外的、不需要怎么关心的
	 * final的意思是最终的，所以：
	 * 1、被final修饰的类不能被继承
	 * 2、被final修饰的成员：final属性只能被赋值一次，final方法不能被重写，final嵌套类不能被继承
	 */
}
