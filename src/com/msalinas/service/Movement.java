package com.msalinas.service;
import com.msalinas.BoardGame.Orientation;

/**
* Robot movements interface
*
* @author  Marco Salinas
* @version 1.0
* @since   2015-07-12
*/

public interface Movement {

	public void move();
	public void right(); 
	public void left(); 
	public void place(int x, int y, Orientation direction);
	
}
