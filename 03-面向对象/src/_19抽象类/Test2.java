package _19抽象类;

/*
 * Test2本身不是个抽象类，所以它得实现它抽象父类里所有的抽象方法
 */
public class Test2 extends Test1 {
	@Override
	public void abstractMethod2(int num1) {}

	@Override
	public void abstractMethod3(int num1, int num2) {}

	@Override
	public void test() {}
}
