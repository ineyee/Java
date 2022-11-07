/**
 * 04-数据类型转换
 * @author yiyi
 *
 */
public class TypeConversion {

	public static void main(String[] args) {
		基本数据类型和引用数据类型之间的数据类型转换();
	}
	
	static void 基本数据类型之间的数据类型转换() {
		/*
		 * 基本数据类型之间的数据类型转换，跟C语言里差不多：
		 * 
		 * 1、范围小的数据类型赋值给范围大的数据类型时会进行隐式转换；
		 * 2、范围大的数据类型赋值给范围小的数据类型时需要我们程序员强转，强转的方式也是在值的前面加上一个(数据类型)；
		 * 3、不同数据类型的值进行运算时编译器也会自动把它们隐式转换成范围大的数据类型再运算。
		 */
	}
	
	static void 基本数据类型和引用数据类型之间的数据类型转换() {
		// 1、int类型转字符串
		int age = 10;
		String ageString = String.valueOf(age);
		System.out.println(ageString);
		
		// 2、字符串转int类型
		int age1 = Integer.parseInt(ageString);
		System.out.println(age1);
	}

}
