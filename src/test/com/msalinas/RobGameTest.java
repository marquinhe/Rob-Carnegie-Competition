package test.com.msalinas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.msalinas.BoardGame.Orientation;
import com.msalinas.RoboGame;


/**
* Main test class for RoboGame accessors. 
* 
* @author  Marco Salinas
* @version 1.0
* @since   2015-07-12
*/


public class RobGameTest {
	
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
	public void place() {

		assertEquals(robo.getX(), 0);
		assertEquals(robo.getY(), 0);
		assertEquals(robo.getOrientation(), Orientation.NORTH);
		assertEquals(robo.isOntable(), true);
	}
	
	@Test
	public void move() {
		
		if (robo.isOntable())
		{
			robo.move(); 
			assertEquals(robo.getY(), 1);
			robo.right();
			robo.move(); 
			assertEquals(robo.getX(), 1);
			robo.right();
			robo.move(); 
			assertEquals(robo.getY(), 0);
			robo.right();
			robo.move(); 
			assertEquals(robo.getX(), 0);
		}
	}
	
	
	@Test
	public void notMove() {
		
		robo = new RoboGame(); 

		robo.move(); 
		assertEquals(robo.getY(), 0);
		robo.right();
		robo.move(); 
		assertEquals(robo.getX(), 0);
		robo.right();
		robo.move(); 
		assertEquals(robo.getY(), 0);
		robo.right();
		robo.move(); 
		assertEquals(robo.getX(), 0);

	}

	@Test
	public void rightMoveOnTable() {
		
		if (robo.isOntable())
		{
			robo.setOrientation(Orientation.NORTH);
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right();
			assertEquals(Orientation.EAST, robo.getOrientation());
			robo.right(); 
			assertEquals(Orientation.SOUTH, robo.getOrientation());
			robo.right(); 
			assertEquals(Orientation.WEST, robo.getOrientation());
		}
	}
	
	@Test
	public void rightMoveNotOnTable() {
		
		robo.setOnTable(false);
		
		if (robo.isOntable())
		{
			robo.setOrientation(Orientation.NORTH);
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right();
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right(); 
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right(); 
			assertEquals(Orientation.NORTH, robo.getOrientation());
		}
	}
	
	@Test
	public void leftMoveOnTable() {
		
		if (robo.isOntable())
		{
			robo.setOrientation(Orientation.NORTH);
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.left();
			assertEquals(Orientation.WEST, robo.getOrientation());
			robo.left(); 
			assertEquals(Orientation.SOUTH, robo.getOrientation());
			robo.left(); 
			assertEquals(Orientation.EAST, robo.getOrientation());
		}
	}
	
	@Test
	public void leftMoveNotOnTable() {
		
		robo.setOnTable(false);
		
		if (robo.isOntable())
		{
			robo.setOrientation(Orientation.NORTH);
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right();
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right(); 
			assertEquals(Orientation.NORTH, robo.getOrientation());
			robo.right(); 
			assertEquals(Orientation.NORTH, robo.getOrientation());
		}
	}
	
	@Test
	public void testToString() {
		
		assertEquals("0, 0, NORTH\n",robo.toString());
		robo.place(2, 2, Orientation.SOUTH);
		assertEquals("2, 2, SOUTH\n",robo.toString());
	}

}
