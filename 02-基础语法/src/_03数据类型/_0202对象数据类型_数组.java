package _03数据类型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class _0202对象数据类型_数组 {

	public static void main(String[] args) {
		test();
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
	}
	
	/*
	 * 1、数组的声明及初始化
	 * 
	 * ArrayList类似于OC里的NSMutableArray
	 */
	public static void test() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		System.out.println(arrayList); // []
		System.out.println(arrayList1); // [1, 2, 3]
	}
	
	/*
	 * 2、获取数组的长度
	 */
	public static void test1() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		System.out.println(arrayList.size()); // 3
	}
	
	/*
	 * 3、判断数组是不是空
	 */
	public static void test2() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		System.out.println(arrayList.isEmpty()); // true
		System.out.println(arrayList1.isEmpty()); // false
	}
	
	/*
	 * 4、数组增
	 */
	public static void test3() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		
		// （1）尾部增
		arrayList.add(4); // 单增
		arrayList.addAll(Arrays.asList(5, 6, 7)); // 批量增
		System.out.println(arrayList); // [1, 2, 3, 4, 5, 6, 7]
		
		// （2）头部增、中间增
		arrayList.add(0, 0); // 单增
		arrayList.addAll(0, Arrays.asList(-3, -2, -1)); // 批量增
		arrayList.add(5, 15); // 单增
		arrayList.addAll(11, Arrays.asList(61, 62, 63)); // 批量增
		System.out.println(arrayList); // [-3, -2, -1, 0, 1, 15, 2, 3, 4, 5, 6, 61, 62, 63, 7]
	}
	
	/*
	 * 5、数组删
	 */
	public static void test4() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		
		// （1）删除某个下标处的元素
		arrayList.remove(1);
		System.out.println(arrayList); // [1, 3]
		
		// （2）删除某个元素
		arrayList.remove(Integer.valueOf(3));
		System.out.println(arrayList); // [1]
		
		arrayList.addAll(Arrays.asList(2, 3, 4));
		// （3）批量删除元素
		arrayList.removeAll(Arrays.asList(2, 4));
		System.out.println(arrayList); // [1, 3]
		
		// （4）清空数组
		arrayList.clear();
		System.out.println(arrayList); // []
	}
	
	/*
	 * 6、数组改
	 */
	public static void test5() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));		
		arrayList.set(1, 222);
		System.out.println(arrayList); // [1, 222, 3]
	}
	
	/*
	 * 7、数组查
	 */
	public static void test6() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));	
		
		// （1）查某个下标处的元素
		System.out.println(arrayList.get(0)); // 1
		
		// （2）查某个元素的下标
		System.out.println(arrayList.indexOf(1)); // 0
		
		// （3）数组里是否包含某个元素
		System.out.println(arrayList.contains(1)); // true
		
		// （4）截取子数组（前闭后开）
		System.out.println(arrayList.subList(0, 2)); // [1, 2]		
	}
	
	/*
	 * 8、数组的遍历
	 */
	public static void test7() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		
		// （1）普通for循环遍历法
		for (int i = 0; i < arrayList.size(); i++) {
			Integer number = arrayList.get(i);
			System.out.println(number);
		}
		
		// （2）for-each 遍历法
		for (Integer i : arrayList) {
			Integer number = i;
			System.out.println(number);
		}
		
		arrayList.forEach((item) -> {
			System.out.println(item);
		});
		
		// （3）迭代器遍历法
		// 获取arrayList的迭代器，迭代器的泛型要跟ArrayList的泛型一样
		Iterator<Integer> iterator = arrayList.iterator();
		while (iterator.hasNext()) { // 如果还有下一个元素
			Integer number = iterator.next(); // 则拿出下一个元素即可
			System.out.println(number);
			
			// 如果我们想在遍历数组的时候删除元素，则必须得用迭代器遍历法，用上面那两种方法都会崩
			if (number == 2) {
				iterator.remove(); // 用iterator的remove方法删掉 2
			}
		}
		System.out.println(arrayList); // [1, 3]
	}
	
	/*
	 * 9、数组的反转和排序
	 */
	public static void test8() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(24, 8, 10, 2, 16));	
		
		// 反转，不会影响原数组，返回一个翻转后的新数组
		ArrayList<Integer> reversedArrayList = new ArrayList<Integer>(arrayList.reversed());
		System.out.println(arrayList); // [24, 8, 10, 2, 16]
		System.out.println(reversedArrayList); // [16, 2, 10, 8, 24]
		
		// 排序，会影响原数组，没有返回值
		arrayList.sort((item1, item2) -> {
			return item1 - item2;
		});
		System.out.println(arrayList); // [2, 8, 10, 16, 24]
	}
		
}
