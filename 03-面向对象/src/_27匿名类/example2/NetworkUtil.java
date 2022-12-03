package _27匿名类.example2;

/*
 * 举个回调的例子：
 * 1、假设我们想写一个工具类NetworkUtil，外界可以发送一个get请求，然后我们把请求成功
 * 或请求失败的结果通过回调给返回出去
 * 2、于是我们定义了一个方法get，这个方法的第一个参数是url，第二个参数就应该是请求成功
 * 的回调，第三个参数就应该是请求失败的回调，这可就为难了，在别的语言里我们直接传两个Function
 * 进来就ok了，但在Java里Function不是一等公民，没法直接传Function，所以只能传类，此处我们用匿名类就可以了
 * 3、一想到用匿名类，我们就会想到它仅仅是一个用大括号“{}”定义的一个没有名字的类，所以
 * 它必须得在定义的时候就实例化，而想实例化匿名类就得有一个接口或抽象类，因为匿名类实例
 * 化的写法为：
 * new 接口名()||抽象类名() {
 * 	// 在这个大括号里定义匿名类的属性和方法
 * }
 * 4、那我们搞一个接口还是抽象类呢？这种场景下建议用接口，因为这是传递一块代码嘛，哪需要
 * 什么继承体系嘛，于是我们就定义了一个名字叫Result的接口，因为外界在使用我们的工具类时：
 * NetworkUtil.get(url, result)
 * 读起来比较通顺，当然因为这个接口跟这个工具类紧密相关，而且这个接口不会被用在其它地方，
 * 所以我们就直接把这个接口定义在这个工具类内部了，没必要专门再开个文件去写这个接口
 * 5、然后怎么写呢？接口嘛，里面就是用来定义抽象方法的，所以我们就在Result接口里定义了两个
 * 方法successCallback和failureCallback，名字取得也很直白
 * 6、然后就可以把这个Result作为参数放进get的参数列表里了，此处也体现了匿名类的一个好处，即可以
 * 把多个相关的Function参数合并成一个匿名类参数
 * 7、然后外界使用的时候就可以把一个new Result() {}这种匿名类传递给result参数了，而这个
 * 匿名类必然会实现successCallback方法和failureCallback，那我们就可以通过这两方法把请求
 * 的结果通过这俩方法的参数给外界回调出去了，其实回调本质上也是代码传递，只不过单纯地代码传递就是
 * 接收一下外界传递进来的代码就行了，而回调除了接收外界传进来的代码之外，它的功能的侧重点更体现在
 * 要把数据再传递回给外界
 * 8、当然我们也可以像其他语言那样把请求结果拆分成多个接口来搞，比如下面的put请求，但是回调多的时候
 * 就不建议拆开了，不然方法列表就太长了，少的时候可以拆开
 */
public class NetworkUtil {
	public interface Result {
		void successCallback(Object data);
		void failureCallback(String errorMsg);
	}
	
	public interface Success {
		void callback(Object data);
	}
	
	public interface Failure {
		void callback(String errorMsg);
	}
	
	public static void get(String url, Result result) {
		// 假设发起了请求
		
		// 假设请求成功了
		result.successCallback("请求成功");
		
		// 假设请求失败了
		result.failureCallback("请求失败");
	}
	
	public static void put(String url, Success success, Failure failure) {
		// 假设发起了请求
		
		// 假设请求成功了
		success.callback("请求成功");
		
		// 假设请求失败了
		failure.callback("请求失败");
	}
}
