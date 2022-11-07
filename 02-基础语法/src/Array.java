/**
 * 06-数组
 * @author yiyi
 *
 */
public class Array {

	public static void main(String[] args) {
		/*
		 * 数组的类型为：T[]，T就是数组里存储的数据类型
		 * 数组的语法糖为：{}，不想其它语言里那样是[]
		 */
		定义一个数组();
		数组的遍历();
	}
	
	private static void 定义一个数组() {
		// 定义一个空数组
		int[] arr = {};
		System.out.println(arr.length);
		
		// 定义数组的时候指定元素
		int[] arr2 = { 11, 22, 33 };
		System.out.println(arr2[1]);
 	}
	
	private static void 数组的遍历() {
		int[] arr = { 11, 22, 33 };
		
		// for循环遍历法
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// for-:遍历法，类似于其它语言里的for-in，Java里叫for-each
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
