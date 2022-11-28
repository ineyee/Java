package _20接口.example;

public class Child {
	/*
	 * 我们直接这么定义一个Tutorable就可以了，它就可以指向任何实现了该接口的类实例化出来的对象
	 * 这就像OC里Tutor<TutorProtocol>一样，
	 * 这样就不用切换Student和Driver了
	 */
	public Tutorable tutor;
	
	public void studyChinese() {
		tutor.teachChinese();
	}
	
	public void studyMath() {
		tutor.teachMath();
	}
	
	public void studyEnglish() {
		tutor.teachEnglish();
	}
}
