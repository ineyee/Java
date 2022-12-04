package _09可变字符串StringBuilder;

import _09可变字符串StringBuilder.TimeUtil.Block;

public class Main {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		/*
		 * 我们平常使用的String其实类似于OC里的不可变字符串，
		 * 也就是说当你定义了一个字符串是个常量，后面不会对它
		 * 进行什么append、replace啊等操作的时候再用String，
		 * 否则就用可变字符串StringBuilder，因为String的拼接、
		 * 替换等操作是非常耗性能的，为啥耗性能呢？
		 * 
		 * 正因为String是不可变字符串，所以它用 + 来实现的拼接
		 * 操作其实是销毁了原来"123"寄生的那个字符串对象，并且重新
		 * 创建一个"123456"这样的对象，并让str1指向这个对象，所以
		 * 对String做的任何操作都面临对象的反复创建和销毁，因此很耗性能
		 * 
		 * String str1 = "123";
		 * str1 = str1 + "456";
		 * 
		 * 而可变字符串StringBuilder就用的是同一个对象了，做这些操作时几乎不耗性能
		 */
		TimeUtil.calculate(new Block() {
			@Override
			public void putCodeIn() {
				String str = "";
				for (int i = 0; i < 50000; i++) {
					str += i; // 耗时：4583毫秒
				}
			}		
		});
		
		TimeUtil.calculate(new Block() {
			@Override
			public void putCodeIn() {
				StringBuilder str = new StringBuilder(); // 默认会给个""的值，而不是null
				for (int i = 0; i < 50000; i++) {
					str.append(i); // 耗时：2毫秒
				}
			}		
		});
	}
}
