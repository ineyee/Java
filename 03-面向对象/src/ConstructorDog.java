/**
 * 03-构造方法
 * @author yiyi
 *
 */
public class ConstructorDog {
	public int age;
	public int weight;
	
	/*
	 * 1、当我们不自定义构造方法的时候，编译器会默认给这个类生成一个无参的构造方法，即：
	 * 
	 * 	public ConstructorDog() {}
	 */
		
	/*
	 * 2、当我们自定义了构造方法时，那编译器就不会帮这个类自动生成无参的构造方法了，所以此时如果我们还想使用无参
	 * 的构造方法就得自己写一个了
	 */
	// 全能构造方法，即参数最全的那个构造方法，其它构造方法都可以调用全能构造方法
	public ConstructorDog(int age, int weight) {
		// this的用途一：用在属性身上，记住只有当出现歧义的时候再使用，否则不用写就行
		this.age = age;
		this.weight = weight;
	}
	
	// 无参构造方法，即一个参数都没有的那个构造方法
	public ConstructorDog() {
		// this的用途二：在一个构造方里调用另一个构造方法时只能用this()，而不能是ConstructorDog(0, 0)，或者this.ConstructorDog(0, 0)
		this(0, 0);
	}
	
	// 部分参数构造方法
	public ConstructorDog(int age) {
		/* 
		 * this知识点补充：所有的面向对象语言里，包括OC、Swift、Dart等，所有的方法都有一个默认的隐藏参数this，
		 * 而且这个this参数还是在参数列表的第一个参数位置，就像OC和Swift里的self，Dart里的this一样，其实每个
		 * 方法都是像下面这样：
		 * 
		 * public ConstructorDog(ConstructorDog this, int age) { ... }
		 * 
		 * 为什么这样做？我们知道方法是存储在类内部的，而类编译成二进制后会加载到代码区，一个类的方法肯定只需要存一份
		 * 就够了，那不同的对象调用同一个方法肯定应该打印出对象自己age，所以方法里怎么拿到这个对象呢？那就只能是参数
		 * 传进来了，所以编译器就为所有的方法都搞了这么一个隐藏的参数this，代表方法调用者——即调用方法的那个对象，这就类似于：
		 * 
		 * public ConstructorDog(ConstructorDog this, int age) { ... }
		 */ 
		this(age, 0);
		System.out.println(age);
		
		// 在一个构造方法里调用另一个构造方法时，必须把另一个构造方法的调用放在第一条语句来执行，才能做执行其它语句，否则报错，这是语法规定
//		this(age, 0);
	}
}

class TempConstructorDog {
	public static void main(String[] args) {
		ConstructorDog dog = new ConstructorDog(10);
		System.out.println(dog.age);
		System.out.println(dog.weight);
	}
}