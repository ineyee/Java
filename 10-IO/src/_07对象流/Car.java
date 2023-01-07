package _07对象流;

import java.io.Serializable;

public class Car implements Serializable {
	private static final long serialVersionUID = 1L;
	double price;
	
	@Override
	public String toString() {
		return "" + price;
	}
}
