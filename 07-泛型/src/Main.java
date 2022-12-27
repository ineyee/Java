import java.util.List;

public class Main {
	public static void main(String[] args) {
		/*
		 * 什么是泛型？
		 * 
		 * 泛型的本质就是数据类型参数化，从而提高代码的复用率。
		 * 泛型可以存在于类、接口和方法中，分别称为泛型类、泛型接口、泛型方法。
		 */
		
		/*
		 * 建议的泛型名称为：
		 * T：Type
		 * E：Element
		 * K：Key
		 * V：Value
		 * N：Number
		 * S、U、V：2nd、3rd、4th types
		 */
		
		swapValue(10, 20);
		swapValue(30.1, 40.1);
		
		Student<Double> stu1 = new Student();
		stu1.score = 98.8;
		System.out.println(stu1.score);
		Student<String> stu2 = new Student();
		stu2.score = "A";
		System.out.println(stu2.score);
	}
	
	/*
	 * 一、泛型方法
	 */
//	public static void swapValue1(int num1, int num2) {
//		int temp = num1;
//		num1 = num2;
//		num2 = temp;
//		System.out.println(num1);
//		System.out.println(num2);
//	}
//	
//	public static void swapValue2(double num1, double num2) {
//		double temp = num1;
//		num1 = num2;
//		num2 = temp;
//		System.out.println(num1);
//		System.out.println(num2);
//	}
	
	// 泛型方法的<T>要写在方法的返回值前面，而不是方法名的后面
	public static <T> void swapValue(T num1, T num2) {
		T temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println(num1);
		System.out.println(num2);
	}
}

/*
 * 二、泛型类
 */
class Student<T> {
	public T score;
}

/*
 * 三、泛型接口
 */
interface Dao<T> {
	// 增
	void insert(T element);
	// 删
	void delete(T element);
	// 改
	void update(T element);
	// 查
	List<T> query();
}




