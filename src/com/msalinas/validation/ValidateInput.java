package com.msalinas.validation;

import com.msalinas.RoboGame;
import com.msalinas.BoardGame.Orientation;


/**
* User input validation
* and business rules validation: Robot cant go off limits. 
*
* @author  Marco Salinas
* @version 1.0
* @since   2015-07-12
*/

public class ValidateInput {
	
	final static int MAX_WIDTH = 4;
	final static int MIN_WIDTH = 0;

	final static int MAX_HEIGHT = 4;
	final static int MIN_HEIGHT = 0;

	String tokens;
	String command; 
	int validX; 
	int validY; 
	Orientation validOrientation; 
	RoboGame robo; 
	
	public ValidateInput(String input, RoboGame robo) {
		tokens = input.toUpperCase(); 
		tokens = tokens.replaceFirst(" ", "_space_");
		tokens = tokens.trim();
		this.robo = robo; 
	}

	public boolean isValid() {
		
		String [] firstToken = tokens.split("_space_");
		if (firstToken != null && firstToken.length == 2){
			setCommand("PLACE");
			String coordinates[] = firstToken[1].split(",");
			if (coordinates != null && coordinates.length == 3){
				try {
					setValidX(Integer.parseInt(coordinates[0])); 
					setValidY(Integer.parseInt(coordinates[1])); 
					if (coordinatesInTable(coordinates) && isValidOrientation(coordinates[2]))
						{ 
							setValidOrientation(coordinates[2]);
							return true; 
						}
					
					return false;
				}catch(Exception e){
					return false; 
				}
			}else
			{
				return false; 
			}
			
		}else if (firstToken[0].equals("MOVE")) {
			
			setCommand(firstToken[0]);
			return isValidMove(robo);
			
		}else if (firstToken != null && 
				(firstToken[0].equals("RIGHT") || firstToken[0].equals("LEFT") || firstToken[0].equals("REPORT"))){
			setCommand(firstToken[0]);
			return true; 
		}else {
			return false;
		}
	}


	private boolean isValidMove(RoboGame robo) {

		Orientation currentFace = robo.getOrientation();
		int currentX = robo.getX();
		int currentY = robo.getY();

		if (currentFace != null) {
			switch (currentFace) {
			case NORTH:
				if (currentY == MAX_HEIGHT)
					return false;
				break;
			case SOUTH:
				if (currentY == MIN_HEIGHT)
					return false;
				break;
			case EAST:
				if (currentX == MAX_WIDTH)
					return false;
				break;
			case WEST:
				if (currentX == MIN_WIDTH)
					return false;
				break;
			}

			return true;
		} else {
			return false;
		}
	}

	private boolean coordinatesInTable(String[] coordinates) {
		int x = Integer.parseInt(coordinates[0]); 
		int y = Integer.parseInt(coordinates[1]); 
		
		if (x >= MIN_WIDTH && x <= MAX_WIDTH && y >= MIN_HEIGHT && y <= MAX_HEIGHT){
			return true;
		}
		return false;
	}

	public String getCommand(){
		return command; 
	}
	
	public void setCommand(String command) {
		this.command = command;
	}

	public int getValidX() {
		return validX;
	}
	
	public void setValidX(int validX) {
			this.validX = validX;
	}
	
	public void setValidY(int validY) {
		this.validY = validY;
	}

	public int getValidY() {
		return validY;
	}

	public Orientation getValidOrientation() {
		return validOrientation;
	}

	public void setValidOrientation(String orientation) {
		this.validOrientation = Orientation.NORTH;
		if (orientation.equals("SOUTH"))
			this.validOrientation = Orientation.SOUTH;
		if (orientation.equals("EAST"))
			this.validOrientation = Orientation.EAST;
		if (orientation.equals("WEST"))
			this.validOrientation = Orientation.WEST;

	}
	
	private boolean isValidOrientation(String orientation) {
		return orientation.equals("NORTH")
				|| orientation.equals("SOUTH")
				|| orientation.equals("EAST")
				|| orientation.equals("WEST");
	}
	
	

}


