
public class _035_CircularPrimes {

	public static void main(String[] args) {
		int numCircular = 0;
		for(int num=2; num<1000000; num++) {
			numCircular += (isCircularPrime(num) ? 1 : 0);
		}
		System.out.println(numCircular);
	}
	
	public static boolean isCircularPrime(Integer n) {
		String s = n.toString();
		for(int r=0; r<n.toString().length(); r++) {
			if(!Primes.isPrime(Integer.valueOf(s)))
				return false;
			s = s.substring(1,s.length()) + s.charAt(0);
		}
		System.out.println(n);
		return true;
	}
}
