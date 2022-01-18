public String CheckYourself(String stringGuess){
	int guess = Integer.parseInt(stringGuess);  //converting String to int
	String result = "miss";		//setting default result as miss
	for(int cell : locationCells){		//chech for each cell in the locationCells array
		if(guess == cell){		//if the guess is correct
			result = "hit";		//change the result to 'hit'
			numOfHits++;		//increment the numOfHits
			break;				//comeout of the loop
		}
	}
	if(numOfHits == locationCells.length){		//if all cells in locationCells array are guessed
		result = "kill";				//set the result to kill
	}
	System.out.println(result):			//print the result
	return result;						//return the result
}