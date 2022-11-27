package _19抽象类.example.graphicselement;

/*
 * 作为子类，只保留自己独有的东西
 */
public class RectangleElement extends GraphicsElement {
	public double width;
	public double height;
	
	@Override
	public void getVisibleArea() {
		System.out.println("我是矩形的可视区域");
	}
}
