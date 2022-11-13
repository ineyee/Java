package _09访问权限;

public class Main {

	public static void main(String[] args) {
		/*
		 * Java里一共有4个级别的访问权限，从高到低依次是：
		 * 
		 * 1、public：在项目里的任何地方————即在项目里的所有包中都能访问
		 * 2、protected：在自己的包中能访问 + 子类中能访问（因为子类可能跟父类不在同一个包里）
		 * 3、无修饰符（默认为包私有权限package-private）：仅在自己的包中能访问
		 * 4、private：仅在自己的类中能访问
		 */
		
		/*
		 * 1、上面4个修饰符都可以修饰类的成员：成员变量、方法、内部类
		 * 2、但是只有public和无修饰符才能修饰顶级类————也就是我们正常定义的类，而不是内部类
		 */

	}

}

/*
 * 一个文件里面可以定义多个类（即顶级类）
 * 但是前面我们说过用public修饰的类必须跟文件名同名，所以一个文件里的其它类就只能无修饰符了，也就是只能在自己的包内访问
 */
class Person {
	
}

class Student extends Person {
	
}
