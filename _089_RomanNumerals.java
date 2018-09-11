import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _089_RomanNumerals {

	public static void main(String[] args) throws FileNotFoundException {
		String[] data = new String[1000];
		int index = 0;
		Scanner input = new Scanner(new File("file_089.txt"));
		while(input.hasNextLine()) {
			data[index++] = input.nextLine();
		}
		input.close();
		int num;
		int buffer;
		int current;
		int letterCountNew;
		int lettersSaved = 0;
		for(index=0; index<1000; index++) {
			num = 0;
			letterCountNew = 0;
			buffer = toArabic(data[index].charAt(0));
			for(int i=1; i<data[index].length(); i++) {
				current = toArabic(data[index].charAt(i));
				//if we have a subtraction, write the difference and flush the buffer
				if(current > buffer && buffer > 0) {
					num += (current - buffer);
					buffer = 0;
				}
				//if no subtraction, write the buffer and advance
				else {
					num += buffer;
					buffer = current;
				}
			}
			num += buffer;
			System.out.println(num);
			// M
			while(num >= 1000) {
				num -= 1000;
				letterCountNew++;
			}
			
			for(int lvl=100; lvl>=1; lvl/=10) {
				// special case: exactly 9*lvl
				if(num >= 9*lvl) { //at this point, num is guaranteed to be < 10*lvl
					num -= 9*lvl;
					letterCountNew += 2;
				}
				// special case: exactly 4*lvl
				else if(num >= 4*lvl && num < 5*lvl) {
					num -= 4*lvl;
					letterCountNew += 2;
				}
				// lvl*5 and lvl
				else {
					if(num >= lvl*5) {
						num -= lvl*5;
						letterCountNew++;
					}
					while(num >= lvl) {
						num -= lvl;
						letterCountNew++;
					}
				}
			}
			lettersSaved += (data[index].length() - letterCountNew);
		}
		System.out.println(lettersSaved + " characters saved");
	}
	
	public static int toArabic(char letter) {
		switch(letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		//should never get here
		default:
			return 0;
		}
	}
}
