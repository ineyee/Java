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
}

//public abstract class Tutor {
//	public abstract void teachChinese();
//	public abstract void teachMath();
//	public abstract void teachEnglish();
//}