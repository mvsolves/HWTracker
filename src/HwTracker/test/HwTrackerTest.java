package HwTracker.test;

import HwTracker.model.Engine;
import java.io.IOException;

public class HwTrackerTest {

	// Possible unit testing using asserts??
	/*
	public void testBasic() {
		Engine engine = new Engine();
	}
	*/

	public static void main(String[] args) throws IOException {
		Engine engine = new Engine();

		// This decides whether user input will be taken
		// OR
		// read from a pre-defined user input for testing purposes
		boolean readFromUserInput = false; // Change value to test out

		// Reading from pre-defined user input for testing purposes
		if (readFromUserInput == false) {
			System.out.println("-- TESTING MODE --");
			System.out.println("Reading from pre-defined user input for testing purposes..\n");
			engine.fileOperator.ReadInputTextFile();

			// Prints the assignments due in the given week/month
			/*
			@TODO
				- Implement user interaction with getting dates
				- Possibly add option for user to search assignments from custom range date
				- GUI??
			*/
			engine.fileOperator.schedule.printThisWeekAssignments();
			engine.fileOperator.schedule.printThisMonthAssignments();
		}

		// Read in user input from a real user
		else {
			System.out.println("-- USER MODE --");
			System.out.println("Reading input from real user..");
			engine.takeUserInputAndBuildFile();
		}
	}
}
