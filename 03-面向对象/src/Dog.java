/**
 * 01-类的定义与对象的创建
 * @author yiyi
 *
 */

/*
 * Java里定义一个类用class关键字即可
 */
public class Dog {
	// 类的属性（也可以叫成员变量、字段）
	public int age;
	public int weight;

	// 类的方法
	public void run() {
		System.out.println(age + "_" + weight + "_run");
	}
	public void eat(String food) {
		System.out.println(age + "_" + weight + "_eat_" + food);
	}
}

class TempDog {
	public static void main(String[] args) {
		// Java里创建对象的时候必须在构造方法前面加个new关键字
		Dog dog = new Dog();
		dog.age = 18;
		dog.weight = 180;
		dog.run();
		dog.eat("apple");
	}
	
	public static void Java里的垃圾回收机制() {
		// 类似于OC里ARC通过引用计数管理对象的内存，Java里JVM有个垃圾回收器GC，它会自动回收不再被使用的内存
		// 所谓不在被使用就类似于OC里这块内存的引用计数为0
		// 但OC里的引用计数会存在循环引用的问题，Java里的GC好像不会存在循环引用的问题，那种循环引用的内存，如果外界没人使用了，也会整体释放掉
		// 而C、C++都是需要我们程序员自己写释放内存的代码的，而Java就不需要我们程序员关心什么内存释放、内存泄漏等问题，而只需要关心写业务代码就行了，所以开发效率更高
	}
}
