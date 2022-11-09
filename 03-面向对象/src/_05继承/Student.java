package _05继承;

/*
 * Java里extends关键字来实现继承
 */
public class Student extends Person {
	public int no;
	public void study() {
		System.out.println(age + "_" + no + "_study");
	}
}
