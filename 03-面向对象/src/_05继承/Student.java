package _05继承;

/*
 * Java里extends关键字来实现继承
 * Java有很多是抄OC的，类之间的继承也是单继承，但是可以通过接口（对应OC里的协议）来模拟多继承
 * 
 * 如果有人问你Java里支持多继承吗？你说类之间的继承是单继承，但是接口之间的继承是支持多继承的。
 */
public class Student extends Person {
	public int no;
	public void study() {
		System.out.println(age + "_" + no + "_study");
	}
}
