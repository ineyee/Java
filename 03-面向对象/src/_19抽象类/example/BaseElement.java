package _19抽象类.example;

import java.awt.Point;

/*
 * 作为父类，堆积子类重复的东西
 */
public abstract class BaseElement {
	public Point p1Point;
	public Point p2Point;
	
	public abstract void getVisibleArea();
}
