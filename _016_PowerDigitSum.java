/*
 * PROBLEM: Find sum of digits of number 2^1000
 * SOLUTION: 1366
 */

import java.math.BigInteger;

public class _016_PowerDigitSum {

	public static void main(String[] args) {
		BigInteger two = BigInteger.valueOf(2);
		BigInteger bigNum = two.pow(1000);
		String strNum = bigNum.toString();
		StringBuilder sb = new StringBuilder(strNum);
		int sum=0;
		String temp="";
		for(int i=0;i<sb.length();i++) {
			temp=sb.substring(i,i+1);
			System.out.println(temp);
			sum+=Integer.parseInt(temp);
		}
		System.out.println(sum);
	}

}
