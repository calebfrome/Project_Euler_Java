import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _059_XORDecryption {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("file_059.txt"));
		String[] raw = input.nextLine().split(",");
		input.close();
		boolean flag = true;
		int sum = 0;
		int count = 0;
		int[] msg = new int[raw.length];
		for(int x=97; x<=122; x++) {
			for(int y=97; y<=122; y++) {
				for(int z=97; z<=122; z++) {
					int[] key = {x,y,z};
					//System.out.println((char)x + "" + (char)y + "" + (char)z);
					if(count++ % 28 == 0) {
						count += 0; //debug
					}
					for(int i=0; i<raw.length; i++) {
						msg[i] = Integer.valueOf(raw[i]) ^ Integer.valueOf(key[i%3]);
					}
					//for(int j: msg) {
					//	if(j < 65 || j > 122) {
					//		flag = false;
					//		break;
					//	}
					//}
					if(flag) {
						for(int j: msg) {
							sum += j;
							System.out.print((char) j);
						}
						System.out.println(" " + sum);
						sum = 0;
					}
					flag = true;
				}
			}
		}
	}

}
