package _01枚举;

/*
 * 跟很多其它语言一样，如果一个变量的取值只可能是固定的几个值，可以考虑使用枚举类型：
 * 
 * 1、Java里的枚举本质其实是一个类，类似于下面那样的类，所以枚举里除了可以定义常量，竟然还可以定义其它成员
 * 2、枚举由一组预定义的常量构成
 */
public enum Season {
	SPRING,
	SUMMER,
	AUTUMN,
	WINTER,
}

//public class Season {
//	// 构造方法私有化，不让外界实例化
//	private Season() {};
//	
//	// 提供几个预定义的常量
//	public static final Season SPRING = new Season();
//	public static final Season SUMMER = new Season();
//	public static final Season AUTUMN = new Season();
//	public static final Season WINTER = new Season();
//}

//public enum Season {
//	SPRING,
//	SUMMER,
//	AUTUMN,
//	WINTER; // 如果要定义其它成员，那这里就得是一个;
//	
//	int age;
//	String name;
//	static void test() {
//		System.out.println("Season - test");
//	};
//}

