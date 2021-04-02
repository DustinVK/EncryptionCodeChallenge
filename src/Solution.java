import java.util.ArrayList;

/*
 * An English text needs to be encrypted using the following encryption scheme. 
 * First, the spaces are removed from the text. Let be the length of this text. 
 * Then, characters are written into a grid, 
 * whose rows and columns have the following constraints:
 * sqrt(length) <= row <= column <= sqrt(length), where [x] is floor function and [y] is ceil function
 */

public class Solution {
	
	// encryption method 
	public static void encrypt(String input) {
		char inputChars[] = input.replaceAll("\\s+","").toCharArray();
		int length = inputChars.length;
		int rows = (int) Math.floor(Math.sqrt(length));
		int columns = (int) Math.ceil(Math.sqrt(length));
		
		if(rows*columns < length) {
			rows ++;
		}
		
		char cMap[][] = mapChars(inputChars, rows, columns);
		
		printEncrypted(rows, columns, cMap);
	}
	
	public static char[][] mapChars(char inputChars[], int rows, int columns){
		char charMap[][] = new char[rows][columns];
		for(int i = 0; i < inputChars.length; i++) {
			int row = i/columns;
			int col = i-(row*columns);
			charMap[row][col] = inputChars[i];
		}
		return charMap;
	}


	private static void printEncrypted(int rows, int columns, char[][] cMap) {
		String result = "";
		for(int i = 0; i < columns; i++) {
			
			for(int j =0;j<rows;j++) {
				result += cMap[j][i];
			}
			result += " ";
			
		}
		System.out.println(result);
	}
	

	public static void main(String[] args) {
		encrypt("if man was meant to stay on the ground god would have given us roots");
		encrypt("have a nice day");
		encrypt("feed the dog");
		encrypt("chillout");
		

	}

}
