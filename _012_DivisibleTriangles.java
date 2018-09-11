/**
 * PROBLEM:  What is the smallest triangular number to have at least 500 factors?
 * SOLUTION: 
 */

import java.io.FileNotFoundException;


public class _012_DivisibleTriangles {

	public static void main(String[] args) throws FileNotFoundException {
		int numFactors=0;
		int currTriangleSize=1;
		int value=1;
		int testTriangle=0;
		
		while(numFactors<500) {
			//create triangle number
			while(value<=currTriangleSize) {
				testTriangle+=value;
				value++;
			}
			numFactors=findNumFactors(testTriangle);
			System.out.println(currTriangleSize+" "+testTriangle+" "+findNumFactors(testTriangle));
			currTriangleSize++;
		}
		
		System.out.println(testTriangle+" "+findNumFactors(testTriangle));
	}

	public static int findNumFactors(int number) {
		int numFactors=2; //number is divisible by 1 and itself
		for(int d=2;d<(number/2+1);d++) {
			if(number%d==0) {
				numFactors++;
			}
		}
		return numFactors;
	}

}
