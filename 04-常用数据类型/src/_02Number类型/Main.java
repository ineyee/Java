package _02Number类型;

/*
 * 一提到数字我们立马就会想到基本数据类型，如byte、short、int、long、float、double，
 * 但基本数据类型有一个缺陷那就是它无法像引用类型那样表示null这个值。
 * 
 * 其实Java里已经内置了所有八种基本数据类型对应的包装类型，所谓包装类型就是指它们既可以是基本数据类型，也可以是null，
 * 也就是说变成了引用类型，这非常类似于OC里的NSNumber，但是注意int和Integer不是一个类型喔
 * 
 * byte-Byte：整型，占1个字节，取值范围[-128, 127]
 * short-Short：整型，占2个字节，取值范围[-32768, 32767]
 * int-Integer：整型，占4个字节，取值范围[-2^31, 2^31 - 1]，默认int类型
 * long-Long：整型，占8个字节，取值范围[-2^63, 2^63 - 1]
 *
 * float-Float：浮点型，占4个字节，取值范围[1.40E-45F, 3.4028235E38F]
 * double-Double：浮点型，占8个字节，取值范围[4.9E-324, 1.7976931348623157E308]，默认double类型
 *
 * char-Character：字符类型，占2个字节，存储单个Unicode字符
 * 
 * 而所有包装类型之间转数据类型也很好转，比如100.doubleValue，100.toString()等，系统给我们提供了这些方法，
 * 就不用我们去强转了
 */
public class Main {
	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		/*
		 * 比方说我们想定义一个数组，代表一家店周一到周五的收入 正数代表赚钱了 0代表不赚不赔 负数代表赔钱了 null代表没开门
		 */

		/*
		 * 那如果用基本数据类型的话，因为没有null，所以只好用0来表示没开门 但周二和周三就有歧义了，到底是没开门还是开门了但不赚不赔
		 * 这种场景下还是使用Number比较好
		 * 
		 * 由此可见，Java的数组里是可以存放基本数据类型，也可以存放null， OC里数组不能存放基本数据类型，存放nil更是会崩
		 */
		int[] income = { 100, 0, 0, -100, -200 };
		Integer[] income1 = { 100, null, 0, -100, -200 };
		for (Integer integer : income1) {
			System.out.println(integer);
		}
	}
	
	public static void test2() {
		/*
		 * Number类型的判等不推荐使用==、!=，而是推荐使用equals
		 * 
		 * 因为==、!=用于引用类型是判断它们的指针一样不一样，而equals才是判断它们内存存储的值一样不一样
		 */
		
		Integer num1 = 88;
		Integer num2 = 88;
		Integer num3 = 128;
		Integer num4 = 128;
	
		/*
		 * 这两个true都很好理解，因为num1和num2内存里存储的值都是88，num3和num4内存里存储的值都是888
		 */
		System.out.println(num1.equals(num2)); // true
		System.out.println(num3.equals(num4)); // true
		
		/*
		 * 一个true、一个false？很奇怪
		 * 先说num3和num4，虽然num3和num4内存里都存储的是128，但num3是个指针、num4也是个指针，它俩
		 * 分别指向了两个不同的对象，所以指针值是不同的，所以打印false是很正常的
		 * 
		 * 那同理啊，num1和num2也应该是这样的道理打印false才对，却怎么打印了true呢？没毛病，这样分析是对的，
		 * 但出问题的地方在于Integer这个类内部会缓存[-127, 128]这个范围的数字，系统认为我们会频繁使用这个范围
		 * 的数字，所以就帮我们缓存起来了，所以只要我们用到这个范围的数字，它都是从缓存中拿同一份内存地址存储的这个
		 * 数字，所以num1和num2的内存地址其实是一样的，也就返回了true
		 * 
		 * 这也是为什么Number类型的判等不推荐使用==、!=，而是推荐使用equals的原因
		 */
		System.out.println(num1 == num2); // true
		System.out.println(num3 == num4); // false
	}
	
	public static void test3() {
		/*
		 * 基本数据类型和Number类型之间可以直接赋值取值，因为编译器会自动帮我们做类型转化
		 */
		int num1 = 10;
		Integer num2 = num1;
		
		/*
		 * 但是基本数据类型的数组和Number类型的数组之间是不能直接搞的，编译器不管这种情况
		 */
		int[] arr1 = { 1, 2 };
//		Integer[] arr2 =  arr1; // 无法直接赋值，编译报错
	}
}
