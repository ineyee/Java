package _19抽象类.example.fileelement;

/*
 * 作为子类，只保留自己独有的东西
 */
public class PdfElement extends FileElement {
	@Override
	public void getVisibleArea() {
		System.out.println("我是PDF的可视区域");
	}

	@Override
	public void upload() {
		System.out.println("上传PDF");
	}
}