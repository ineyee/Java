package _05捕获组;

public class Main {
	public static void main(String[] args) {
		/*
		 * ()代表捕获组，即小括号里面的东西是作为一个整体出现的
		 */
		// doggg，就这1个字符串
		String regex1 = "dog{3}";
		// [dog][dog][dog]，共27种字符串
		String regex2 = "[dog]{3}";
		// dogdogdog，就这1个字符串
		String regex3 = "(dog){3}";
	}
}
