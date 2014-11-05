//Name: William Fairgrieve
//Class: ICS3U Computer Science
//Assigment 8 - Question 2
//Date: October 30 2014
//Import everything in java.io
import java.io.*;

public class William_A8Q2 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		// Declare arrays for days of week and 2D array for calender days
		String[] daysOfWk = { "S", "M", "T", "W", "T", "F", "S" };
		String[] daysOfWeek = { "sun", "mon", "tue", "wed", "thur", "fri","sat" };
		String[][] cal = new String[6][7];
		
		int firstDay;
		
		// Get day of week for first day and number of days in the month
		System.out.print("Day of the week of the first day:");
		String firstDayStr = stdin.readLine();
		System.out.print("Number of Days in the month:");
		int numOfDays = Integer.parseInt(stdin.readLine());
		
		
		// Convert name of first day into number
		for (int i = 0; i < daysOfWk.length; i++) {
			if (daysOfWk[i].equalsIgnoreCase(firstDayStr)|| daysOfWeek[i].equalsIgnoreCase(firstDayStr)) {
			}
		}

		//Set all positions in 2D array to a dash as a default
		for (int i = 0; i < cal.length; i++) {
			for (int n = 0; n < cal[0].length; n++) {
				cal[i][n] = "--";
			}
		}
		// For loop to put letters for days in first row
		for (int i = 0; i < cal[0].length; i++) {
			cal[0][i] = daysOfWk[i];
		}
		
		
		//Nested for loops to enter days of month into 2D array
		int days = 1;
		
		for(int i = 1;i < cal.length;i++){
			for(int n = 0;n < cal[0].length && days <= numOfDays;n++){
				cal[i][n] = Integer.toString(days);
				days++;
			}
		}

		// Nested for loop to print out contents of 2D array
		for (int i = 0; i < cal.length; i++) {
			for (int n = 0; n < cal[0].length; n++) {
				System.out.print(cal[i][n] + " ");
			}
			System.out.println();
		}

	}// End of main method
}// End of class
