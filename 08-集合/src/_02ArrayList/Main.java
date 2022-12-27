package _02ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		test2();
	}
	
	public static void test() {
		/*
		 * ArrayList类似于OC里的NSArray，Dart里的List，但ArrayList既能存储引用类型
		 * 的数据也能存储基本数据类型的数据，甚至连null都可以存储，同时这些数据也不一定非
		 * 要是同一种数据类型
		 */
		ArrayList arrayList = new ArrayList<>();
		// add方法增加一个元素
		arrayList.add(1);
		arrayList.add(3.14);
		arrayList.add(false);
		arrayList.add(null);
		// add到指定下标处，类似于insert
		arrayList.add(0, "hello");
		// size数组的大小
		System.out.println(arrayList.size());
		System.out.println(arrayList);
	}
	
	public static void test1() {
		/*
		 * 其实在实际开发中，我们一般会指定ArrayList内部要存储的内容，不让它啥都能存
		 * 
		 * 同时我们左边也一般不会直接写成ArrayList，而是用List，List是个接口，ArrayList等
		 * 很多List都实现了这个接口，所以左边如果写成List，将来如果我们右边想换一个List则直接
		 * 换下右边的东西就可以了，这就是面向接口编程。
		 */
//		ArrayList<Integer> arrayList = new ArrayList<>();
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		System.out.println(arrayList);
	}
	
	public static void test2() {
		/*
		 * ArrayList的遍历
		 */
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(11);
		arrayList.add(22);
		arrayList.add(33);
		
		// 1、经典遍历法
		int size = arrayList.size();
		for (int i = 0; i < size; i++) {
			// ArrayList都是面向对象的使用方法，不能再用[]了
//			Integer number = arrayList[i];
			Integer number = arrayList.get(i);
			System.out.println(number);
		}
		
		// 2、for-each遍历法
		for (Integer number : arrayList) {
			System.out.println(number);
		}
		
		// 3、迭代器遍历法
//		// 获取arrayList的迭代器，迭代器的泛型要跟ArrayList的泛型一样
//		Iterator<Integer> iterator = arrayList.iterator();
//		while (iterator.hasNext()) { // 如果还有下一个元素
//			Integer number = iterator.next(); // 则拿出下一个元素即可
//			System.out.println(number);
//		}

		// 如果我们想在遍历数组的时候删除元素，则必须得用迭代器遍历法，用上面那两种方法都会崩
		Iterator<Integer> iterator = arrayList.iterator();
		while (iterator.hasNext()) { // 如果还有下一个元素
			Integer number = iterator.next(); // 则拿出下一个元素即可
			if (number == 22) {
				iterator.remove();
			}
		}
		System.out.println(arrayList);
	}
}
