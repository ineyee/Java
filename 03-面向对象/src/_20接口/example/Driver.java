package _20接口.example;

public class Driver implements Tutorable {
	@Override
	public void teachChinese() {
		System.out.println("Driver - teachEnglish");
	}

	@Override
	public void teachMath() {
		System.out.println("Driver - teachEnglish");
	}

	@Override
	public void teachEnglish() {
		System.out.println("Driver - teachEnglish");
	}
}
