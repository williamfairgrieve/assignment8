//Name: William Fairgrieve
//Class: ICS3U Computer Science
//Assigment 8 - Question 2
//Date: October 30 2014

import java.io.*;

public class William_A8Q2V2 {
	
	//Declare BufferedReader and referenced arrays outside of main method to allow others to access them
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static String[] daysOfWeekShort = {"S","M","T","W","T","F","S"};
	static String[] daysOfWeekFull = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
	static String[] daysOfWeek = {"S","M","T","W","T","F","S"};
	
	public static void main(String[] args) throws IOException{
	
		//Create calendar 2D string array
		String[][] cal = putDashes(putHeader(new String[6][7]));
		
		//Use methods to get first day and number of days in a month
		int firstDay = getFirstPos();
		int daysInMonth = getDaysInMonth();
		
		//Use method to fill calendar
		cal = fillCal(cal,daysInMonth,firstDay);
		
		//Print finished calendar
		printCal(cal);
		
	}
	
	//Puts header with days of the week on top of calendar
	private static String[][] putHeader(String[][] cal){
		for(int i = 0; i < cal[0].length;i++){
			cal[0][i] = daysOfWeek[i];
		}
		return cal;
	}
	
	//Puts dashes in all positions below the top row
	private static String[][] putDashes(String[][] cal){
		for(int i = 1; i < cal.length;i++){
			for(int n = 0; n < cal[0].length;n++){
				cal[i][n] = "-";
			}
		}
		return cal;
	}
	
	//Fill the calendar
	private static String[][] fillCal(String[][] cal, int numOfDays, int firstDay){
		int days = 1;
		for(int i = 1;i < cal.length;i++){
			//If in the first row of numbers, begin at first day
			if(i == 1){
				for(int n = firstDay;n < cal[0].length;n++){
					cal[i][n] = Integer.toString(days);
					days++;
				}
			}
			//Otherwise begin at first position, making sure not to put numbers above the number of days in the month
			else{
				for(int n = 0;n < cal[0].length && days <= numOfDays;n++){
					cal[i][n] = Integer.toString(days);
					days++;
				}
			}
		}
		return cal;
	}
	
	//Print formatted calendar
	private static void printCal(String[][] cal){
		for (int i = 0; i < cal.length; i++) {
			for (int n = 0; n < cal[0].length; n++) {
				//This uses printf to make sure all of the numbers take up an equal amount of space regardless of their length
				System.out.printf("| %3s ", cal[i][n]);
			}
			System.out.println();
		}
	}
	
	//Get position of first day of the month
	private static int getFirstPos() throws IOException{
		int day = 0;
		System.out.print("What day of the week does the first of the month fall on: ");
		String input = stdin.readLine();
		//Looks for the name in an array of the days of the week
		for(int i = 0; i< daysOfWeekFull.length;i++){
			if(input.equalsIgnoreCase(daysOfWeekFull[i])){
				day = i;
			}
		}
		return day;
	}
	
	//Get number of days in the month
	private static int getDaysInMonth() throws NumberFormatException, IOException{
		System.out.print("How many days are in the month: ");
		int days = Integer.parseInt(stdin.readLine());
		return days;
	}
}
