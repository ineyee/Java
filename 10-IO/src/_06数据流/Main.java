package _06数据流;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 四、数据流（Data Streams）：输入流为DataInputStream、输出流为DataOutputStream，
		 * 它主要用来读写基本数据类型和字符串到磁盘
		 */
		test();
		test1();
	}
	
	/*
	 * 输出流
	 */
	public static void test() throws IOException {
		/*
		 * 数据流其实也是个包装流，但它只能是字节流的包装流
		 */
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("/users/yiyi/desktop/123.txt"));
		
		/*
		 * 数据流提供了很多好用的方法，可以帮助我们直接写基本数据类型和字符串
		 * 只不过写进去的东西直接就是二进制数据，文本编译器打开也显示的二进制
		 */
		dos.writeBoolean(false);
		dos.writeInt(11);
		dos.writeDouble(11.12);
		dos.writeUTF("你好Hello");
		
		dos.close();
	}
	
	/*
	 * 输入流
	 */
	public static void test1() throws IOException {
		DataInputStream dim = new DataInputStream(new FileInputStream("/users/yiyi/desktop/123.txt"));
		System.out.println(dim.readBoolean());
		System.out.println(dim.readInt());
		System.out.println(dim.readDouble());
		System.out.println(dim.readUTF());
		dim.close();
	}
}
