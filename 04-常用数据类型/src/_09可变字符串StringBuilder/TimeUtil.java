package _09可变字符串StringBuilder;

public class TimeUtil {
	@FunctionalInterface
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
