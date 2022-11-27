package _16嵌套类外部类顶级类._内部类;

/*
 * 我们来专门说一下内部类
 * 
 * 1、没有用static修饰的嵌套类就是内部类
 * 
 * 2、内部类跟实例属性、实例方法一样都是类的实例成员，所以它们都得用外部类的实例才能访问，
 * 也就是说如果你想使用内部类，那么你就必须得先创建一个外部类的实例，然后再用这个外部类的实例去访问内部类来使用
 * 
 * 3、一个普通的类内部可以定义实例成员和类成员，
 * 而一个内部类内部则只能定义实例成员，不能定义任何用static修饰的东西，也就是说不能定义类成员
 * 
 * 所以我们可以把内部类看做是少了某些自由（只能用外部类的实例才能访问 + 不能定义类成员）、但是换来了某些特殊权
 * 限（能直接访问外部类的成员（实例成员和静态成员都可以），即便外部类的成员被定义成private，前面我们说过了因为
 * 内部类的实例内存中会有个指针指向外部类的实例）的一个类
 */
public class Person {
	// 实例属性
	public int age;
	private String nameString = "123";
	private String sex = "男";
	
	// 实例方法
	public void run() {
		
	}
	
	// 内部类
	public class Cat {
		public String nameString = "456";
		
		public void run() {
			// 内部类内部可以直接访问外部类的成员，即便定义为私有的
			System.out.println(sex);
			
			// 内部类的成员和外部类的成员同名，那外部类就写下Person.this，内部类就写下this或者不写
			System.out.println(Person.this.nameString); // 123
			System.out.println(this.nameString); // 456
			System.out.println(nameString); // 456
		}
	}
}