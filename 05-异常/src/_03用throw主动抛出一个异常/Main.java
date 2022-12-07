package _03用throw主动抛出一个异常;

public class Main {
	/*
	 * 前面说的异常都是系统自动抛出的，我们也可以用throw主动抛出一个异常。
	 */
	public static void main(String[] args) {
		try {
			double result =  div(20, 0);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 比方说我们定义了一个除法的函数，是num1 / num2，要求num2不能为0
	 * 
	 * 1、但如果我们仅仅是打印一下的，开发者可能不会注意，它可能还是会把num2传0进来
	 * 2、所以我们可以用throw主动抛出一个检查型异常，类似于其它语言里的断言，并且通过throws把这个异常抛给上层方法——也就是外界调用的地方，
	 * 这样外界在使用这个方法的时候就被抛检查型异常，那外界不处理的话编译就通不过，所以他们点进来一看就知道什么情况下会抛异常，从而在外面
	 * try-catch规避掉这种情况了，这样程序就不会崩了
	 */
	public static double div(double num1, double num2) throws Exception {
//		if (num2 == 0) {
//			System.out.println("num2不能为0");
//			return 0;
//		} else {
//			return num1 / num2;
//		}
		
		if (num2 == 0) {
			throw new Exception("num2不能为0");
		} else {
			return num1 / num2;
		}
	}
}
