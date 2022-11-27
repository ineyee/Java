package _19抽象类;

/*
 * Test1自己也是个抽象类，所以它不用全部实现抽象父类里面的抽象方法也可以
 */
public abstract class Test1 extends AbstractClass {
	@Override
	public void abstractMethod1() {}
	
	public abstract void test();
}
