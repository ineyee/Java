package _06重写和super;

public class Student extends Person {
	/*
	 * Java里子类重写父类里的方法也是用override
	 */
	@Override
	public void speak() {
		/*
		 * Java里子类调用父类里的方法（包括构造方法）也是用super
		 */
		super.speak();
		eat();
		this.eat();
		super.eat();
	}
	
	@Override
	public void eat() {
		System.out.println("Student - eat");
	}
}
