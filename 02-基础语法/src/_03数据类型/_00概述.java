package _03数据类型;

public class _00概述 {

	public static void main(String[] args) {
		String str = "Hello";
		
		System.out.println(str.getClass() == String.class); // true
		System.out.println(str instanceof String); // true
	}

}

/*
	一、数据类型分类
	Java里的数据类型分类为：
	1、基本数据类型 <==> 值类型
		* boolean：布尔类型（true/false），对应包装类：java.lang.Boolean
		* 
		* byte：单字节整型（8位、[-128, 127]），对应包装类：java.lang.Byte
		* short：短整型（16位、[-32768, 32767]），对应包装类：java.lang.Short
		* int：整型（32位、足够表示 9 位数字），对应包装类：java.lang.Integer
		* long：长整型（64位、足够表示 19 位数字），对应包装类：java.lang.Long
		*
		* float：单精度浮点型（32位），对应包装类：java.lang.Float
		* double：双精度浮点型（64位），对应包装类：java.lang.Double
	
	2、对象数据类型 <==> 引用类型

	
	3、特殊数据类型
		* void：函数无返回值类型
		* null：空类型，可以赋值给任何引用类型变量
 */

/*
	二、getClass() 和 instanceof
	* getClass() 方法只可以应用于对象数据类型的变量，返回一个类，可以直接与类字面量（如 String.class）比较
	* instanceof 运算符只可以应用于对象数据类型的变量，返回一个布尔值，用来判断一个对象是否是某个类或其子类的实例（或实现了某个接口）
 */
