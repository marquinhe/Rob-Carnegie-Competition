package com.msalinas;

public  class BoardGame {

	int x;
	int y;
	boolean onTable; 
	
	public enum Orientation {
		NORTH, SOUTH, EAST, WEST 
	}; 
	
	Orientation orientation;

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setOnTable(boolean flag)
	{
		this.onTable = flag; 
	}
	
	public boolean isOntable(){
		return onTable; 
	}


}
