package _04StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

	}
	
	public static void test() {
		/*
		 * 栈|_|：先进后出
		 */
		Stack<Integer> stack = new Stack<>();
		
		// push入栈
		stack.push(11);
		stack.push(22);
		stack.push(33);
		
		// pop出栈栈顶元素
		stack.pop();
		
		// peek拿到栈顶元素
		Integer num = stack.peek();
		
		// size返回栈的大小
		stack.size();
		
		// isEmpty判断栈是不是空的
		stack.isEmpty();
	}
	
	public static void test1() {
		/*
		 * 队列| |：先进先出，只允许尾部进头部出，不允许从中间增加和删除元素
		 */
		// LinkedList除了是个双向链表之外，也是一个队列，这就是因为队列的入队和出队元素都是在队头队尾操作的
		// 而LinkedList则刚好在头尾的操作是非常高效的，这也是为啥不选ArrayList来实现队列这个数据结构的原因
		Queue<Integer> queue = new LinkedList<>();
		
		// offer或add入队
		queue.offer(11);
		queue.offer(22);
		queue.add(33);
		
		// poll或remove出队
		queue.poll();
		
		// peek拿到队头元素
		Integer num = queue.peek();
		
		// size返回队列的大小
		queue.size();
		
		// isEmpty判断队列是不是空的
		queue.isEmpty();
	}
}
