import java.util.*;
public class SimpleDotComGame{
	public static void main(String [] args){
		int numOfGuesses = 0;		//initialise numOfGuesses to 0
		Scanner sc = new Scanner(System.in);
		SimpleDotCom theDotCom = new SimpleDotCom();	//create a SimpleDotCom object
		int rand = (int)(Math.random() * 5);		//generate a random number to choose the first cell to make the locationCells array
		int [] locCells =  {rand, rand+1, rand+2};
		theDotCom.setlocationCells(locCells);
		boolean isAlive = true;			//is true when game is alive
		while(isAlive){
			System.out.println("Enter a number: ");  
			String guess = sc.nextLine();		//Take user's guess
			String result = theDotCom.CheckYourself(guess);		//call CheckYourself method with user's guess as argument
			numOfGuesses++;
			if(result.equals("kill")){		//check if user has guessed all three cell locations
				isAlive = false;			//change iAlive to false as game is done
				System.out.println("You took "+numOfGuesses+" guesses.");		//print the number of user guesses.
			}	
		}	
	}	
}