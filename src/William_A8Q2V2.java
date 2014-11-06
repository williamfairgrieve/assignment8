import java.io.*;

import javax.imageio.IIOException;

public class William_A8Q2V2 {
	
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static String[] daysOfWeekShort = {"S","M","T","W","T","F","S"};
	static String[] daysOfWeekFull = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
	
	public static void main(String[] args) throws IOException{
	
		String[] daysOfWeek = {"S","M","T","W","T","F","S"};
		String[][] cal = putDashes(putHeader(new String[6][7],daysOfWeek));
		
		int firstDay = getFirstPos();
		
		int daysInMonth = getDaysInMonth();
		
		cal = fillCal(cal,daysInMonth,firstDay);
		printCal(cal);
		
		
		
		
	}
	
	private static String[][] putHeader(String[][] cal, String[] daysOfWeek){
		for(int i = 0; i < cal[0].length;i++){
			cal[0][i] = daysOfWeek[i];
		}
		return cal;
	}
	
	private static String[][] putDashes(String[][] cal){
		for(int i = 1; i < cal.length;i++){
			for(int n = 0; n < cal[0].length;n++){
				cal[i][n] = "-";
			}
		}
		return cal;
	}
	
	private static String[][] fillCal(String[][] cal, int numOfDays, int firstDay){
		int days = 1;
		for(int i = 1;i < cal.length;i++){
			if(i == 1){
				for(int n = firstDay;n < cal[0].length && days <= numOfDays;n++){
					cal[i][n] = Integer.toString(days);
					days++;
				}
			}
			else{
				for(int n = 0;n < cal[0].length && days <= numOfDays;n++){
					cal[i][n] = Integer.toString(days);
					days++;
				}
			}
			
		}
		return cal;
	}
	
	private static void printCal(String[][] cal){
		for (int i = 0; i < cal.length; i++) {
			for (int n = 0; n < cal[0].length; n++) {
				System.out.printf("| %3s ", cal[i][n]);
			}
			System.out.println();
		}
	}
	
	private static int getFirstPos() throws IOException{
		int day = 0;
		System.out.print("What day of the week does the first of the month fall on: ");
		String input = stdin.readLine();
		for(int i = 0; i< daysOfWeekFull.length;i++){
			if(input.equalsIgnoreCase(daysOfWeekFull[i])){
				day = i;
			}
		}
		return day;
	}
	
	private static int getDaysInMonth() throws NumberFormatException, IOException{
		System.out.print("How many days are in the month: ");
		int days = Integer.parseInt(stdin.readLine());
		return days;
	}
	
}
