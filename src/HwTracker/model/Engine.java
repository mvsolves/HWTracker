package HwTracker.model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Engine {

	public FileOperator fileOperator;
	public Schedule schedule;
	public int totalAssignments;

		public Engine() {
			fileOperator = new FileOperator();
			schedule = new Schedule();
			totalAssignments = 0;
		}

		public void date_Scheduler (String date) {
		}
		
		public int arranger (String course_Name) {
			return 0;
		}










		String getClass(Scanner sc) {
			System.out.print("Enter you class name with the following format (csc350): ");

			String myClass = sc.next();
			Pattern CLASS_PATTERN = Pattern.compile("^[a-z]{3}\\d{3}$");

			while (!myClass.equals("q")) {

				// Valid input
				if (myClass.matches(CLASS_PATTERN.toString())) {
					return myClass;
				}

				// Invalid input
				else {
					System.out.print("Incorrect pattern, please try again with the following format (csc350): ");
					myClass = sc.next();
				}
			}
			return "q";
		}










		String getAssignment(Scanner sc) {
			System.out.print("Enter assignment name: ");

			String myAssignment = sc.next();
			Pattern ASSIGN_PATTERN = Pattern.compile("^[a-z0-9\s]{5,30}");

			while (!myAssignment.equals("q")) {

				// Valid input
				if(myAssignment.matches(ASSIGN_PATTERN.toString())) {
					return myAssignment;
				}

				// Invalid input
				else {
					System.out.print("Range of characters must be between 5-30, please try again: ");
					myAssignment= sc.next();
				}
			}
			return "q";
		}










		String getDate(Scanner sc) {

			System.out.print("Enter the due date with following format (mm/dd/yyyy): ");
			String myDate = sc.next();

			Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
			while (!myDate.equals("q")) {

				// Valid input
				if(myDate.matches(DATE_PATTERN.toString())) {
					return myDate;
				}

				// Invalid input
				else {
					System.out.print("Incorrect pattern, please try again with the following format (mm/dd/yyyy): ");
					myDate = sc.next();
				}
			}
			return "q";
		}










		public void takeUserInputAndBuildFile() {

			System.out.println("\nEnter 'q' to quit at any time");

			Scanner sc = new Scanner(System.in).useDelimiter("\n");;

			String myClass = "";
			String myAssignment = "";
			String myDate = "";

			while (myClass != "q" || myAssignment != "q" || myDate != "q") {

				myClass = getClass(sc);
				if (myClass == "q") {
					myClass = "";
					myAssignment = "";
					myDate = "";
					break;
				}

				myAssignment = getAssignment(sc);
				if (myAssignment == "q") {
					myClass = "";
					myAssignment = "";
					myDate = "";
					break;
				}

				myDate= getDate(sc);
				if (myDate == "q") {
					myClass = "";
					myAssignment = "";
					myDate = "";
					break;
				}

				// Create new assignment object
				Assignment newAssign = new Assignment(myClass, myAssignment, myDate);

				// Append to list of assignments
				schedule.assignments.add(newAssign);

				totalAssignments++;
				System.out.println("\n");
			}

			System.out.println("\n*****************************************************");
			System.out.println("Total number of assignments entered was: " + totalAssignments);

			fileOperator.SaveToDisk(schedule.assignments);
			sc.close();
		}
}
