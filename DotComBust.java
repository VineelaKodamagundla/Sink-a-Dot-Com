import java.util.*;
public class DotComBust{
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses;
	
	private void setUpGame(){
		DotCom com1 = new DotCom();
		DotCom com2 = new DotCom();
		DotCom com3 = new DotCom();
		com1.setName("Pets.com");
		com2.setName("Lastminute.com");
		com3.setName("Theglode.com");
		dotComsList.add(com1);
		dotComsList.add(com2);
		dotComsList.add(com3);
		
		System.out.println("The goal is to sink three dot coms, Each dot com takes up three cells.");
		System.out.println("Pets.com	Lastminute.com	  Theglobe.com");
		System.out.println("Try to sink them all in least possible number of guesses");
		
		for (DotCom dotComToSet : dotComsList){
			ArrayList<String> location = helper.placeDotCom(3);
			dotComToSet.setLocationCells(location);
		}
	}
	
	private void startPlaying(){
		while(!dotComsList.isEmpty()){
			String userGuess = helper.getUserInput("Enter a guess:");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess){
		numOfGuesses++;
		String result  = "miss";
		for(DotCom dotComToTest : dotComsList){
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")){
				break;
			}
			if(result.equals("kill")){
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame(){
		System.out.println("All DotComs are dead!");
		if(numOfGuesses <= 20){
			System.out.println("It only took you "+numOfGuesses+" guesses.");
			System.out.println("You got out before your options sank");
		}
		else{
			System.out.println("Took you long enough.");
			System.out.println(numOfGuesses+" guesses!!!!");
		}
	}
	
	public static void main(String [] args){
		DotComBust obj = new DotComBust();
		obj.setUpGame();
		obj.startPlaying();
	}
}