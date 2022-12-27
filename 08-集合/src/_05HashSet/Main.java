package _05HashSet;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		/*
		 * Set最大的特点就是无序，也就是说它里面存储的元素跟我们添加元素的顺序是不同的，
		 * 另外一个特点是元素不可重复，所以我们经常用Set来做数组的去重。
		 */
		Set<Integer> set = new HashSet<>();
		set.add(11);
		set.add(22);
		set.add(33);
		System.out.println(set); // [33, 22, 11]，而非[11, 22, 33]
	}
}
