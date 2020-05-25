import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class WhackAMole {
	int score = 0;
	int molesLeft = 10;
	int attemptsLeft;
	char [][] moleGrid;
	Random random = new Random();
	
	
	public WhackAMole(int numAttempts, int gridDimension){
		this.attemptsLeft = numAttempts;
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
		int moleX = random.nextInt(moleGrid.length);
		int moleY = random.nextInt(moleGrid.length);
		//check if W is already there and rerun random generator to place it on new spot
		while (Character.compare((moleGrid[moleY][moleX]), 'W') == 0) {
			System.out.println("reposition Mole");
			moleX = random.nextInt(moleGrid.length);
			moleY = random.nextInt(moleGrid.length);
		}
		moleGrid[y][x] = 'W';
		System.out.println("the mole should be at: " + "x: " + moleX + " y: " + moleY);
		if(Character.compare((moleGrid[moleY][moleX]), 'W') != 0) {
			return false;
		}
		 return true;
	}
	
	void whack(int x, int y) {
//		Given a location, take a whack at that location.
		System.out.println("wack: " + "x: " + x + "," + " y: " + y);
		if(place(x, y)) {
			System.out.println("we hit the mole");
//			If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated. 
			molesLeft -= 1;
			score += 1;
		}else {
			System.out.println("we missed");
		}
		//If that location does not contain a mole, only attemptsLeft is updated.
		attemptsLeft -= 1;
		printGridToUser();
	}
	
	void printGridToUser() {//this is for
//		Print the grid without showing where the moles are.
		for (int row = 0; row < moleGrid.length; row++) {//initialize empty field
			System.out.println(Arrays.toString(moleGrid[row])); //to print array
		}
//		For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
	}
	
	void printGrid(){//this is for the end of game
//		Print the grid completely. This is effectively dumping the 2d array on the screen.
		int m = molesLeft;
		int moleX;
		int moleY;
		while(m > 0) {//printing left over Moles
			moleX = random.nextInt(moleGrid.length);
			moleY = random.nextInt(moleGrid.length);
			if(Character.compare((moleGrid[moleY][moleX]), 'W') != 0 && Character.compare(moleGrid[moleY][moleX], 'M') != 0 ) {
//				System.out.println("condition, where we can place a mole");
//				The places where the moles are should be printed as an ‘M’.
				moleGrid[moleY][moleX] = 'M';
				m -= 1;
			}
		}
//		The places where the moles have been whacked should be printed as a ‘W’. 
//		The places that don’t have a mole should be printed as *.
		printGridToUser();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhackAMole newGame = new WhackAMole(10, 5);
		while(newGame.attemptsLeft > 0) {
			System.out.println("enter the coordinates x and y for whack(0 ," + (newGame.moleGrid.length-1) + "), like so x, y");
			Scanner input = new Scanner(System.in);
			String[] userInp = input.nextLine().split(",");
			if(Integer.valueOf(userInp[0].trim()) < newGame.moleGrid.length && Integer.valueOf(userInp[1].trim()) < newGame.moleGrid.length && Character.compare((newGame.moleGrid[Integer.valueOf(userInp[1].trim())][Integer.valueOf(userInp[0].trim())]), 'W') != 0) {//making sure the position provided by user is inside Grid
				if(!userInp[0].trim().equals("-1") && !userInp[1].trim().equals("-1")) {
					System.out.println("we are here");
					newGame.whack(Integer.parseInt(userInp[0].trim()),Integer.parseInt(userInp[1].trim()));
				}else {
					System.out.println("exit");
					input.close();
					break;
				}
			}else {
				System.out.println("Coordinates are out of Grid bounds or already exist - reenter");
			}
		}
		System.out.println("Game Over");
		System.out.println("Moles Hit: " + newGame.score);
		System.out.println("Moles Left: " + newGame.molesLeft);
		newGame.printGrid();
	}

}
