package _01IO流的概念;

public class Main {
	/*
	 * 一、IO流
	 * IO流全称Input/Output Stream，译为输入输出流。
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
	 * 1、字节流（Byte Streams）：所谓字节流是指一个字节一个字节的输入或输出，输入流为InputStream、输出流为OutputStream
	 * 2、字符流（Character Streams）：所谓字节流是指一个字符一个字符一的输入或输出，输入流为Reader、输出流为Writer
	 * 3、缓冲留（Buffered Streams）：输入流为BufferedInputStream/BufferedReader、输出流为BufferedOutputStream/BufferedWriter
	 * 4、数据流（Data Streams）：输入流为DataInputStream、输出流为DataOutputStream
	 * 5、对象流（Object Streams）：输入流为ObjectInputStream、输出流为ObjectOutputStream
	 */
}