import java.lang.reflect.Array;

import org.omg.CORBA.Object;

/**
 * 02-数据类型
 * @author yiyi
 *
 */
public class DataType {

	public static void main(String[] args) {

	}
	
	void 数据类型() {
		/*
		 * Java里的数据类型分为两类：
		 * 1、基础数据类型，一共有八种，除了这八种其它全都是引用数据类型
		 * 		boolean：布尔类型，占4个字节（在编译后，JVM会把它搞成int来代替），有true和false两个取值
		 * 
		 * 		byte：整型，占1个字节，取值范围[-128, 127]
		 * 		short：整型，占2个字节，取值范围[-32768, 32767]
		 * 		int：整型，占4个字节，取值范围[-2^31, 2^31 - 1]，默认int类型
		 *		long：整型，占8个字节，取值范围[-2^63, 2^63 - 1]
		 *
		 *		float：浮点型，占4个字节，取值范围[1.40E-45F, 3.4028235E38F]
		 *		double：浮点型，占8个字节，取值范围[4.9E-324, 1.7976931348623157E308]，默认double类型
		 *
		 * 		char：字符类型，占2个字节，存储单个Unicode字符
		 * 
		 * 2、引用数据类型，类似于指针
		 * 		字符串的类型为：String
		 * 		数组的类型为：T[]，T就是数组里存储的数据类型
		 */
	}
	
	void 常量() {
		/*
		 * 常量是指赋值后不能再改变的量。
		 */
	}

	void 变量() {
		/*
		 * 变量是指赋值后还能再改变的量。
		 * 
		 * Java中规定变量在被使用之前必须被初始化：
		 * 		局部变量：需要程序员手动初始化；
		 * 		非局部变量（类的属性、类变量）：编译器会自动给未初始化的变量赋一个默认值，默认值跟OC里是一样的
		 */
		int age = 0;
		System.out.println(age);
	}
	
	void 字面量() {
		/*
		 * 等号等运算符右边直接写出来的值就是字面量。比如：
		 * 
		 * boolean类型的字面量：true、false这两个值
		 * int类型的字面量：10这个值
		 * double类型的字面量：123.4这个值
		 * char类型的字面量：'A'这个值
		 * String类型的字面量："ABC"这个值
		 * 空类型的字面量：null这个值
		 */
		
		/*
		 * 字面量、常量、变量有什么区别？
		 * 
		 * 字面量只能出现在等号等运算符右边；
		 * 常量是指赋值后不能再改变的量；
		 * 变量是指赋值后还能再改变的量；
		 * 
		 * int a = 10; // a是变量，10是字面量
		 * final int A = 10; // A是常量，10是字面量
		 */
	}
	
}
