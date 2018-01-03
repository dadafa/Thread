/**
 * 
 */
package com.xyd.pro;

/**
 * @author scott
 * @date 2017年12月25日下午5:57:20
 * @version 
 * @description 
 */
public class MovieApp {

	public static void main(String[] args) {
		
		Movie movie = new Movie();
		Player player = new Player(movie);
		Watcher watcher = new Watcher(movie);
		
		player.start();
		watcher.start();
		
	}
}
