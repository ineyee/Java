package _03量词;

public class Main {
	public static void main(String[] args) {
		/*
		 * 量词用{}、*、?、+这四个符号来搞，这些符号可以用来描述单个字符，也可以用来描述字符串（后面的捕获组）：
		 * 
		 * 1、X{n}：代表字符X出现n次
		 * 2、X{n,m}：代表字符X出现[n,m]次
		 * 3、X{n,}：代表字符X出现至少n次
		 * 4、X*：代表字符X出现任意多次
		 * 5、X?：代表字符X出现0次或1次
		 * 6、X+：代表字符X出现至少1次
		 * 
		 * 注意：当不使用捕获组时，这些符号都是描述单个字符的，而不是描述字符串的，比如：
		 * WX{2,4}：代表紧贴{}符号的字符X出现[2,4]次，而不是字符串WX出现[2,4]次，所以这个正则表达式的含义为
		 * WXX、WXXX、WXXXX这三个字符串中的任意一个，而不是WXWX、WXWXWX、WXWXWXWX这三个字符串中的任意一个
		 * 
		 * 【其次以后我们见了量词的符号，可以采用完全把量词修饰的东西展开的方式来理解正则表达式的含义，】比如
		 * "[abc]{3}"，它展开后完全等价于"[abc][abc][abc]"，所以这个正则表达式的含义有27种字符串的情况，
		 * 包含"abc"、"aaa"等，而不仅仅是a出现3次的"aaa"或b出现3次的"bbb"或c出现3次的"ccc"。
		 */
		test6();
	}
	
	public static void test1() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 它的含义为6这个字符出现3次，所以正则表达式的含义为666这个字符串
		 */
		String regex = "6{3}";
		
		// 定义一个字符串
		String str1 = "66";
		String str2 = "666";
		String str3 = "6666";
		
		// 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		System.out.println(str1.matches(regex)); // false
		System.out.println(str2.matches(regex)); // true
		System.out.println(str3.matches(regex)); // false
	}
	
	public static void test2() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 它的含义为6这个字符出现2到4次，所以正则表达式的含义为66、666、6666这三个字符串中的任意一个
		 */
		String regex = "6{2,4}";
		
		// 定义一个字符串
		String str1 = "6";
		String str2 = "66";
		String str3 = "666";
		String str4 = "6666";
		String str5 = "66666";
		
		// 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		System.out.println(str1.matches(regex)); // false
		System.out.println(str2.matches(regex)); // true
		System.out.println(str3.matches(regex)); // true
		System.out.println(str4.matches(regex)); // true
		System.out.println(str5.matches(regex)); // false
	}
	
	public static void test3() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 它的含义为6这个字符出现至少2次，所以正则表达式的含义为66、666、6666...这些字符串中的任意一个
		 */
		String regex = "6{2,}";
		
		// 定义一个字符串
		String str1 = "6";
		String str2 = "66";
		String str3 = "666";
		String str4 = "6666";
		String str5 = "66666";
		
		// 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		System.out.println(str1.matches(regex)); // false
		System.out.println(str2.matches(regex)); // true
		System.out.println(str3.matches(regex)); // true
		System.out.println(str4.matches(regex)); // true
		System.out.println(str5.matches(regex)); // true
	}
	
	public static void test4() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 它的含义为6这个字符出现任意多次，所以正则表达式的含义为""、6、66、666、6666...这些字符串中的任意一个
		 */
		String regex = "6*";
		
		// 定义一个字符串
		String str1 = "";
		String str2 = "6";
		String str3 = "66";
		
		// 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		System.out.println(str1.matches(regex)); // true
		System.out.println(str2.matches(regex)); // true
		System.out.println(str3.matches(regex)); // true
	}
	
	public static void test5() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 它的含义为6这个字符出现0次或1次，所以正则表达式的含义为""、6这两个字符串中的任意一个
		 */
		String regex = "6?";
		
		// 定义一个字符串
		String str1 = "";
		String str2 = "6";
		String str3 = "66";
		
		// 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		System.out.println(str1.matches(regex)); // true
		System.out.println(str2.matches(regex)); // true
		System.out.println(str3.matches(regex)); // false
	}
	
	public static void test6() {
		/*
		 * 定义一个正则表达式
		 * 
		 * 它的含义为6这个字符出现至少1次，所以正则表达式的含义为6、66、666...这些字符串中的任意一个
		 */
		String regex = "6+";
		
		// 定义一个字符串
		String str1 = "";
		String str2 = "6";
		String str3 = "66";
		
		// 调用字符串的matches方法，看看这个字符串是否满足正则表达式的要求
		System.out.println(str1.matches(regex)); // false
		System.out.println(str2.matches(regex)); // true
		System.out.println(str3.matches(regex)); // true
	}
}
