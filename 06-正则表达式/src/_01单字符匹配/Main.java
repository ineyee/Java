package _01单字符匹配;

public class Main {
	public static void main(String[] args) {
		/*
		 * 1、中括号[]，代表单字符匹配，如：
		 * [abc]：代表a字符或b字符或c字符
		 */
//		test1();
		
		/*
		 * 2、中括号加小箭头[^]，代表除了xxx之外的单字符匹配，如：
		 * [^abc]：代表除了a字符、b字符、c字符以外的任意一个字符
		 */
//		test2();
		
		/*
		 * 3、中括号加小横杠[-]，代表从xxx到xxx之间的任意一个字符，如：
		 * [a-z]：代表任意一个小写字母
		 * [0-9]：代表任意一个单字符数字
		 * 
		 * 此外注意：中括号的嵌套完全等价于直接把内部的中括号给拿掉，所以我们一般不会写中括号的嵌套，
		 * 而如果你遇到别人写了中括号的嵌套，知道要直接拿掉来帮助自己理解正则表达式的含义就可以了，如：
		 * 
		 * [a-c[d-f]] 完全等价于 [a-cd-f]，为什么呢？
		 * 因为[a-c]不就是[abc]嘛，而[d-f]不就是[def]，你可能会想一个中括号是给一个字符占了一个坑，
		 * 那[a-c[d-f]]是不是应该占了两个字符的坑呢，错喽！既然外面的中括号只能占一个字符的坑，那里
		 * 面的中括号怎么可能占坑嘛，要是它占了，那外面的中括号岂不是会输出ad、bf这样的双字符了，那还
		 * 叫什么单字符匹配，所以遇到中括号的嵌套直接把里面那种中括号给它干掉就ok了
		 */
//		test3();
//		test4();
		
		/*
		 * 4、中括号加逻辑与[&&]，代表xxx和xxx的交集，也就是说两个范围内都存储在的字符，如：
		 * [a-c&&bc]：代表字符b或者字符c
		 * 
		 * 一见到逻辑与&&符号，它有排斥性，你自动把它两边的东西给分成两个组即可
		 */
		test5();
	}
	
	public static void test1() {
		// 定义一个正则表达式，它代表的含义为bat、cat、rat这三个字符串都可以
		String regex = "[bcr]at";
		
		/* 
		 * 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求，
		 * "bat"、"cat"、"rat"很明显是bat、cat、aat其中的一种，所以满足，而"hat"则不满足正则表达式的要求
		 */
		System.out.println("bat".matches(regex)); // true
		System.out.println("cat".matches(regex)); // true
		System.out.println("rat".matches(regex)); // true
		System.out.println("hat".matches(regex)); // false
	}
	
	public static void test2() {
		// 定义一个正则表达式，它代表的含义为除了bat、cat、rat这三个字符串以外的任何一个"某at"都可以
		String regex = "[^bcr]at";
		
		/* 
		 * 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求，
		 * "bat"、"cat"、"rat"很明显是bat、cat、aat其中的一种，所以不满足，而"hat"则满足正则表达式的要求
		 */
		System.out.println("bat".matches(regex)); // false
		System.out.println("cat".matches(regex)); // false
		System.out.println("rat".matches(regex)); // false
		System.out.println("hat".matches(regex)); // true
	}
	
	public static void test3() {
		/*
		 * 定义一个正则表达式，我们先来学习下怎么分析这个正则表达式：
		 * 1、首先见到中括号，我们下意识地就应该知道它这个位置只会有一个字符，也就是说这个中括号不管有多长，它只给一个字符占了个坑
		 * 2、然后因为它里面的小横杠有结合性——也就是说小横杠左右必然会吸附两个东西，所以a-z是一组、类似于我们[abc]里的a，
		 * A-Z是一组、类似于我们[abc]里的b，1-9是一组、类似于我们[abc]里的c，然后下划线_单独是一组
		 * 3、这样一分组，我们就知道这个正则表达式代表以任意一个小写字母、或者任意一个大写字母、或者1到9的数字、或者下划线_开头，
		 * 然后后面跟上个foo
		 */
		String regex = "[a-zA-z1-9_]foo";
		
		/* 
		 * 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		 */
		System.out.println("afoo".matches(regex)); // true
		System.out.println("kfoo".matches(regex)); // true
		System.out.println("Qfoo".matches(regex)); // true
		System.out.println("Bfoo".matches(regex)); // true
		System.out.println("Zfoo".matches(regex)); // true
		System.out.println("4foo".matches(regex)); // true
		System.out.println("7foo".matches(regex)); // true
		System.out.println("_foo".matches(regex)); // true
		System.out.println("+foo".matches(regex)); // false
	}
	
	public static void test4() {
		/*
		 * 定义一个正则表达式，
		 * 注意中括号里小横杠的优先级性比^高，所以应该先像test3那样把组分了，然后再用^取反
		 * 所以这个正则表达式的含义为除了【字母、1-9数字、下划线开头 + foo】的【任意一个字符 + foo】
		 */
		String regex = "[^a-zA-z1-9_]foo";
		
		/* 
		 * 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		 */
		System.out.println("afoo".matches(regex)); // false
		System.out.println("kfoo".matches(regex)); // false
		System.out.println("Qfoo".matches(regex)); // false
		System.out.println("Bfoo".matches(regex)); // false
		System.out.println("Zfoo".matches(regex)); // false
		System.out.println("4foo".matches(regex)); // false
		System.out.println("7foo".matches(regex)); // false
		System.out.println("_foo".matches(regex)); // false
		System.out.println("+foo".matches(regex)); // true
	}
	
	public static void test5() {
		/*
		 * 定义一个正则表达式
		 */
		String regex = "[a-c&&[^bc]]";
		
		/* 
		 * 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		 */
		System.out.println("a".matches(regex)); // false
		System.out.println("b".matches(regex)); // true
		System.out.println("c".matches(regex)); // true
		System.out.println("d".matches(regex)); // false
	}
}
