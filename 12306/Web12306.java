/**
 * 
 */
package com.xyd.sync;

/**
 * @author scott
 * @date 2017年12月25日下午3:05:16
 * @version
 * @description 模拟12306 抢票 看下多线程下面的数据安全问题
 * 
 *              票 :50 资源共享 Thread 能不能 实现 票 共享 会出现 资源访问 不安全问题
 * 
 *              synchronized修饰的代码同一时刻只能被一个线程所访问。
 * 
 */
public class Web12306 implements Runnable {
	
	StringBuilder sb;//  线程不安全    高效高 
	
	StringBuffer s;  //  安全  synchronized  线程  效率第

	private int num = 50;

	private boolean flag = true;

	@Override
	public void run() {

		while (flag) {
			test04();
		}

	}

	// 多线程 资源 同步资源 不安全 a b c
	private void test() {
		if (num < 0) { // 0 -1 -2
			flag = false;
			return;
		}
		try {
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Thread.currentThread().getName() 获取 线程 的名字
		System.out.println(Thread.currentThread().getName() + "抢到了 " + (num--));
	}

	// sync 直能 单个 线下 访问 这个 方法 a b c 实现 线程 安全
	// a 线线程 就进去了 b , c排队
	private synchronized void test01() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Thread.currentThread().getName() 获取 线程 的名字
		System.out.println(Thread.currentThread().getName() + "抢到了 " + (num--));
	}

	// 同步 代码块 实现 线程 安全问题
	private void test02() {
		// a 线线程 就进去了 b , c排队
		synchronized (Web12306.class) {
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Thread.currentThread().getName() 获取 线程 的名字
			System.out.println(Thread.currentThread().getName() + "抢到了 " + (num--));
		}
	}

	// 代码 块 同步 代码 过少
	private void test03() {

		if (num <= 0) {
			flag = false;
			return;
		}
		// num = 1 的时候 有 3个 线程 排队
		// a 线线程 就进去了 b , c排队
		synchronized (Web12306.class) {
			try {
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Thread.currentThread().getName() 获取 线程 的名字
			System.out.println(Thread.currentThread().getName() + "抢到了 " + (num--));
		}

	}

	// 同步资源    数据也不安全
	private void test04() {

		synchronized (Integer.valueOf(num)) {
			if (num <= 0) {
				flag = false;
				return;
			}
			// num = 1 的时候 有 3个 线程 排队
			// a 线线程 就进去了 b , c排队
		}
		//a b  num = 3
		try {
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Thread.currentThread().getName() 获取 线程 的名字
		System.out.println(Thread.currentThread().getName() + "抢到了 " + (num--));
	}

}
