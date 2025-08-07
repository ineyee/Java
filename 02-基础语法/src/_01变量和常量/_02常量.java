package _01变量和常量;

public class _02常量 {

	public static void main(String[] args) {
	    final double PI = 3.14;
	    System.out.println(PI); // 3.14
	}

}

/*
 	1、常量是什么
    常量是指第一次赋值后不能再次赋值的量，它由final、数据类型、常量名、常量值三大部分组成：
    final 数据类型 常量名 = 常量值;

    * final：final用来表明要定义一个常量
    * 数据类型：boolean、int、double等，用来表明变量所对应的内存有多大或者以什么作为结束标识，直白地说就是用来存储什么数据类型的数据
    * 常量名：拿到常量名就是拿到了常量所对应的内存里的值
    * 常量值：就是存储在常量所对应的内存里的值
 */

/*
	2、常量的声明及初始化
    常量必须在声明的同时初始化，且初始化后不能再被赋值更改
    通常使用全大写字母，单词间用下划线分隔
   
    final double PI = 3.14;
    System.out.println(PI); // 3.14
 */
