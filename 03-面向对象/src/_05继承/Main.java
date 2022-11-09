package _05继承;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		person.age = 18;
		person.walk();
		
		Student student = new Student();
		student.age = 11;
		student.no = 9;
		student.study();
	}

}
