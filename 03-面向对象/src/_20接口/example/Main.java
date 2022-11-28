package _20接口.example;

/*
 * 现在举这个么例子，来直观地理解理解接口是什么：
 * 
 * 【有个孩子想提高自己的成绩，于是想找个家教，他要求家教能教语文、数学和英语，于是他在网上发了个带此要求的招聘贴。】
 * 那这个场景抽象到代码的世界里，我们先搞到OC里，孩子不就是一个Child类嘛，招聘贴不就是一个TutorProtocol协议嘛，
 * 这个协议里有teachChinese、teachMath、teachEnglish三个必须实现的方法，对应到Java里，TutorProtocol协议
 * 只是换了个称呼叫Tutorable接口了，可见这个接口里的确是一系列抽象方法的集合，对应到面向对象里，这些方法就是一系列
 * 行为或者说能力的集合。
 * 
 * 【然后有个学生看到招聘贴了，来教了一段时间走了；又有个司机看到招聘贴了，来教了一段时间走了。】
 * 这个场景抽象到代码里，不就是Student类实现Tutorable接口，Driver实现Tutorable接口嘛。
 */
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		
		child.tutor = new Student();
		child.studyChinese();
		child.studyMath();
		child.studyEnglish();
		
		child.tutor = new Driver();
		child.studyChinese();
		child.studyMath();
		child.studyEnglish();
	}
}
