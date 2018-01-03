/**
 * 
 */
package com.xyd.pro;

/**
 * @author scott
 * @date 2017年12月25日下午5:38:12
 * @version 
 * @description   公共的资源   电影:
 * 
 *                2 个 线程 :  生产者           player
 *                  
 *                          消费者           watcher
 *                        
 *                   wait()  obj的方法     自己等待  让其他线程执行 
 *                        
 *                   notify() obj方法     通知其他线程  自己处于等待状态
 *                   
 *              结果: play 和  watch 交替执行 
 *                 
 */
public class Movie {
	
	//资源
	private String msg;
	
	//标记是否生产了 
	private boolean flag = true;

	/**
	 * 生产的方法
	 */
	public synchronized void play(String msg) {
		
		// 没有生产  消费中者 在消费
		if (!flag) {
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//模拟  生产要花费 时间 
		try {
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.msg = msg;
		//要生产 
		System.out.println("生产者 生产了 ..."+msg);
		
		//标记  标记 我生产完毕
		flag = false;
		this.notify(); //通知 消费者
	}
	
	/**
	 * 消费的方法
	 */
	public synchronized void  watch() { //消费 msg
		
		//消费者 等待   生产者 生产
		if (flag) {
			
			try {
				this.wait(); //消费者 等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//模拟消费的时间
		try {
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("消费者 消费了 ..."+msg);
		
		//消费  完毕   标记  
		this.flag = true;
		//生产者   生产  
		this.notify();
		
	}
}
