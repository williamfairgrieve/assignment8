//Name: William Fairgrieve
//Class: ICS3U Computer Science
//Assigment 8 - Question 3
//Date: October 31 2014
import java.io.*;
public class William_A8Q3V2 {

	//Declare objects outside of methods to allow multiple to have access / not waste memory making a new one each time a method is used
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static int[] numPad = {7,8,9,4,5,6,1,2,3};
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		//Declare char array for board, filled with dashes and print it
		char[][] board = fillBoard(new char[3][3]);
		printBoard(board);
		
		//Loop forever(it will end the program itself inside of the loop)
		while(true){
			
			//Put marks on board, print, check for win
			board = getPutCoords(board,"1", 'x');
			printBoard(board);
			checkDone(board, "1");
			//Redo the same thing for player 2
			board = getPutCoords(board,"2", 'o');
			printBoard(board);
			checkDone(board, "2");
		}
	}
	
	//Fill board with dashes
	private static char[][] fillBoard(char[][] board){
		
		for (int i = 0; i < board.length; i++) {
			for (int n = 0; n < board[0].length; n++) {
				board[i][n] = '-';
			}
		}
		return board;
	}
	
	//Print board, formatted nicely
	private static void printBoard(char[][] board){
		
		for (int i = 0; i < board.length; i++) {
			for (int n = 0; n < board[0].length; n++) {
				System.out.printf("|%s",board[i][n]);
			}
			System.out.println("|");
		}
	}
	
	//Get user input and convert into coordinates, putting character on board
	private static char[][] getPutCoords(char[][] board, String p, char sym) throws NumberFormatException, IOException{
		
		//Get input from user
		System.out.printf("Player %s, type coordinate number(based off of num pad): ", p);
		int raw = Integer.parseInt(stdin.readLine());
		int[] out = new int[2];
		
		//Convert to coordinates
		switch(raw){
			case 9:
				out[0] = 0;
				out[1] = 2;
				break;
			case 8:
				out[0] = 0;
				out[1] = 1;
				break;
			case 7:
				out[0] = 0;
				out[1] = 0;
				break;
			case 6:
				out[0] = 1;
				out[1] = 2;
				break;
			case 5:
				out[0] = 1;
				out[1] = 1;
				break;
			case 4:
				out[0] = 1;
				out[1] = 0;
				break;
			case 3:
				out[0] = 2;
				out[1] = 2;
				break;
			case 2:
				out[0] = 2;
				out[1] = 1;
				break;
			case 1:
				out[0] = 2;
				out[1] = 0;
				break;
		}
		
		//If space is unoccupied, put user's symbol there
		if(board[out[0]][out[1]] == '-'){
			board[out[0]][out[1]] = sym;
		}
		
		return board;
	}
	
	//Check if game is done, exit if it is
	private static void checkDone(char[][] board, String p){
		
		//Check the horizontals for 3 in a row, exit with message if true
		for(int i = 0; i < board.length; i++){
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][1] != '-'){
				System.out.printf("Player %s wins", p);
				System.exit(0);
			}
		}
		
		//Check the verticals, exit with message if true
		for(int i = 0; i < board.length; i++){
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[1][i] != '-'){
				System.out.printf("Player %s wins", p);
				System.exit(0);
			}
		}
		
		//Check the diagonals, exit with message if true
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-'){
			System.out.printf("Player %s wins", p);
			System.exit(0);
		}
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '-'){
			System.out.printf("Player %s wins", p);
			System.exit(0);
		}
	}
}