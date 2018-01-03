
/**
 * 
 */
package com.xyd.sync;

/**
 * @author scott
 * @date 2017年12月25日下午3:08:01
 * @version 
 * @description 
 */
public class WebApp {

	public static void main(String[] args) {
		
		Web12306 web12306 = new Web12306();
		
		Thread t1 = new Thread(web12306, "360");
		Thread t2 = new Thread(web12306, "12306");
		Thread t3= new Thread(web12306, "携程");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
