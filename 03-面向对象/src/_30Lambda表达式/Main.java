package _30Lambda表达式;

import _27匿名类.example2.TimeUtil;
import _27匿名类.example2.TimeUtil.Block;

/*
 * 一、函数式接口
 * 在学习Lambda表达式之前，我们先学一个概念：函数式接口
 * 
 * 所谓函数式接口就是指：只有一个抽象方法的接口，default方法不做要求，比如FI接口
 * 我们可以在接口的上方加上 @FunctionalInterface 注解来表明该接口是一个函数式接口
 */

/*
 * 二、Lambda表达式是什么？
 * 
 * Lambda表达式其实就是一个简化代码写法的语法，它的格式为：
 * (参数列表) -> {
 * 	// 方法的执行体
 * }
 * 
 * 看起来很像其它语言里的箭头函数，没错它指的就是函数式接口里那唯一的一个抽象方法，
 * 那个方法是什么样子，这个箭头函数就搞成什么样子就行了，这样就可以省略 new 接口名() {}
 * 这么一堆代码了，而是只写函数式接口里的那个唯一的抽象方法即可，因为只有一个抽象方法嘛，
 * 所以编译器肯定能倒推回去最原始的写法的，也就是说就算我们写了Lambda表达式，编译器最终
 * 还是会自动搞成最原始的写法，也就是说Lambda表达式只是个语法糖而已
 */

/*
 * 三、Lambda表达式的使用场景，为什么要使用Lambda表达式？
 * 
 * 当匿名类实现的是函数式接口时，我们就可以用Lambda表达式简化代码的写法，只有这种情况下才能使用Lambda表达式。
 */

/*
 * 四、举个例子，还是_27匿名类里那个例子：
 * 
 * TimeUtil里面那个Block接口只有一个抽象方法，所以我们先在给它补上注解，
 * 并且用Lambda表达式简化一下它的使用方法，下面会把原始的写法和Lambda表达式
 * 都写在下面，自己对比下
 */
public class Main {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		// 传统写法
		TimeUtil.calculate(new Block() {
			@Override
			public void putCodeIn() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(i);
				}
			}
		});
		
		/*
		 * Lambda表达式简化写法
		 * 
		 * 简化的思路就是：
		 * 1、直接把接口里的抽象方法搞过来就行
		 * 2、putCodeIn没有参数，所以直接写个()就行，然后再来个固定的->，然后直接把执行体
		 * 赋值过来，当然执行体有返回值也没问题
		 */
		TimeUtil.calculate(
			() -> {
				for (int i = 0; i < 10000; i++) {
					System.out.println(i);
				}
			}
		);
	}

}
