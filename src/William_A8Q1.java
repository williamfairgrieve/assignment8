//Name: William Fairgrieve
//Class: ICS3U Computer Science
//Assigment 8 - Question 1
//Date: October 30 2014
public class William_A8Q1 {
	public static void main(String[] args) {
		//Declare 2D array
		int[][] ray = new int[3][5];

		//Declare variable to add 3 to
		int x = 0;

		//Nested for loop to add multiples of 3 to 2D array
		for (int i = 0; i < ray.length; i++) {
			for (int n = 0; n < ray[0].length; n++) {
				ray[i][n] = x;
				x += 3;
			}
		}
		
		//Set array value at 0,0 to 1 because this is easier than handling it with an if statement
		ray[0][0] = 1;
		
		//Nested for loop to print out contents of 2D array
		for (int i = 0; i < ray.length; i++) {
			for (int n = 0; n < ray[0].length; n++) {
				System.out.print(ray[i][n] + " ");
			}
			System.out.println();
		}
		
	}//End of main method
}//End of class
