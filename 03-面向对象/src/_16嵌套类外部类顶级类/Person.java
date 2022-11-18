package _16嵌套类外部类顶级类;

/*
 * 本篇介绍3个概念：
 * 1、嵌套类（Nested Class）
 * 		──静态嵌套类（Static Nested Class）
 * 		——内部类（Inner Class)
 * 2、外部类（Outer Class）
 * 3、顶级类（Top-level Class）
 */

/*
 * 1、那什么是嵌套类？
 * 定义在其它类内部的类就是嵌套类，嵌套类和属性、方法一样都是类的成员
 * 例如下面的Cat、Dog相对于Person来说就是嵌套类，Head、Body相对于Cat来说就是嵌套类
 * 
 * 嵌套类又可以分为两种：
 * 		——静态嵌套类：用static关键字修饰的嵌套类就是静态嵌套类，例如下面的Cat、Head就是静态嵌套类
 * 		——内部类：没用static关键字修饰的嵌套类就是内部类，也叫非静态嵌套类，例如下面的Dog、Body就是内部类
 */

/*
 * 2、那什么是外部类？
 * 在嵌套类外层的类就是外部类，例如下面的Person相对于Cat、Dog来说就是外部类，Cat相对于Head、Body来说就是外部类
 */

/*
 * 3、那什么是顶级类？
 * 最外层的外部类就是顶级类，例如下面的Person、Teacher、Student就是顶级类
 */

/*
 * 至此你就感受到了，嵌套类和外部类是一个相对的概念，例如下面的Cat就既是嵌套类也是外部类，只有顶级类才是个绝对的概念
 */

public class Person {
	static class Cat {
		static class Head {
			
		}
		
		class Body {
			
		}
	}
	
	class Dog {		
		
	}
}

class Teacher {
	
}

class Student {
	
}
