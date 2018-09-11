/* Solution is 871198282 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _022_NameScores {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> names = new ArrayList<String>();
		Scanner input = new Scanner(new File("file_022.txt"));
		String[] buffer = input.nextLine().split("\",\"");
		input.close();
		buffer[0] = buffer[0].substring(1, buffer[0].length());
		buffer[buffer.length-1] = buffer[buffer.length-1].substring(0, buffer[buffer.length-1].length()-1);
		for(String s: buffer) {
			names.add(s);
		}
		names.sort(null);
		String name;
		int sum = 0;
		int temp = 0;
		for(int i=0; i<names.size(); i++) {
			temp = 0;
			name = names.get(i);
			for(int j=0; j<name.length(); j++) {
				temp += (((int) name.charAt(j)) - 64)*(i+1);
			}
			sum += temp;
		}
		System.out.println("Sum is " + sum);
	}

}
