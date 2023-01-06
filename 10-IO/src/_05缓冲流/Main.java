package _05缓冲流;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 我们先来区分一下缓冲Buffer和缓存Cache：
		 * 1、是什么？缓冲，通常也叫缓冲区，它是程序内存的一部分，会根据我们的程序是要接受数据还是输出数据分为输入缓冲区和输出缓冲区。
		 * 2、为什么？所谓缓冲其实就是缓和冲击，假设没有做缓冲的话，比如我们1秒钟要读写100次磁盘，那对磁盘的冲击就很大，因为磁盘的
		 * 读写次数都是有上限的，很容易减短磁盘的使用寿命，此外频繁的开始读写和终止读写操作也会耗费CPU的性能，但是如果我们做了缓冲，
		 * 搞个缓冲区，我们总是先把数据放进缓冲区，等缓冲区满了之后再一次性地读写到磁盘里，这样就能很好地降低CPU的消耗，同时也可以
		 * 延长磁盘的使用寿命。
		 * 
		 * 1、是什么？缓存，它可以是程序内存的一部分，也可以是磁盘内存的一部分，比如SDWebImage的内存缓存和磁盘缓存。
		 * 2、为什么？假设没有做缓存的话，那用户请求一张图片就总是从网络获取，这必然会浪费很长的时间降低用户体验，又比如OC里的方法缓存列表，如果
		 * 没有缓存的话，每次调用一个方法都得从全部的方法列表里遍历一遍查找，这也必然会降低程序的执行效率，但是如果做了缓存，就可以把那些需要频繁读取
		 * 的东西给缓存起来，下次读取的时候就能很快地拿到了
		 * 
		 * 综上，我们可以看到缓冲和缓存要解决的问题是不一样的，它俩压根不是一个东西，缓冲更偏重于减少频繁读和写磁盘，而缓存更偏重于快速读取数据。
		 */

		/*
		 * 我们前面学习的字节流和字符流都是不带缓冲的IO流，也就是说每个read和write方法的调用都是直接调用操作系统底层API直接读写磁盘，
		 * 因此这就会存在我们上面所说的不做缓冲会存在的问题。于是Java提供了带缓冲的IO流————缓冲流（Buffered Streams）来提高读写数据的效率，
		 * 所以以后推荐使用经过缓冲流包装字节流和字符流，而不是直接使用不带缓冲的字节流和字符流，
		 * 也就是说缓冲流的read和write操作其实是在操作缓冲区，只有当缓冲区满了或者空了才会真正调用操作系统底层API————本地输入API（Native Input API）
		 * 和本地输出API（Native Output API）去读写磁盘。
		 * 
		 * 三、缓冲流（Buffered Streams）的特点：
		 * 1.1、缓冲输入流（BufferedInputStream/BufferedReader）：调用read方法是从缓冲区读取数据，并且只有当缓冲区为空时才调用本地输入API真正去磁盘读取数据
		 * 1.2、缓冲输出流（BufferedOutputStream/BufferedWriter）：调用write方法将数据写入缓冲区，并且只有当缓冲区已满时才调用本地输出API真正往磁盘写入数据
		 * 
		 * 2、BufferedInputStream和BufferedOutputStream就是带缓冲的字节流，对应于FileInputStream和FileOutputStream，其特点跟不带缓冲的字节流是一样的，都是一次性读取一个字节的二进制数据，
		 * 也是万能字节流，只不过读取操作是操作缓冲区而已
		 * 
		 * 3、BufferedReader和BufferedWriter就是带缓冲的字符流，对应于FileReader和FileWriter，其特点跟不带缓冲的字符流是一样的，都是一次性读取一个字符的二进制数据，也是只针对于文本文件，
		 * 只不过读取操作是操作缓冲区而已
		 * 
		 * 上述4个缓冲流的缓冲区大小都默认是8KB——8192个字节，当然我们可以通过构造方法自己指定缓冲区的大小。
		 */
		test();
	}
	
	/*
	 * 那缓冲流怎么使用呢？
	 * 
	 * 很简单，把不带缓冲的IO流传递给带缓冲的IO流的构造方法（即将不带缓冲的IO流包装成带缓冲的IO流），然后调用带缓冲IO流的read、write方法就可以了
	 */
	public static void test() throws IOException {    
		// 这是一个不带缓冲的字节输出流
		FileOutputStream fos = new FileOutputStream("/users/yiyi/desktop/456.txt", true);

		/*
		 * 我们创建一个带缓冲的字节输出流，把不带缓冲的字节输出流传进来
		 * 同时我们可以指定缓冲区的大小为10KB
		 */
		BufferedOutputStream bos = new BufferedOutputStream(fos, 1024 * 10);
		
		// 其它的操作跟不带缓冲的字节输出流是一样的
		bos.write(77);
		bos.write(74);
		
		/*
		 * 假如我们上面写满了10k个字节，那么write方法内部就会真正把缓冲区的数据写入到文件里
		 * 现在虽然上面没写够10k个字节，但是当我们调用close方法时，也会真正把缓冲区的数据写入到文件里，因为close方法内部会自动调用一次bos.flush()方法
		 * 你可以注释掉close方法试一下，上面两个字节的数据是不会写到文件里的，但是我们可以灵活地调用bos.flush()方法强制调用操作系统底层API把缓冲区的数据写入到磁盘里
		 */
		bos.close();
	}
}
