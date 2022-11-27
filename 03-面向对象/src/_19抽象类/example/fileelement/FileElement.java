package _19抽象类.example.fileelement;

import _19抽象类.example.BaseElement;

/*
 * 1、作为父类，堆积子类重复的东西
 * 2、作为子类，只保留自己独有的东西
 */
public abstract class FileElement extends BaseElement {
	public String url;
	public abstract void upload();
}