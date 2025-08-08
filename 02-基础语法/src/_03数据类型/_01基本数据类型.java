package _03数据类型;

import java.math.BigDecimal;

/*
	基本数据类型和其包装类的选择：
		* 在保证功能的前提下，优先选择基本数据类型，因为基本数据类型无需对象开销（无堆内存分配、无GC压力、无需拆箱装箱）
		* 当需要对象特性时，毫不犹豫使用包装类
	
	基本数据类型和BigDecimal的选择
		* 大多数情况下，我们的场景可能就是单纯地用一下这个数，所以对0.48999999999999994做一下四舍五入、再控制下小数的位数就可以了，可以用基本数据类型
		* 但是如果涉及到钱的计算，就一定要用BigDecimal
 */
public class _01基本数据类型 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	
	/*
		一、布尔类型
		Java里的布尔类型有两个：
			* 基本数据类型 boolean
			* 包装类型 Boolean，相当于 boolean + null
	*/
	public static void test1() {
		boolean v1 = true;
		System.out.println(v1); // true
		
		// 自动装箱操作
		Boolean v1Obj = v1;
		System.out.println(v1Obj); // true
		
		// 自动拆箱操作
		boolean v2 = v1Obj;
		System.out.println(v2); // true
		
		// 可以赋值为 null
		v1Obj = null;
		System.out.println(v1Obj); // null
	}

	/*
		二、整型（byte、short、int、long，这里以 int 为例）
		Java里的整型有两个：
			* 基本数据类型 int
			* 包装类型 Integer，相当于 int + null
	*/
	public static void test2() {
		int v11 = 10;
		System.out.println(v11); // 10
		
		// 自动装箱操作
		Integer v11Obj = v11;
		System.out.println(v11Obj); // 10
		
		// 自动拆箱操作
		int v22 = v11Obj;
		System.out.println(v22); // 10
		
		// 可以赋值为 null
		v11Obj = null;
		System.out.println(v11Obj); // null
	}
	
	/*
		三、浮点型（float、double，这里以 double 为例）
		Java里的整型有两个：
	 		* 基本数据类型 double
	 		* 包装类型 Double，相当于 double + null
	*/
	public static void test3() {
		double v111 = 3.14;
		System.out.println(v111); // 3.14
		
		// 自动装箱操作
		Double v111Obj = v111;
		System.out.println(v111Obj); // 3.14
		
		// 自动拆箱操作
		double v222 = v111Obj;
		System.out.println(v222); // 3.14
		
		// 可以赋值为 null
		v111Obj = null;
		System.out.println(v111Obj); // null
	}
	
	/*
		四、包装类判等
		包装类判等不能再使用==、!=，只能使用equals()方法
		因为==、!=用于引用类型是判断它们的指针一样不一样，而equals才是判断它们内存存储的值一样不一样
	 */
	public static void test4() {		
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
		 * 但出问题的地方在于Integer这个类内部会缓存[-127, 128]这个范围的数字对象，系统认为我们会频繁使用这个范围
		 * 的数字，所以就帮我们缓存起来了，所以只要我们用到这个范围的数字，它都是从缓存中拿同一份内存地址存储的这个
		 * 数字对象，所以num1和num2的内存地址其实是一样的，也就返回了true
		 */
		System.out.println(num1 == num2); // true
		System.out.println(num3 == num4); // false
	}
	
	/*
	 * 五、高精度计算BigDecimal
	 * 
	 * 1、首先我们要知道float和double都是有精度的，也就是说它们存储的都只是小数的近似值，并非准确值，
	 * 比如0.7这个小数，由于计算机只能存储0和1这种二进制的数据，所以他们设计计算机存储小数是这么存储的：
	 * 
	 * 先拿原数0.7 * 2 = 1.4，存储整数部分1
	 * 再拿余数0.4 * 2 = 0.8，存储整数部分0
	 * 再拿余数0.8 * 2 = 1.6，存储整数部分1
	 * 再拿余数0.6 * 2 = 1.2，存储整数部分1
	 * 再拿余数0.2 * 2 = 0.4，存储整数部分0
	 * 再拿余数0.4 * 2 = 0.8，存储整数部分0
	 * .....直到小数部分为0为止
	 * 
	 * 这样便会无限循环下去，也就说0.7这个小数在内存中存储的二进制是：0.101100110110110...一直110下去
	 * 但是float只有4个字节的存储空间，double只有8个字节的存储空间，不可能存储一个无限小数，所以它们就按
	 * 指定的精度来存储这个小数0.7了，但其实它们内存中存储的并不是真的0.7，因此如果我们拿这种数据去参与计算，
	 * 就很有可能会出现那个经典的错误：0.7 * 0.7 不等于 0.49，而是等于0.48999999999999994，也就是说其实
	 * 我们开发中遇到小数计算丢精度的问题其实不是运算带来的，而是小数的存储带来的、小数存储的时候已经丢精度
	 * 了（当然不是所有的小数存储是都会丢精度，有的小数转换成二进制是有限的，就可能不需要丢精度）
	 * 
	 * 2、BigDecimal，那怎么使用BigDecimal呢？
	 * 建议直接使用字符串来初始化BigDecimal，而不是用float或double来初始化它
	 */
	public static void test5() {
		// 金钱计算丢精度的问题
		double d1 = 0.7;
		double d2 = 0.7;		
		double d3 = d1 * d2;
		System.out.println(d3); // 不是0.49，而是0.48999999999999994
		
		/*
		 * 不建议用数值来初始化BigDecimal
		 * 
		 * 因为别看着你这写了个0.7，但它只是个字面量、你看着是0.7这个数而已，
		 * 编译器真正去初始化bd的时候，肯定还是用二进制来表示0.7这个小数的，
		 * 也就是向上面那样0.101100110110110...一直110下去，然后取个精度，
		 * 所以这样搞的话，初始化出来的bd其实已经不是0.7了
		 */
		BigDecimal bd = new BigDecimal(0.7);
		
		/*
		 * 建议用字符串来初始化BigDecimal
		 * 
		 * 因为BigDecimal并不是存储小数的，而是会把"0.7"这个字符串拆成"0"、"."、"7"
		 * 这三个字符单独存储，所以就不存在存储的时候丢精度的问题，只要存储不存在丢精度问题，
		 * 那运算就是小学数学了，计算机肯定能算对了
		 */
		BigDecimal bd1 = new BigDecimal("0.7");
		BigDecimal bd2 = new BigDecimal("0.7");
		// 计算时也是用BigDecimal的加减乘除、保留几位小数等方法来计算，而不是运算符
		System.out.println(bd1.add(bd2)); // 1.4
		System.out.println(bd1.subtract(bd2)); // 0.0
		System.out.println(bd1.multiply(bd2)); // 0.49
		System.out.println(bd1.divide(bd2)); // 1
		System.out.println(bd1.setScale(2)); // 0.70
	}
	
}
