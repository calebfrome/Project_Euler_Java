/**
 * PROBLEM:  Find largest product of 13 consecutive digits in given 1000-digit database
 * SOLUTION: 23514624000
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class _008_ProductInSeries {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner file = new Scanner(new File("file8.txt"));
		int[] data = new int[1000];
		for(int i=0;i<1000;i++) {
			data[i]=(file.nextInt());
		}
		long product=0;
		long maxProduct=0;
		
		for(int i=0;i<988;i++) {
			product=product(i,data);
			if(product>maxProduct)
				maxProduct=product;
		}
		System.out.println(maxProduct);
		file.close();
		
	}
	
	public static long product(int pos,int[] data) {
		long product=1;
		for(int i=pos;i<pos+13;i++) {
			product*=data[i];
			System.out.print(data[i]+" ");
		}
		System.out.println("= "+product);
		return product;
	}

}
