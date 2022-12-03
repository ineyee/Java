package _30Lambda表达式;

@FunctionalInterface
public interface FI {
	// 函数式接口只要求只有一个抽象方法即可，default方法不做要求
	void test();	
	default void test1() {}
	default void test2() {}
}
