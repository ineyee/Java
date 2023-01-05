package _04字符流;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 二、字符流（Character Streams）的特点：
		 * 1、一次只读写一个字符的二进制数据（比如一个英文字符“M”在UTF-8编码下占用一个字节，那这一次字符流就只会读取一个字节的数据，而
		 * 一个汉字“你”在UTF-8编码下占用三个字节，那这一次字符流就会读取三个字节的数据)
		 * 2、输入流最终都继承自Reader（要把数据读到程序里嘛，当然就是用FileReader）、输出流最终都继承自Writer（要把数据从程序输出嘛，当然就是用FileWriter）
		 * 3、常用的字符流有FileReader、FileWriter，这一看就是跟文件操作有关的（需要注意的是这两个类只适合处理文本文件，比如.txt里存储的文本、.java里存储的代码等这类文本文件，
		 * 因为它是以字符为单位来处理数据的嘛，你图片、mp3、mp4等文件的二进制的数据又不是什么UTF-8编码encode出来的二进制，那要用字符流处理肯定数据就错乱了，前面讲的字节流则是一
		 * 个万能流，文本、图片、mp3、mp4等文件都可以搞)
		 */
		test1();
		test2();
	}
	
	/*
	 * 文本文件输出流FileWriter
	 */
	public static void test1() throws IOException {
		/*
		 * 我们要往一个文件里写数据，那数据相对于我们的程序来说是输出出去了，所以得用输出流FileWriter
		 * 给定文件的路径
		 * 如果我们是要往文件里追加内容而非覆盖文件的内容，则把后面的append传个true即可，覆盖直接不写就行
		 */                    
		FileWriter fw = new FileWriter("/users/yiyi/desktop/123.txt");
		
		/*
		 * 既然是字符流，我们就可以直接write字符了
		 * 需要注意的是任何流的底层读写数据肯定都是二进制，只不过这里的FileWriter类提供的API可以帮助我们直接写字符而已，
		 * 这些API内部肯定会自己做转换的，千万不要以为字符流就是直接写入和读取字符的，字符流的定义是一次性读取或写入一个字符的二进制数据
		 * 
		 * 当然它也有别的API可以直接写二进制数据
		 */
		fw.write("M");
		fw.write("J");
		fw.write(77);
		fw.write(74);
		
		/*
		 * 当然我们也可以直接写一个字符数组进去，即多个字符一次性写进去
		 * 直接写一个字符串进去，底层调用地就是写一个字符数组进去，所以也是可以的
		 */
		char[] chars = "你好".toCharArray();
		fw.write(chars);
		fw.write("Hello");
		fw.write(20320);
		
		/*
		 * 写完东西后，记得关闭一下输出流
		 */
		fw.close();
	}
	
	/*
	 * 文本文件输入流FileReader
	 */
	public static void test2() throws IOException {
		/*
		 * 我们要从一个文件里读数据，那数据相对于我们的程序来说是输入进来了，所以得用输入流
		 * 给定文件的路径
		 */                    
		FileReader fr = new FileReader("/users/yiyi/desktop/123.txt");
		
		/*
		 * 我们的文本文件里存储的是：MJ你好Hello，所以：
		 * 1、char1：读取一个字符的数据，再次强调需要注意的是字符流是指按一个字符一个字符读取的，而不是指
		 * 读取和写入直接就是字符，只不过刚好FileWriter提供的API可以直接写入字符而已，读取和写入字符
		 * 都还是二进制，只不过这些二进制是一个字符一个字符的数据，所以此处读出来的是这个字符对应的数据，
		 * 但需要注意的是这个数据不直接是字符，而是这个字符对应的二进制数据，我们得通过(char)强转decode成字符
		 * 2、char2：同理
		 * 3、char3：同理
		 */
		int char1 = fr.read();
		System.out.println(char1); // 77，因为M在UTF-8编码下M只占一个字节
		System.out.println((char)char1); // M
		int char2 = fr.read();
		System.out.println(char2); // 74，因为M在UTF-8编码下J只占一个字节
		System.out.println((char)char1); // J
		int char3 = fr.read();
		System.out.println(char3); // 20320，因为M在UTF-8编码下你占三个字节
		System.out.println((char)char3); // 你
		
		/*
		 * 当然我们也可以一次性多读一些字符出来
		 * 创建一个能装100个字符的数组，尝试读取100个字符的东西存到这个数组里，如果超过100个字符则只读取100个字符，如果不够100个字符则全部读取出来然后数组空着剩余的字符
		 */
		char[] chars = new char[100];
		int len = fr.read(chars);
		System.out.println("真正读取到的字符个数：" + len);
		
		/*
		 * 因为我们知道存储的是字符串，所以直接把二进制数据decode成字符串
		 * 但直接使用String(chars)转的话，可能100个字符里有空的东西
		 * 所以我们可以指定把数组里那些字符转成字符串：chars数组，从第0位（注意这个数是位不是字符）开始，一共len个字符，采用"UTF-8"编码，decode
		 */
//		String string = new String(chars);
		String string = new String(chars, 0, len);
		System.out.println("读取到的字符串：" + string);
		
		/*
		 * 读完东西后，记得关闭一下输入流
		 */
		fr.close();
	}
}
