package _07对象流;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 这个东西让它自动消除警告加上就可以了，作用可以先不关系，如果想了解的话可以再去看下视频
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	double height;
	Car car;
	
	@Override
	public String toString() {
		return "name:" + name + "\r\n" + "age:" + age + "\r\n"  + "height:" + height + "\r\n"  + "car:" + car + "\r\n";
	}
}
