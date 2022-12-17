package _04PatterMatcher的其它几个常用方法;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		test2();
	}
	
	public static void test1() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 这个正则表达式完全等价于"\\d\\d\\d"，它的含义为任意一个0~9的数字连续出现三次，换句话说连续的三个数字就行，
		 * 比如123、444、555、666、789这样的字符串
		 */
		String regex = "\\d{3}";
		
		// 定义一个字符串
		String str = "123_444_555_666_789";
		
		/*
		 * 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		 * 
		 * 这里肯定是false，因为这个字符串这么长肯定不满足正则表达式的要求，因为str.matches方法要求的就是要完全匹配
		 */
		System.out.println(str.matches(regex)); // false
	}
	
	/*
	 * 但在实际开发中，我们经常会遇到这样的需求，就是：
	 * 
	 * 我们并不是想看一个字符串本身是不是完全匹配正则表达式的要求，而是想看看字符串里有没有子串能匹配上
	 * 正则表达式的要求，换句话说就是想看看字符串里包含不包含满足正则表达式的子串，如果包含的话就把这些子串给找出来，
	 * 那就用到了Patter和Matcher的其它几个常用方法：
	 * boolean find()：如果从字符串中找到了满足正则表达式的子串，则返回true，结束本次查找。下次查找的范围会剔除掉上一次查找过的范围。
	 * String group()：如果find方法返回true，那我们就可以通过group方法获取到满足正则表达式的子串。
	 * int start()：如果find方法返回true，那我们就可以通过start方法获取到满足正则表达式的子串开始index。
	 * int end()：如果find方法返回true，那我们就可以通过end方法获取到满足正则表达式的子串的结束index。
	 * str.matches方法内部其实也是调用了这些方法。
	 * 
	 * 比如上面的例子中str本身虽然不完全匹配regex，但我们其实想找str的子串能匹配regex的，比如它的子串
	 * 123、444、555、666、789就满足。
	 */
	public static void test2() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 这个正则表达式完全等价于"\\d\\d\\d"，它的含义为任意一个0~9的数字连续出现三次，换句话说连续的三个数字就行，
		 * 比如123、444、555、666、789这样的字符串
		 */
		String regex = "\\d{3}";
		
		// 定义一个字符串
		String str = "123_444_555_666_789";
		
		/*
		 * 1、编译一下regex，看看语法对不对
		 * 2、拿到匹配器
		 */
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
		// find方法一次只能找一次
//		if (m.find()) {
//			System.out.println(m.group()); // 123
//			System.out.println(m.start()); // 0
//			System.out.println(m.end()); // 3
//		}	
		
		// 如果我们想把所有的子串都找出来，那就可以把if改成while循环
		while (m.find()) {
			System.out.println(m.group());
			System.out.println(m.start());
			System.out.println(m.end());
		}	
	}
}
