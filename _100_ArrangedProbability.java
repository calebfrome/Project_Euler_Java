/* Does not work! Brute force takes too long and doesn't even output the right answer when it gets there */

public class _100_ArrangedProbability {

	public static void main(String[] args) {
		long numDiscs = (long)1070300000000.0; //(long)Math.pow(10, 12);
		long numBlue = 0;
		long upperBound;
		long lowerBound;
		int count = 0;
		double prob;
		while(++numDiscs > 0) {
			if(numDiscs % 10000000 == 0) System.out.println(numDiscs);
			count = 0;
			upperBound = numDiscs;
			lowerBound = 0;
			numBlue = (long)(numDiscs*0.5);
			prob = p(numBlue, numDiscs);
			while(prob != 0.5) {
				if(prob > 0.5) {
					upperBound = (long)(lowerBound + 0.5*(upperBound - lowerBound));
					numBlue = lowerBound + (int)(0.5*(upperBound-lowerBound));
					prob = p(numBlue, numDiscs);
				}
				else {
					lowerBound = (long)(lowerBound + 0.5*(upperBound - lowerBound));
					numBlue += (int)(0.5*(upperBound-lowerBound));
					prob = p(numBlue, numDiscs);
				}
				if(count++ >= Math.log(numDiscs)/Math.log(2)) break;
			}
			if(prob == 0.5) {
				System.out.println(numBlue + "/" + numDiscs);
				if(numDiscs > Math.pow(10, 12)) break;
			}
		}
	}
	
	public static double p(long b, long n) {
		double prob = ((double)b/n);
		prob *= (b-1);
		prob /= (n-1);
		return prob;
	}

}
