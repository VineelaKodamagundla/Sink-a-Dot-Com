import java.util.ArrayList;

public class DotCom{
	private ArrayList <String> locationCells;		//create an ArrayList to store locationCells
	public void setlocationCells(ArrayList <String> lc){
		locationCells = lc;
	}	
	public String checkYourself(String userGuess){
		String result = "miss";			//set default result to miss
		int index = locationCells.indexOf(userGuess);		//this sets index to the index of the userGuess in the ArrayList else it sets it to -1
		if(index>=0){		//when userGuess is in the ArrayList
			locationCells.remove(index);		//remove 
			if(locationCells.isEmpty()){
				result = "kill";		//if list is empty it means that user has killed the DotCom
			}
			else{
				result = "hit";		//else its just a hit
			}
		}
		return result;		//return the result
	}
}