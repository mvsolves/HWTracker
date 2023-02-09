package HwTracker.model;

import java.util.ArrayList;

@SuppressWarnings("unused") // REMOVE THIS after implementing more functionality
public class Reminder {
	private ArrayList<Assignment> toPrint;
	private int dateRange;
	
	Reminder(int rangeInDays) {
		dateRange = rangeInDays;
		toPrint = null;
	}
}
