import java.io.*;

public class William_A8Q2V2 {
	
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args){
	
		String[] daysOfWeek = {"S","M","T","W","T","F","S"};
		String[][] cal = putDashes(putHeader(new String[6][7],daysOfWeek));
		
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
	
	private static void printCal(String[][] cal){
		for(int i = 0; i < cal.length;i++){
			for(int n = 0; n < cal[0].length;n++){
				System.out.print(cal[i][n]);
			}
		}
		System.out.println();
	}
	
}
