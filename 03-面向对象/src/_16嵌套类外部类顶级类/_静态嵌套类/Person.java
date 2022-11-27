package _16嵌套类外部类顶级类._静态嵌套类;

/*
 * 我们再来专门说一下静态嵌套类
 * 
 * 1、用static修饰的嵌套类就是静态嵌套类
 * 
 * 2、静态嵌套类跟类属性、类方法一样都是类的类成员，所以它们都得用外部类的类名才能访问
 * 
 * 3、一个普通的类内部可以定义实例成员和类成员，
 * 静态嵌套类内部还是可以定义实例成员和类成员，就当它是个普通类一样看待就好了
 * 
 * 所以我们同样可以把静态嵌套类看做是少了某些自由（只能用外部类的类名才能访问）、但是换来了某些特殊权
 * 限（能直接访问外部类的类成员，即便外部类的类成员被定义成private）的一个类
 */
public class Person {
	// 实例属性
	public static int age;
	private static String nameString = "123";
	private static String sex = "男";
	
	// 实例方法
	public void run() {
		Car car = new Car();
		car.price = 10;
		car.run();
	}
	
	// 静态嵌套类
	public static class Cat {
		public static String nameString = "456";
		
		public void run() {
			// 静态嵌套类内部可以直接访问外部类的类成员，，即便定义为私有的
			System.out.println(sex);
			
			// 同名也没事，因为是静态的嘛，直接类名点就行
			System.out.println(Person.nameString); // 123
			System.out.println(nameString); // 456
		}
	}
}

/*
 * 其它语言里一般会这么写，其它语言里可以用private修饰这个类，
 * 但是Java里只能是public和无修饰符修饰类，所以Java里一般不这么写，而是写成嵌套类
 */
class Car {
	public double price;
	public void run() {
		System.out.println("Car_" + price + "_run");
	}
}
