package com.msalinas;

import com.msalinas.service.Movement;

/**
* The RobotGame class extend a regular boardBame and implements 
* robot movements.
*
* @author  Marco Salinas
* @version 1.0
* @since   2015-07-12
*/


public class RoboGame extends BoardGame implements Movement{

	
	@Override
	public void move() {

		if (isOntable()) {
			switch (getOrientation()) {
			case NORTH:
				setY(getY() + 1);
				break;
			case WEST:
				setX(getX() - 1);
				break;
			case EAST:
				setX(getX() + 1);
				break;
			case SOUTH:
				setY(getY() - 1);
				break;
			}
		}
	}

	@Override
	public void right() {

		if (isOntable()) {
			switch (getOrientation()) {
			case NORTH:
				this.setOrientation(Orientation.EAST);
				break;
			case WEST:
				this.setOrientation(Orientation.NORTH);
				break;
			case EAST:
				this.setOrientation(Orientation.SOUTH);
				break;
			case SOUTH:
				this.setOrientation(Orientation.WEST);
				break;
			default:
				System.out.println("Invalid orientation");
				break;

			}
		}
	}

	@Override
	public void left() {

		if (isOntable()) {
			switch (getOrientation()) {
			case NORTH:
				setOrientation(Orientation.WEST);
				break;
			case WEST:
				setOrientation(Orientation.SOUTH);
				break;
			case EAST:
				setOrientation(Orientation.NORTH);
				break;
			case SOUTH:
				setOrientation(Orientation.EAST);
				break;
			default:
				System.out.println("Invalid orientation");
				break;
			}
		}
	}

	@Override
	public void place(int x, int y, Orientation direction) {
		setX(x);
		setY(y);
		setOrientation(direction);
		setOnTable(true);
	}
	
	
	@Override
	public String toString() {
	
		if (isOntable()) {
			return getX() + ", " + getY() + ", " + getOrientation()+"\n";
		} else {
			return "Place robot on table";
		}
	}

}
