package _27匿名类.example2;

import _27匿名类.example2.NetworkUtil.Failure;
import _27匿名类.example2.NetworkUtil.Result;
import _27匿名类.example2.NetworkUtil.Success;
import _27匿名类.example2.TimeUtil.Block;

public class Main {

	public static void main(String[] args) {
		TimeUtil.calculate(new Block() {
			@Override
			public void putCodeIn() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(i);
				}
			}
		});
		
		NetworkUtil.get("https://xxx", new Result() {
			@Override
			public void successCallback(Object data) {
				// 通过回调顺利拿到请求成功的数据
				System.out.println(data);
			}
			
			@Override
			public void failureCallback(String errorMsg) {
				System.out.println(errorMsg);
			}
		});
		
		NetworkUtil.put("https://xxx", new Success() {
			@Override
			public void callback(Object data) {
				// 通过回调顺利拿到请求成功的数据
				System.out.println(data);
			}
		}, new Failure() {
			@Override
			public void callback(String errorMsg) {
				System.out.println(errorMsg);
			}
		});
	}

}
