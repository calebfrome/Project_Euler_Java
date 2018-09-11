
public class _037_TruncatablePrimes {

	public static void main(String[] args) {
		int TPsFound = 0;
		int TPsum = 0;
		int testNum = 11;
		System.out.println(Primes.isPrime(1));
		while(TPsFound < 11) {
			if(isTP(testNum)) {
				System.out.println(testNum);
				TPsFound++;
				TPsum += testNum;
			}
			testNum++;
		}
		System.out.println(TPsum);
	}
	
	public static boolean isTP(Integer n) {
		String s1 = n.toString();
		String s2 = n.toString();
		int numDigits = s1.length();
		for(int i=0; i<numDigits; i++) {
			if(!Primes.isPrime(Integer.valueOf(s1)))
				return false;
			if(!Primes.isPrime(Integer.valueOf(s2)))
				return false;
			s1 = s1.substring(0,s1.length()-1);
			s2 = s2.substring(1,s2.length());
		}
		
		return true;
	}

}
