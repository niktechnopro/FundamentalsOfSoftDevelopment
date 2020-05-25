import java.util.Scanner;
import java.util.Array;
import java.util.Arrays;

public class WhackAMole {
	int score;
	int molesLeft;
	static int attemptsLeft;
	char [][] moleGrid;
	
	
	public WhackAMole(int numAttempts, int gridDimension){
		attemptsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
		for (int row = 0; row < moleGrid.length; row++) {//initialize initial field
			for (int column = 0; column < moleGrid[row].length; column++) {
				moleGrid[row][column] = '*';
			}
		}
		printGridToUser();
	}
	
	boolean place(int x, int y) {
//		 Given a location, place a mole at that location. Also update number of moles left.
		
		 return true;
	}
	
	static void whack(int x, int y) {
//		Given a location, take a whack at that location. 
//		If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated. 
//		If that location does not contain a mole, only attemptsLeft is updated.
	}
	
	void printGridToUser() {//this is for
//		Print the grid without showing where the moles are.
		for (int row = 0; row < moleGrid.length; row++) {//initialize empty field
			System.out.println(Arrays.toString(moleGrid[row])); //to print array
		}
//		For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
	}
	
	void printGrid(){//this is for the end of game
//		Print the grid completely. 
//		This is effectively dumping the 2d array on the screen.
		
		
//		The places where the moles are should be printed as an ‘M’. 
//		The places where the moles have been whacked should be printed as a ‘W’. 
//		The places that don’t have a mole should be printed as *.
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhackAMole newGame = new WhackAMole(50, 10);
		newGame.molesLeft = 10;
		System.out.println("enter the coordinates x and y for whack, like so x, y");
		while(attemptsLeft > 0) {
			Scanner input = new Scanner(System.in);
			String[] userInp = input.nextLine().split(",");
			if(!userInp[0].trim().equals("-1") && !userInp[1].trim().equals("-1")) {
				whack(Integer.parseInt(userInp[0].trim()),Integer.parseInt(userInp[1].trim()));
			}else {
				System.out.println("exit");
				input.close();
				break;
			}
		}
	}

}
