package _07对象流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * 五、对象流（Object Streams）：输入流为ObjectInputStream、输出流为ObjectOutputStream
		 * 它主要用来读写引用类型到磁盘上的文件里，但是要求类必须实现Serializable接口，这个接口仅仅是一个标记接口，
		 * 不要求我们实现任何方法，仅仅是标记这个类可以被序列化
		 * 
		 * 就算是类的嵌套也是可以的，只要嵌套的那个类也实现了Serializable接口就行
		 * 
		 * 其实这个操作的专业术语就是对象的序列化与反序列化，所谓对象的序列化就是把一个对象转换成二进制数据（只有把对象序列化了，也就是把对象转换成二进制数据了，计算机
		 * 才能存储、也才能在网络上传输，存储和传输的都是二进制数据嘛），而对象的反序列化就是把一堆二进制数据还原成一个对象（从计算机上或者网络上接收到二进制后，反序列化回对象使用），
		 * 那这里首先要求一个类必须实现Serializable接口，就是标记这个类可被序列化和反序列化
		 * 其次怎么实现对象的序列化与反序列化呢？其实就是用ObjectOutputStream来做，反序列化就是用ObjectInputStream来做。
		 * 
		 * 当然通过序列化的方式把对象存储到文件里，这只适合存储一些小对象，大对象、大量数据就不适合了，因为这样做的效率其实会很差，所以实际开发中很少用这个、一般都是用数据库来存储。
		 */
		test();
		test1();
	}
	
	
	/*
	 * 输出流
	 */
	public static void test() throws IOException {
		/*
		 * 对象流其实也是个包装流，但它只能是字节流的包装流
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/users/yiyi/desktop/123.txt"));
		
		/*
		 * 数据流提供了可以帮助我们直接写对象的方法
		 */
		Car car = new Car();
		car.price = 20;
		
		Person person = new Person();
		person.name = "张三";
		person.age = 18;
		person.height = 1.8;
		person.car = car;
		
		oos.writeObject(person);
		
		oos.close();
	}
	
	/*
	 * 输入流
	 */
	public static void test1() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/users/yiyi/desktop/123.txt"));
		Person person = (Person)ois.readObject();
		System.out.println(person);
		ois.close();
	}
}
