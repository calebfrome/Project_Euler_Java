/*
 * PROBLEM: Find first 10 digits of the sum of the 100 50-digit numbers in file13.txt
 * SOLUTION: 5537376230 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class _013_LargeSum {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("file13.txt"));
		ArrayList<BigInteger> data = new ArrayList<BigInteger>();
		StringBuilder sb = new StringBuilder();
		String strVal="";
		BigInteger sum=BigInteger.valueOf(0);
		for(int i=0;i<100;i++) {
			sb= new StringBuilder(file.next());
			sb.delete(30,50);
			strVal=sb.toString();
			data.add(new BigInteger(strVal));
			System.out.println(data.get(i));
			sum=sum.add(data.get(i));
		}
		System.out.println("sum is: "+sum);
		file.close();
	}

}
