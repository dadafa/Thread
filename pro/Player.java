/**
 * 
 */
package com.xyd.pro;

/**
 * @author scott
 * @date 2017年12月25日下午5:43:12
 * @version 
 * @description  生产者
 */
public class Player extends Thread{

	private Movie movie;
	
	public Player(Movie movie) {
		this.movie = movie;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 20; i++) {
			
			if (i % 2== 0) {
				movie.play(" 米饭");
				
			}else {
				movie.play(" 馒头");
			}
			
		}
		
	}
}
