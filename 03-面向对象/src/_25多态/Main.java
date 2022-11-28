package _25多态;

/*
 * 什么是多态？
 * 父类指针指向子类对象。
 * 
 * 但其实Java里父类可以指向子类对象，这是多态，接口也是可以指向实现类的对象，这也是多态。
 */
public class Main {

	public static void main(String[] args) {
		Object animal = new Dog();
		/*
		 * Java里可以用instanceof判断一个对象是否是某个类型
		 * 类似于OC里的isKindOf，Dart里的is
		 */
		System.out.println(animal instanceof Animal);
		System.out.println(animal instanceof Dog);
		System.out.println(animal instanceof String);
		
		/*
		 * Java里类型的强制转换也是在变量前面加个:(类型)，跟C语言里一样
		 */
		Dog dog = (Dog)animal;
	}

}

class Animal {
	
}

class Dog extends Animal {
	
}
