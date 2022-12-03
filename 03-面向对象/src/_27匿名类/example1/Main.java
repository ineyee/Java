package _27匿名类.example1;

/*
 * 举个接口的例子：
 * 1、假设我们有一个接口是Runnable
 * 2、然后有一个类是Person
 * 3、Person类实现了Runnable接口
 * 4、然后我们在整个项目中又只有在下面test1方法里才用到了这个Person类
 * 5、那我们完全可以抛弃传统使用Person类的方式，转而使用匿名类
 */

/*
 * 举个抽象类的例子：
 * 1、假设我们有一个抽象类是Animal
 * 2、然后有一个正常类是Dog
 * 3、Dog继承自Animal
 * 4、然后我们在整个项目中又只有在下面test2方法里才用到了这个Dog类
 * 5、那我们完全可以抛弃传统使用Dog类的方式，转而使用匿名类
 */
public class Main {

	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		// 传统使用Person类的写法
//		Person person = new Person();
//		person.run();
		
		// 匿名类使用Person类的写法，这样其实我们就可以删掉Person.java文件了
		Runnable person = new Runnable() {
			@Override
			public void run() {
				System.out.println("Person - run");
			}
		};
		person.run();
	}
	
	public static void test2() {
		// 传统使用Dog类的写法
//		Dog dog = new Dog();
//		dog.eat();
		
		// 匿名类使用Person类的写法，这样其实我们就可以删掉Dog.java文件了
		Animal dog = new Animal() {
			@Override
			void eat() {
				System.out.println("Dog - eat");
			}
		}; 
		dog.eat();
	}
}
