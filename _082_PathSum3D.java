import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _082_PathSum3D {

	public static void main(String[] args) throws FileNotFoundException {
		//read matrix data into raw 2D array
		int[][] raw = new int[80][80];
		Scanner file = new Scanner(new File("file_081.txt"));
		String[] temp;
		for(int line = 0; line < 80; line++) {
			temp = file.nextLine().split(",");
			for(int i=0; i<80; i++) {
				raw[line][i] = Integer.parseInt(temp[i]);
			}
		}
		//create new matrix array with rows/columns swapped
		int[][] matrix = new int[80][80];
		for(int i=0; i<80; i++) {
			for(int j=0; j<80; j++) {
				matrix[i][j] = raw[j][i]; 
			}
		}
		file.close();
		
		//variables
		int[][] pathSum = new int[80][80]; //use dynamic programming to store all minimum partial sums
		int minOverallSum = Integer.MAX_VALUE; //the final result
		int minSum = 0; //temp variable storing minimum path sum for a cell within its column
		int sum; //temp variable storing some path sum for a cell within its column
		int dist; //number of cells traversed vertically within current column

		//first column is the same
		for(int y=0; y<80; y++) {
			pathSum[0][y] = matrix[0][y];
		}
		//iterate over all columns from left to right
		for(int x=1; x<80; x++) {
			//iterate over all cells within the column from top to bottom
			for(int y=0; y<80; y++) {
	 			minSum = Integer.MAX_VALUE;
				//starting from (x,y) - find min path sum from top (x,y-k), then from bottom (x,y+k) 
		 		for(int z=-1; z<=1; z+=2) {
		 			dist = 0;
		 			//move up (z==-1) and down (z==1) from (x,y)
		 			//until reaching a partial path sum (within the column) which exceeds minSum
		 			//or reaching the top or bottom of the matrix
		 			do {
		 				//calculate the sum within the column from (x,y) to (x,y+zj) 
		 				sum = 0;
		 				for(int k=0; k<=dist; k++) {
		 					sum += matrix[x][y+z*k];
		 				}
		 				//add the value of the cell to the left (x-1,y+zj) to sum, and compare with minSum 
		 				minSum = Math.min(minSum, sum + pathSum[x-1][y + z*dist]);
		 				dist++;
		 			} while(sum<minSum && (y+z*dist)>=0 && (y+z*dist)<=79);
		 		}
		 		//store result
		 		pathSum[x][y] = minSum;
		 		if(x==79) minOverallSum = Math.min(minOverallSum, minSum);
			}
		}
		System.out.println(minOverallSum);
	}
}
