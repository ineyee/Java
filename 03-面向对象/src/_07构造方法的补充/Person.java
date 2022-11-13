package _07构造方法的补充;

public class Person {
	int age;
	
	// 全能构造方法
	public Person(int age) {
		this.age = age;
	}
	
	// 无参构造方法
	public Person() {
		// 调用一下全能构造方法
		this(0);
	}
}
