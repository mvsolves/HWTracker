package HwTracker.model;

import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Schedule {
	public List<Assignment> assignments;

	private Reminder rem;
	private final Locale locale;
	private final ZoneId TZ;
	
	// Constructor
	public Schedule() {
		assignments = new ArrayList<Assignment>();
		TZ = ZoneId.of("America/New_York");
		locale = Locale.US;
		rem =  null;	
	}


	public void printThisWeekAssignments() {

		final DayOfWeek firstDayOfWeek = WeekFields.of(locale).getFirstDayOfWeek();
		final DayOfWeek lastDayOfWeek = DayOfWeek.of(((firstDayOfWeek.getValue() + 5) % DayOfWeek.values().length) + 1);

		LocalDate firstDate = LocalDate.now(TZ).with(TemporalAdjusters.previousOrSame(firstDayOfWeek));
		LocalDate lastDate = LocalDate.now(TZ).with(TemporalAdjusters.nextOrSame(lastDayOfWeek));

		System.out.println("\nAssignments due this week:");
		System.out.println("-------------------------");
		for (Assignment a : assignments) {

			if (a.dueDate.isAfter(firstDate) && a.dueDate.isBefore(lastDate)) {
				System.out.println(a.toString());
			}
		}
	}


	public void printThisMonthAssignments() {
		
		final LocalDate firstMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		final LocalDate lastMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

		System.out.println("\nAssignments due this month:");
		System.out.println("-------------------------");
		for (Assignment a : assignments) {

			if (a.dueDate.isAfter(firstMonth) && a.dueDate.isBefore(lastMonth)) {
				System.out.println(a.toString());
			}
		}
	}



	public void printAllAssignments() {
		for (Assignment a : this.assignments) {
			System.out.println(a.toString());
		}
	}
}
