package _05数字与字符串互转_高精度计算;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {
		test3();
	}
	
	/*
	 * 字符串转数字
	 * 1、如果要把字符串转成Integer类型，那就调用Integer.valueOf
	 * 2、如果要把字符串转成Integer类型，那就调用Integer.parseInt
	 * 
	 * 这两个最好不要混用
	 */
	public static void test1() {
		Integer num1 = Integer.valueOf("12");
		System.out.println(num1); // 12
		
		int num2 = Integer.parseInt("12");
		System.out.println(num2); // 12
	}
	
	/*
	 * 数字转字符串
	 * 
	 */
	public static void test2() {
		String str = String.valueOf(1.234);
		System.out.println(str); // 1.234
	}
	
	/*
	 * 高精度计算
	 * 
	 * 1、首先我们要知道float和double都是有精度的，也就是说它们存储的都只是小数的近似值，并非准确值，
	 * 比如0.7这个小数，由于计算机只能存储0和1这种二进制的数据，所以他们设计计算机存储小数是这么存储的：
	 * 
	 * 先拿原数0.7 * 2 = 1.4，存储整数部分1
	 * 再拿余数0.4 * 2 = 0.8，存储整数部分0
	 * 再拿余数0.8 * 2 = 1.6，存储整数部分1
	 * 再拿余数0.6 * 2 = 1.2，存储整数部分1
	 * 再拿余数0.2 * 2 = 0.4，存储整数部分0
	 * 再拿余数0.4 * 2 = 0.8，存储整数部分0
	 * .....
	 * 
	 * 这样便会无限循环下去，也就说0.7这个小数在内存中存储的二进制是：0.101100110110110...一直110下去
	 * 但是float只有4个字节的存储空间，double只有8个字节的存储空间，不可能存储一个无限小数，所以它们就按
	 * 指定的精度来存储这个小数0.7了，但其实它们内存中存储的并不是真的0.7，因此如果我们拿这种数据去参与计算，
	 * 就很有可能会出现那个经典的错误：0.7 * 0.7 不等于 0.49，而是等于0.48999999999999994，也就是说其实
	 * 我们开发中遇到小数计算丢精度的问题其实不是运算带来的，而是小数的存储带来的、小数存储的时候已经丢精度
	 * 了（当然不是所有的小数存储是都会丢精度，有的小数转换成二进制是有限的，就可能不需要丢精度）
	 * 
	 * 那怎么处理呢？
	 * （1）大多数的情况下，我们的场景可能就是单纯地用一下这个数，所以对0.48999999999999994做一下四舍五入、
	 * 再控制下小数的位数就可以了
	 * （2）但如果涉及到金额的计算，那就不能这么草率了，建议跟钱有关的，不要用float或double，而是用BigDecimal
	 * 
	 * 2、BigDecimal，那怎么使用BigDecimal呢？
	 * （1）建议直接使用字符串来初始化BigDecimal，而不是用float或double来初始化它
	 */
	public static void test3() {
		double d1 = 0.7;
		double d2 = 0.7;		
		double d3 = d1 * d2;
		System.out.println(d3); // 不是0.49，而是0.48999999999999994
		
		/*
		 * 不建议
		 * 
		 * 因为别看着你这写了个0.7，但它只是个字面量、你看着是0.7这个数而已，
		 * 编译器真正去初始化bd的时候，肯定还是用二进制来表示0.7这个小数的，
		 * 也就是向上面那样0.101100110110110...一直110下去，然后取个精度，
		 * 所以这样搞的话，初始化出来的bd其实已经不是0.7了
		 */
		BigDecimal bd = new BigDecimal(0.7);
		/*
		 * 建议
		 * 
		 * 因为BigDecimal并不是存储小数的，而是会把"0.7"这个字符串拆成"0"、"."、"7"
		 * 这三个字符单独存储，所以就不存在存储的时候丢精度的问题，只要存储不存在丢精度问题，
		 * 那运算就是小学数学了，计算机肯定能算对了
		 */
		BigDecimal bd1 = new BigDecimal("0.7");
		BigDecimal bd2 = new BigDecimal("0.7");
		// BigDecimal的加减乘除、保留几位小数等操作
		System.out.println(bd1.add(bd2)); // 1.4
		System.out.println(bd1.subtract(bd2)); // 0.0
		System.out.println(bd1.multiply(bd2)); // 0.49
		System.out.println(bd1.divide(bd2)); // 1
		System.out.println(bd1.setScale(2)); // 0.70
	}
}
