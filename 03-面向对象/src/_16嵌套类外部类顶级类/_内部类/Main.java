package _16嵌套类外部类顶级类._内部类;

import _16嵌套类外部类顶级类._内部类.Person.Cat;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		// 实例属性得用实例来访问
		person.age = 18;
		// 实例方法也得用实例来访问
		person.run();
		
		// 但是我们不能直接使用内部类，这样会报错
//		Cat cat = new Cat();
		/*
		 * 内部类也得用外部类的实例来访问，当然这主要体现在new关键字前面要加上外部类的实例，等号前面还是可以直接使用内部类的
		 * 当然既然要使用一个类，那我们自然要在上面导入这个类
		 * 
		 * 这里的cat对象内存中会有个指针指向这里的person对象
		 */
		Cat cat = person.new Cat();
		cat.nameString = "Tom";
		cat.run();
	}

}

/*
 * 1、我们定义了这么一个Person类，那将来我们拿这个Person类创建一个person对象的话，person对象在堆区的内存里当然是只有age这个属性的值18，
 * run方法是存储在代码区的，Cat这个内部类当然也是存储在代码区的，就像Person这个类本身是存储在代码区的一样,Cat类不可能存储在person对象里，
 * 类在程序里只要一份就够了嘛
 * 
 * 2、但是如果我们拿Cat类创建了一个cat对象，那cat对象在堆区的内存里肯定有nameString这个属性的值Tom，
 * 此外编译器还会默认给这个cat对象内存中搞一个指针，指向使用这个内部类Cat的那个person对象，编译器为什
 * 么要这么做呢？我们之前已经说过了要想使用内部类就必须得先有一个外部类的实例，所以编译器这么做就是为了
 * 让cat对象持有person对象，这样在cat对象销毁之前person对象就不可能被销毁了，只有person对象不销毁，
 * Cat类才能被使用嘛！
 */
