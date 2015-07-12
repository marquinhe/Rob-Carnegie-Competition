package test.com.msalinas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msalinas.RoboGame;
import com.msalinas.BoardGame.Orientation;
import com.msalinas.validation.ValidateInput;

public class ValidationTest {

	/**
	* Input validation test
	* 
	* @author  Marco Salinas
	* @version 1.0
	* @since   2015-07-12
	*/
	
	
private RoboGame robo = new RoboGame();
	
	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("Ini: " + System.currentTimeMillis());
	}

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("End: " + System.currentTimeMillis());
	}

	@Before
	public void setUp() {
		robo.place(0, 0, Orientation.NORTH);
	}

	@Test
	public void inputAfterPlace() {

		String input = "right";
		ValidateInput validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
		input = "left";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
		input = "move";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
		input = "report";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
		input = "place 1,1,SOUTH";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
	}
	
	@Test
	public void inputBeforePlace() {

		String input = "right";
		ValidateInput validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "left";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "move";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "report";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "place 1,1,SOUTH";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
		input = "place 1, 1, SOUTH";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), true);
		
	}
	
	
	@Test
	public void inputWrongCommands() {

		String input = "rigth";
		ValidateInput validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "mov3";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "place";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "place 1,1";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "place 1.1,1,EAST";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "place x,y";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
		input = "place 1,1,NORTEAST";
		validateInput = new ValidateInput(input, robo);
		assertEquals(validateInput.isValid(), false);
		
	}
	
	
	@Test
	public void ignoreInputBoardSize() {

		robo.place(0,5,Orientation.NORTH);
		assertEquals(robo.getY(), 0);
		
		robo.place(5,0,Orientation.NORTH);
		assertEquals(robo.getX(), 0);
		
		robo.place(0,4,Orientation.NORTH);
		robo.move(); 
		assertEquals(robo.getY(), 4);
		
		robo.place(4,0,Orientation.EAST);
		robo.move(); 
		assertEquals(robo.getX(), 4);
		
		robo.place(0,0,Orientation.SOUTH);
		robo.move(); 
		assertEquals(robo.getX(), 0);
		
		robo.place(0,0,Orientation.WEST);
		robo.move(); 
		assertEquals(robo.getX(), 0);
	}

}
