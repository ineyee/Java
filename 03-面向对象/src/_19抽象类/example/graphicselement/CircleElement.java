package _19抽象类.example.graphicselement;

/*
 * 作为子类，只保留自己独有的东西
 */
public class CircleElement extends GraphicsElement {
	public double radius;

	@Override
	public void getVisibleArea() {
		System.out.println("我是圆形的可视区域");
	}
}