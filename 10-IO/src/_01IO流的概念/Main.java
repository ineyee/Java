package _01IO流的概念;

public class Main {
	/*
	 * 一、IO流
	 * IO流全称Input/Output Stream，译为输入输出流。首先要知道IO流读取和写入的绝对都是0101这样的二进制数据，
	 * 它不关心你这个二进制数据是文本encode的，还是图片文件、mp3文件、mp4文件encode的，反正它的作用就是读取和写入二进制，
	 * 至于二进制的encode和decode不是它关心的事。
	 * 
	 * 我们的Java应用程序    ---010101010101--->    文件、设备（屏幕）等
	 * 如果我们想在Java应用程序里把数据写入到文件或者设备，那么就得用输出流Output Stream
	 * 
	 * 我们的Java应用程序    <---010101010101---    文件、设备（屏幕）等
	 * 如果我们想在Java应用程序里把数据从文件或者设备读取到项目里，那么就得用输入流Input Stream
	 * 
	 * 也就是说用输入流还是输出流是相对于我们的Java应用程序来说的，Java应用程序想对外输出数据那就用输出流，
	 * Java应用程序想从外读取数据那就用输入流。
	 * 
	 * 注意IO流读写的数据都直接是二进制喔，比如写入的时候只能是写入一个二进制的77和74，那其实真实
	 * 写入的是大写字母M和J，但是我们不能直接写入大写字母M和J。
	 */
	
	/*
	 * 二、常用的IO流都在java.io包中
	 * 1、字节流（Byte Streams）：所谓字节流是指一次性读取一个字节的二进制数据，输入流为InputStream、输出流为OutputStream，
	 * 它是个万能文件流，主要用来读写文本文件、图片文件、MP3文件、MP4文件等各种文件到磁盘上的文件里
	 * 2、字符流（Character Streams）：所谓字节流是指一次性读取一个字符的二进制数据，输入流为Reader、输出流为Writer，
	 * 它是个文本流，只能用来读写文本文件到磁盘上的文件里
	 * 3、缓冲留（Buffered Streams）：输入流为BufferedInputStream/BufferedReader、输出流为BufferedOutputStream/BufferedWriter，
	 * 它其实是字节流和字符流的包装流，我们更推荐使用缓冲流
	 * 4、数据流（Data Streams）：输入流为DataInputStream、输出流为DataOutputStream，
	 * 它主要用来读写基本数据类型和字符串到磁盘上的文件里
	 * 5、对象流（Object Streams）：输入流为ObjectInputStream、输出流为ObjectOutputStream
	 * 它主要用来读写引用类型到磁盘上的文件里，但是要求类必须实现Serializable接口
	 */
}