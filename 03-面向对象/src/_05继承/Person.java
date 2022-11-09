package _05继承;

/*
 * Java里所有的类都最终继承自Object，Object就像OC里的NSObject一样是所有类的基类
 * 
 * 也就是说下面的Person类其实就继承自Object：public class Person extends Object { ... }
 * 只不过已经默认了，我们不需要显性地写出来继承自Object而已
 */
public class Person {
	public int age;
	public void walk() {
		System.out.println(age + "_walk");
	}
}
