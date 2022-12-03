package _27匿名类.example2;

/*
 * 举个单纯地代码传递的例子：
 * 1、假设我们想写一个工具类TimeUtil，来统计任意一段代码的执行时长
 * 2、于是我们定义了一个方法calculate，这个方法的参数就应该是外界传进来一块代码，
 * 这可就为难了，在别的语言里我们直接传一个Function进来就ok了，但在Java里Function
 * 不是一等公民，没法直接传Function，所以只能传类，此处我们用匿名类就可以了
 * 3、一想到用匿名类，我们就会想到它仅仅是一个用大括号“{}”定义的一个没有名字的类，所以
 * 它必须得在定义的时候就实例化，而想实例化匿名类就得有一个接口或抽象类，因为匿名类实例
 * 化的写法为：
 * new 接口名()||抽象类名() {
 * 	// 在这个大括号里定义匿名类的属性和方法
 * }
 * 4、那我们搞一个接口还是抽象类呢？这种场景下建议用接口，因为这是传递一块代码嘛，哪需要
 * 什么继承体系嘛，于是我们就定义了一个名字叫Block的接口，当然因为这个接口跟这个工具类紧
 * 密相关，而且这个接口不会被用在其它地方，所以我们就直接把这个接口定义在这个工具类内部了，
 * 没必要专门再开个文件去写这个接口
 * 5、然后怎么写呢？接口嘛，里面就是用来定义抽象方法的，所以我们先在Block接口里定义一个方
 * 法，这个方法就是用来接收外界传进来的任意代码块的，我们把这个方法叫做putCodeIn
 * 6、然后就可以把这个Block作为参数放进calculate的参数列表里了
 * 7、然后外界使用的时候就可以把一个new Block() {}这种匿名类传递给block参数了，而这个
 * 匿名类必然会实现putCodeIn方法，于是这就相当于外界把代码块挂在匿名类内部传递进来了
 */
public class TimeUtil {
	public interface Block {
		void putCodeIn();
	}
	
	public static void calculate(Block block) {
		long begin = System.currentTimeMillis();
		// 执行一下匿名类的方法，就相当于是执行外界的那块代码，因为这个方法里挂的就是外界传进来的代码块
		block.putCodeIn();
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "毫秒");		
	}
}
