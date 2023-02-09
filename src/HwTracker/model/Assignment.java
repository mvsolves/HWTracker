package HwTracker.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Assignment {
	
	public String course;
	public String item;
	public LocalDate dueDate;
		
	public Assignment(String course, String item, String month, String day, String year) {

		// Set course and item
		this.course = course;
		this.item = item;

		// Parse string date into int
		int d = Integer.parseInt(day);
		int m = Integer.parseInt(month);
		int y = Integer.parseInt(year);

		// Set date with int
		this.dueDate = LocalDate.of(y, m, d);
	}










	public Assignment(String course, String item, String date) {

		// Set course and item
		this.course = course;
		this.item = item;

		// Configure format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

		// Convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		this.dueDate = localDate;
	}










	@Override
	public String toString() {
		return String.format("Course name: %s%nAssignment title: %s%nDue date: %3$tB %3$td, %3$tY%n",
				this.course,
				this.item,
				this.dueDate);
	}

}
