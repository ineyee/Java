// 1、如果一个Java项目中，有两个不同的类，它们都有自己的main方法，那这个Java项目岂不是有两个程序入口了吗？
// 是的，这两个main函数都可以作为程序的入口，但实际运行的时候只能选择其中的一个。
public class SecondClass {

	public static void main(String[] args) {
		System.out.println("SecondClass --- Hello World!");

	}

}
