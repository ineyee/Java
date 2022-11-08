/**
 * 07-方法
 * @author yiyi
 *
 */
public class Method {

	public static void main(String[] args) {
		/*
		 * 方法的书写格式跟其它语言差不多
		 * 
		 * 修饰符 方法的返回值类型 方法名(方法的参数列表) {
		 * 		方法的执行体
		 * }
 		 */
		方法的可变参数(11, 22);
	}
	
	private static void 其它一些知识点() {
		/*
		 * 1、跟OC不一样，Java里让null调用一个方法会报异常Exception，所以我们实际开发中写的代码将面临很多的判空
		 * 来增加代码的健壮性，当然这也是OC和Java没有空安全机制所面临的共同问题，只不过OC在nil调用方法没事而已
		 * 2、跟Swift和Dart不一样，Java里没有必选参数和可选参数之分，都是必选参数，而且不能给参数默认值
		 * 3、跟其它语言一样，Java里也可以写可变参数
		 */
	}
	
	private static int 方法的可变参数(int... agrs) {
		/*
		 * 如果参数的个数是不确定的，那我们可以用可变参数，但是一个函数只能有一个可变参数，并且可变参数必须是参数列表里的最后一个参数
		 */
		
		System.out.println(agrs); // [I@15db9742，可见可变参数其实变成了一个数组
		/*
		 * “[”：代表是一个数组
		 * “I”：代表数组里存储的数据类型
		 * “@15db9742”：是引用类型的哈希值，也是一个对象的唯一标识，Java里我们没办法获取一个对象的内存地址，所以就用哈希值吧
		 */
		
		int sum = 0;
		for (int num : agrs) {
			sum += num;
		}
		return sum;
	}
	
}
