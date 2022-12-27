package _06HashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		/*
		 * HashMap就类似于我们OC里的字典，Dart里的Map了
		 */
		Map<String, Object> map = new HashMap<>();
		map.put("Jack", 11);
		map.put("Rose", "22");
		map.put("Jim", 33.3);
		System.err.println(map);
		
		// 字典的遍历
		map.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
	}
}
