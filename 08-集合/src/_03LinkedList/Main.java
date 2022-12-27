package _03LinkedList;

/*
 * 这节的视频对双向链表讲得很清晰，可以回看
 */
public class Main {
	public static void main(String[] args) {

	}

	public static void test() {
		/*
		 * LinkedList跟ArrayList的API及使用方法很像，但其实LinkedList是一个双向链表，而不是一个动态数组。
		 * 接下来我们对比一下两者的区别：
		 * 
		 * 1、查找元素的效率
		 * ArrayList：非常高，可以直接通过index精准定位到元素
		 * LinkedList：不如ArrayList，因为它总是通过next或者prev指针一个元素一个元素地找
		 * 
		 * 2、往尾部插入/删除元素的效率
		 * ArrayList、LinkedList：都很高且差不多，俩人都是一次性找到结束的位置
		 * 
		 * 3、往头部插入/删除元素的效率
		 * ArrayList：不如LinkedList，因为它需要先把所有的元素后移一波
		 * LinkedList：非常高，因为它有first能直接在第一位创建一个元素
		 * 
		 * 4、任意位置插入/删除元素的效率
		 * ArrayList、LinkedList：都很高且差不多，ArrayList要移，而LinkedList要找
		 * 
		 * 5、LinkedList频繁地删除和增加元素会导致频繁地申请和销毁堆内存，因为每一个节点都是一个对象，但它是用多少
		 * 申请多少，不浪费内存，而ArrayList虽然不会频繁申请和销毁堆内存，但可能会造成内存浪费
		 * 
		 * ArrayList的优势为：查找元素的效率非常高
		 * LinkedList的优势为：往头部插入/删除元素非常高
		 * 所以实际开发中，如果是查询操作比较多则优先选择ArrayList，增删操作比较多则优先选择LinkedList
		 */
	}
}
