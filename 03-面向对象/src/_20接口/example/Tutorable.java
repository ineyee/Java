package _20接口.example;

/*
 * 在代码的世界里，接口就是一系列抽象方法的集合
 * 这些抽象方法对应到面向对象的世界里，其实就是一些类行为或者能力的集合
 * 
 * 那你可能会想这里的接口Tutorable不是可以换成抽象类Totor吗？
 * 是的，在这个例子里，我们用接口和抽象类都可以。
 * 下一节我们会举另外的例子来说明接口和抽象类的区别，以及什么场景下使用接口、什么场景下使用抽象类。
 */
public interface Tutorable {
	public abstract void teachChinese();
	public abstract void teachMath();
	public abstract void teachEnglish();
	
	/*
	 * 接口升级问题
	 * 
	 * 所谓接口升级就是给接口增加新的方法。
	 * 
	 * 实际开发中我们肯定会遇到接口升级问题，比如项目第一期我们的接口里定义了一堆方法，然后又几百个类
	 * 都实现了这个接口————也就是几百个类都实现了这个接口里定义的抽象方法；那到了项目第二期的时候，这个
	 * 接口可能需要新增一些方法，这就是说所谓的接口升级。那接口升级会带来什么问题呢？那就是我们每往接口
	 * 里新增一个方法，就要在几百个类里面都实现一下新增的方法，这是一件非常恐怖的事情。那怎么避免接口升级
	 * 问题呢？那就是用default关键字修饰一下方法，并给方法提供一个默认实现就可以了，这样那些类就不是必须
	 * 得实现这个方法了，但是default关键字和abstract关键字是不能同时使用的，所以我们可以理解为abstract关键字
	 * 修饰的方法外界必须实现，default关键字修饰的方法外界可选实现（因为提供了默认实现嘛）。
	 */
	public default void teachSing() {};
}

//public abstract class Tutor {
//	public abstract void teachChinese();
//	public abstract void teachMath();
//	public abstract void teachEnglish();
//}