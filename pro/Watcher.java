/**
 * 
 */
package com.xyd.pro;

/**
 * @author scott
 * @date 2017年12月25日下午5:46:31
 * @version 
 * @description 消费者 
 */
public class Watcher extends Thread{

	private Movie movie;

	public Watcher(Movie movie) {
		this.movie = movie;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 20; i++) {
			movie.watch();
		}
	}
	
}
