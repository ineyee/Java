package _11static;

/*
 * static关键字一般用来修饰类的成员：属性、方法、嵌套类
 */
public class Person {
	/*
	 * 1、被static修饰的属性我们称之为类属性或者静态属性
	 * 2、类属性是通过类直接访问：Person.age
	 * 3、类属性在内存中只有一份，存储在方法区（不是静态全局区喔）
	 */
	public static int age;
	
	/*
	 * 1、被static修饰的方法我们称之为类方法或者静态方法
	 * 2、类方法是通过类直接访问：Person.run()
	 * 3、类方法在内存中只有一份，存储在方法区（实例方法都存储在方法区了，更何况类方法）
	 */
	public static void run() {
		System.out.println("Person - run - " + age);
	}
	
	/*
	 * static修饰嵌套类的理论知识直接去后面看嵌套类的内容吧，那里有详细介绍
	 */
}
