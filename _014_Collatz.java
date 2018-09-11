import java.math.BigInteger;

/**PROBLEM: Find what number under 1 million has longest chain.
*
*
***SOLUTION: 837799 @ 525 steps
*/ 

public class _014_Collatz {

	public static void main(String[] args) {
		BigInteger start = new BigInteger("1");
		BigInteger chainLength = new BigInteger("1");
		BigInteger startMax = new BigInteger("0");
		BigInteger chainMax = new BigInteger("0");
		BigInteger test = new BigInteger("997823");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		BigInteger maxChain = new BigInteger("1000");
		BigInteger million = new BigInteger("1000000");
		@SuppressWarnings("unused")
		int count=1; //debug
		
		for(start=one;start.min(million).equals(start);start = start.add(one)) {
			test = new BigInteger(start.toString());
			//System.out.println(count+": "+test); //debug
			count++;
			while(!test.equals(one) && chainLength.min(maxChain).equals(chainLength)) {
				if(((test.doubleValue()))/2==(test.divide(two).doubleValue())) {
					test=test.divide(two);
				}
				else {
					test=test.multiply(three).add(one);
				}
				chainLength = chainLength.add(one);
				//System.out.println(count+": "+test); //debug
				count++;
			}
			System.out.println(start+"   "+chainLength); //debug
			if(chainLength.max(chainMax).equals(chainLength)) {
				chainMax=chainLength;
				startMax=start;
			}
			chainLength=one;
			count=1;
			
		}
		System.out.println(startMax+"     "+chainMax);
	}

}
