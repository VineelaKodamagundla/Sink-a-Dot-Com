import java.io.*;
import java.util.*;

public class GameHelper{
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int [] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput(String prompt){
		System.out.println(prompt+ " ");
		String input = null;
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		if(input.length() == 0)
			return null;
		return input.toLowerCase();
	}
	
	public ArrayList<String> placeDotCom(int comSize){
		ArrayList<String> alphaCells = new ArrayList<String>();
		String [] alphacoords = new String[comSize];
		int [] coords = new int[comSize];
		int attempts = 0;
		String temp = null;
		int location = 0;
		boolean success = false;
		comCount++;
		int inc = 1;
		if(comCount%2 == 1){
			inc = gridLength;
		}
		while(!success & attempts++ < 200){
			location = (int)(Math.random() * gridSize);
			//System.out.println("try"+location);
			int x = 0;
			success = true;
			while(success && x<comSize){
				if(grid[location]==0){
					coords[x++] = location;
					location += inc;
					if(location >= gridSize)
						success = false;
					if(x>0 && (location%gridLength == 0))
						success = false;
				}
				else{
					success = false;
				}
			}
		}
		int x = 0;
		int row = 0;
		int column = 0;
		while(x<comSize){
			grid[coords[x]]=1;
			row = (int)(coords[x]/gridLength);
			column = coords[x]%gridLength;
			temp = String.valueOf(alphabet.charAt(column));
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			//System.out.println(" coord "+x+" = "+alphaCells.get(x-1));
		}
		return alphaCells;
	}
}