import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _042_TriangleWords {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("file_042.txt"));
		String[] words = input.nextLine().split(",");
		input.close();
		int sum;
		int numTriangular = 0;
		for(String word: words) {
			sum = 0;
			for(int i=1; i<word.length()-1; i++) {
				sum += (int)word.charAt(i) - 64;
			}
			if(isTriangular(sum)) {
				numTriangular++;
			}
		}
		System.out.println(numTriangular + " triangular words");
	}
	
	public static boolean isTriangular(int n) {
		int tNum = 0;
		int seed = 1;
		while(tNum <= n) {
			tNum = (int)(seed*(seed+1)*0.5);
			seed++;
			if(tNum == n)
				return true;
		}
		return false;
	}
}
