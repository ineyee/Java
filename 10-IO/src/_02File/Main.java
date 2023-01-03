package _02File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		test2();
	}
	
	public static void test() {
		/*
		 * 一、File
		 * 一个File对象就代表一个文件或者文件夹/目录
		 * 
		 * 1、在Unix、Linux、macOS下名字之间的分隔符推荐使用斜杠/，而在Windows下名字之间的分隔符推荐使用反斜杠\，但因为反斜杠会转义，所以需要写两个反斜杠才代表是\，
		 * 我们可以通过File.separator来获取名字分隔符来拼接File的路径，这样就不用根据平台来自己写万一搞错了
		 * 
		 * 2、在Unix、Linux、macOS下路径之间的分隔符推荐使用冒号:，而在Windows下名字之间的分隔符推荐使用分号;，这个玩意主要用在多个路径的拼接上，比如环境变量配置那个地方就用到了，
		 * 我们可以通过File.pathSeparator来获取路径分隔符，这样就不用根据平台来自己写万一搞错了
		 * 
		 * 3、在Windows、macOS下文件名、文件夹名/目录名是不区分大小的，Unix、Linux下则区分大小写
		 */
		File file1 = new File("F:/Files/Texts/test.txt");
		File file2 = new File("F:\\Files\\Texts");
		System.out.println(File.separator);
		
		String path1 = "users/yiyi/desktop:users/yiyi/desktop/test.txt";
		String path2 = "F:/Files/Texts/test.txt;F:\\Files\\Texts";
		System.out.println(File.pathSeparator);
	}
	
	public static void test2() throws IOException {
		/*
		 * 二、File的常用方法及属性
		 */
		// 用绝对路径创建的一个文件夹
		File file1 = new File("/users/yiyi/desktop/test");
		// 用绝对路径创建的一个文件
		File file2 = new File("/users/yiyi/desktop/test/test1.txt");
		// 用相对路径创建的一个文件夹（会从项目的根目录开始找，最前面不用加/或\\）
		File file3 = new File("res");
		// 用相对路径创建的一个文件
		File file4 = new File("res/1.txt");
		
		// 1、获取文件或文件夹的名字
//		System.out.println(file1.getName()); // test
//		System.out.println(file2.getName()); // test1.txt
//		System.out.println(file3.getName()); // res
//		System.out.println(file4.getName()); // 1.txt
		
		// 2、获取文件或文件夹的路径，你创建文件时写的是绝对路径就返回绝对路径，写的是相对路径就返回相对路径
//		System.out.println(file1.getPath()); // /users/yiyi/desktop/test
//		System.out.println(file2.getPath()); // /users/yiyi/desktop/test/test1.txt
//		System.out.println(file3.getPath()); // res
//		System.out.println(file4.getPath()); // res/1.txt
		
		// 3、获取文件或文件夹的上一级文件夹的File对象，4只是获取了这个File对象的路径
//		System.out.println(file1.getParentFile()); // /users/yiyi/desktop
//		System.out.println(file2.getParentFile()); // /users/yiyi/desktop/test
////		System.out.println(file3.getParentFile()); // null，如果你想获取一个相对路径的文件的ParentFile，那就必须先获取这个文件的绝对路径对应的File，直接获取是个null，这里是个坑
//		System.out.println(file3.getAbsoluteFile().getParentFile()); // res
//		System.out.println(file4.getParentFile()); // /users/yiyi/desktop
		
		// 4、获取文件或文件夹的上一级文件夹的路径
//		System.out.println(file1.getParent()); // /users/yiyi/desktop
//		System.out.println(file2.getParent()); // /users/yiyi/desktop/test
//		System.out.println(file3.getParent()); // null，同上
//		System.out.println(file4.getParent()); // /users/yiyi/desktop/test
		
		// 5、获取文件或文件夹的绝对路径
//		System.out.println(file1.getAbsolutePath()); // /users/yiyi/desktop/test
//		System.out.println(file2.getAbsolutePath()); // /users/yiyi/desktop/test/test1.txt
//		System.out.println(file3.getAbsolutePath()); // /Users/yiyi/Desktop/JavaProject/10-IO/res
//		System.out.println(file4.getAbsolutePath()); // /Users/yiyi/Desktop/JavaProject/10-IO/res/1.txt
		
		// 6、获取文件或文件夹的绝对路径对应的File对象
//		System.out.println(file1.getAbsoluteFile()); // /users/yiyi/desktop/test
//		System.out.println(file2.getAbsoluteFile()); // /users/yiyi/desktop/test/test1.txt
//		System.out.println(file3.getAbsoluteFile()); // /Users/yiyi/Desktop/JavaProject/10-IO/res
//		System.out.println(file4.getAbsoluteFile()); // /Users/yiyi/Desktop/JavaProject/10-IO/res/1.txt
		
		// 7、获取文件的大小，单位为字节bytes（注意文件夹没有大小，计算文件夹的大小只能遍历文件然后累加）
//		System.out.println(file1.length()); // 128
//		System.out.println(file3.length()); // 96
		
		// 8、文件或文件夹是否存在
//		System.err.println(file1.exists()); // true
//		System.err.println(file2.exists()); // true
//		System.err.println(file3.exists()); // true
//		System.err.println(file4.exists()); // true
		
		// 9、File是文件还是文件夹
//		System.out.println(file1.isFile()); // false
//		System.out.println(file2.isFile()); // true
//		System.out.println(file3.isDirectory()); // true
//		System.out.println(file4.isDirectory()); // false
		
		// 10、File是否可以读写
//		System.out.println(file1.canRead()); // true
//		System.out.println(file2.canRead()); // true
//		System.out.println(file3.canWrite()); // true
//		System.out.println(file4.canWrite()); // true
		
		// 11、获取当前文件夹里所有的文件和文件夹（不会去子文件夹里找），还可以过滤
//		File file = new File("/Users/yiyi/Desktop/JavaProject/10-IO");
//		String[] fileNames = file.list(); // 只会返回名字
//		File[] files = file.listFiles(); // 返回File对象
//		System.out.println(Arrays.toString(fileNames));
//		System.out.println(Arrays.toString(files)); 
//		
//		String[] filterFileNames = file.list(new FilenameFilter() {
//			@Override
//			public boolean accept(File file, String fileName) {
//				// 比方说我们只返回最后修改时间为xxx的文件和文件夹
//				return file.lastModified() > 100000000;
//			}
//		});
//		File[] filterFiles = file.listFiles(new FileFilter() {
//			@Override
//			public boolean accept(File file) {
//				// 比方说我们只返回最后修改时间为xxx的文件和文件夹
//				return file.lastModified() > 100000000;
//			}
//		});
//		System.out.println(Arrays.toString(filterFileNames));
//		System.out.println(Arrays.toString(filterFiles)); 
		
		// 12、创建文件夹（不存在才会创建，存在则不会创建）
//		file1.mkdir(); // 只会创建当前文件夹
//		file1.mkdirs(); // 除了会创建当前文件夹外，如果父文件夹不存在还会帮忙创建好父文件夹，比mkdir牛逼点
		
		// 13、创建文件（不存在才会创建，存在则不会创建）
//		file1.createNewFile();
		
		// 14、删除文件或空文件夹（如果文件夹里有东西则不会删除，注意不会放到回收站，直接就抹掉了，所以要慎重）
//		file2.delete();
	}
}
