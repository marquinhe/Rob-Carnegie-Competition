import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.msalinas.RoboGame;
import com.msalinas.validation.ValidateInput;


/**
* The Robot class runs an application that 
* simulates a board of 5 x 5 squares where robot can be place and implements
* movement commands (place, move, right, left and report).
*
* @author  Marco Salinas
* @version 1.0
* @since   2015-07-12
*/



public class Play {

	private static final String PLACE 					= 	"PLACE";
	private static final String RIGHT 					= 	"RIGHT";
	private static final String LEFT 					= 	"LEFT";
	private static final String MOVE 					= 	"MOVE";
	private static final String REPORT 					= 	"REPORT";
	private static final String EXIT 					= 	"EXIT";
	private static final String VALID_COMMMAND_MESSAGE 	= 	"ENTER VALID COMMAND";

	public static void main(String[] args) {
		processArgs(args);
	}
	
	
private static void controller(String input, RoboGame robo) {
		
		ValidateInput validateInput = new ValidateInput(input, robo);

		if (input != null && validateInput.isValid()) {
			switch (validateInput.getCommand()) {
			case PLACE:
				robo.place(validateInput.getValidX(),
						validateInput.getValidY(),
						validateInput.getValidOrientation());
				break;
			case MOVE:
				robo.move();
				break;
			case RIGHT:
				robo.right();
				break;
			case LEFT:
				robo.left();
				break;
			case REPORT:
				System.out.println(robo.toString());
				break;
			default:
				System.out.println(VALID_COMMMAND_MESSAGE);
				break; 

			}

		}
		
	}
	

	static void processArgs(String[] args) {

		boolean keepRunning = true;
		if (args == null || args.length == 0) {
			Console console = System.console();

			if (console == null) {
				System.err
						.println("No console is available to accept input. Please run with argumenst for file input"
								+ "containing Robo-commands.");
				System.exit(1);
			}

			RoboGame robo = new RoboGame();
			System.out.println("Welcome to Robot Game,"
					+ "Place your Robot to start playing, exit to quit.");
			while (keepRunning) {
				String input = console.readLine();
				if (EXIT.equals(input.toUpperCase())) {
					keepRunning = false;
				} else {

					controller(input, robo);

				}
			}

		} else {
			System.out.println("Reading File: " + Arrays.toString(args));
			List<String> lines;
			
			try {
				File myFile = new File(args[0]);
				lines = Files.readAllLines(Paths.get( myFile.getAbsolutePath()),
						StandardCharsets.UTF_8);
				StringBuilder sb = new StringBuilder(1024);
				RoboGame robo = new RoboGame(); 
				for (String line : lines) {
					controller(line,robo);
				}
			} catch (IOException e) {
				System.out.println("Arrhhrg problem reading your file.. check your path.");
				//e.printStackTrace();
			}
		}
		System.exit(0);
	}

	


}
