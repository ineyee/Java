package _10封装;

/*
 * 面向对象的三大特性就是：封装、继承、多态
 * 
 * 前面我们已经说过继承了，现在说下封装
 * 所谓封装就是成员变量都搞成私有的、不希望外界直接访问、更具封装性，然后再针对每一个成员变量都提供
 * public的set方法和get方法供外界访问
 */
public class Person {
	// 实例属性
	private int age;
	private String name;
	
	// 实例方法
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
