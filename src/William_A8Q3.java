//Name: William Fairgrieve
//Class: ICS3U Computer Science
//Assigment 8 - Question 3
//Date: October 31 2014
//Import everything in java.io
import java.io.*;
public class William_A8Q3 {
	//Put BufferedReader here so all of the methods can access it without having to create their own.
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		//Create 2D array to hold the game board, filled with dashes for blanks
		char[][] board = fillBoard(new char[3][3]);
		
		//Output blank board and create 1D arrays for coordinates 
		printBoard(board);
		int[] p1Coords = new int[2];
		int[] p2Coords = new int[2];
		
		//Loop until game ends
		while(true){
			//Get player 1's coordinates with getCoords method
			p1Coords = getCoords("1");
			//Put X in proper position, 
			board[p1Coords[0]-1][p1Coords[1]-1] = 'X';
			//Print board and check if the game is over
			printBoard(board);
			checkDone(board,"1");
			//Repeat above for 2nd player
			p2Coords = getCoords("2");
			board[p2Coords[0]-1][p2Coords[1]-1] = 'O';
			printBoard(board);
			checkDone(board,"2");
		}
	}//End of main method
	
	//Method to get coordinates
	public static int[] getCoords(String player) throws IOException{
		//Get string with coordinates
		System.out.print("Player " + player + " : Enter coordinates(x,y): ");
		String strInput = stdin.readLine();
		//Get int array with numbers from position 0 and position 2
		int[] coords = new int[2];
		coords[0] = Integer.parseInt(Character.toString(strInput.charAt(0)));
		coords[1] = Integer.parseInt(Character.toString(strInput.charAt(2)));
		return coords;
	}//End of method
	
	//Method to print contents of board
	public static void printBoard(char[][] board){
		//Loop through 2D array to print it
		for (int i = 0; i < board.length; i++) {
			for (int n = 0; n < board[0].length; n++) {
				System.out.print(board[i][n]);
			}
			System.out.println();
		}
	}//End of method
	
	//Method to check for 3 characters in a row
	public static void checkDone(char[][] board, String p){
		Boolean end = false;
		for(int i = 0; i < board.length; i++){
			end = (board[i][0] == board[i][1] && board[i][1] == board[i][2]);
			
		}
		for(int i = 0; i < board[0].length; i++){
			end = (board[0][i] == board[1][i] && board[1][i] == board[2][i]);
		}
		
		if(end){
			System.out.printf("Player %s wins! \n", p);
			System.exit(0);
		}
	}//End of method
	
	//Method to fill board with dashes
	public static char[][] fillBoard(char[][] board){
		//Loop through array filling with dashes
		for (int i = 0; i < board.length; i++) {
			for (int n = 0; n < board[0].length; n++) {
				board[i][n] = '-';
			}
		}
		return board;
	}//End of method
	
}//End of class
