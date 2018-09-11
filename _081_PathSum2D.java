/* Answer is 427337 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _081_PathSum2D {

	public static void main(String[] args) throws FileNotFoundException {
		int[][] matrix = new int[80][80];
		Scanner file = new Scanner(new File("file_081.txt"));
		String[] temp;
		for(int line = 0; line < 80; line++) {
			temp = file.nextLine().split(",");
			for(int i=0; i<80; i++) {
				matrix[line][i] = Integer.parseInt(temp[i]);
			}
		}
		file.close();
		int[][] pathSum = new int[80][80];
		int x, y;
		for(int j = 0; j <= 159; j++) {
			y = Math.min(j, 79);
			x = j <= 79 ? 0 : j % 80;
			while(x <= Math.min(j, 79)) {
				pathSum[x][y] = matrix[x][y];
				if(x>0 || y>0) {
					if(x==0) {
						pathSum[x][y] += pathSum[x][y-1];
					}
					else if(y==0) {
						pathSum[x][y] += pathSum[x-1][y];
					}
					else pathSum[x][y] += Math.min(pathSum[x][y-1], pathSum[x-1][y]);
				}
				x++;
				y--;
			}
		}
		System.out.println(pathSum[79][79]);
	}

}
