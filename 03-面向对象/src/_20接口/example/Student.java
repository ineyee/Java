package _20接口.example;

public class Student implements Tutorable {
	@Override
	public void teachChinese() {
		System.out.println("Student - teachChinese");
	}

	@Override
	public void teachMath() {
		System.out.println("Student - teachMath");
	}

	@Override
	public void teachEnglish() {
		System.out.println("Student - teachEnglish");
	}
}
