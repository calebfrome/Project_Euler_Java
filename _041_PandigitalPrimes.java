import java.util.Arrays;

public class _041_PandigitalPrimes {

	final static int maxNumDigits = 7;
	
	public static void main(String[] args) {
		int maxPanPrime = 0;
		for(int n=2; n<Math.pow(10, maxNumDigits); n++) {
			if(Primes.isPrime(n)) {
				if(isPandigital(n)) {
					if (n > maxPanPrime) {
						maxPanPrime = n;
						System.out.println(maxPanPrime);
					}
				}
			}
		}
		System.out.println("Maximum Pandigital Prime (max n=" + maxNumDigits + ") = " + maxPanPrime);
	}
	
	public static boolean isPandigital(Integer n) {
		String s = n.toString();
		int[] vals = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			vals[i] = Integer.valueOf(s.substring(i,i+1));
		}
		Arrays.sort(vals);
		for(int i=0; i<vals.length; i++) {
			if(vals[i] != i+1) {
				return false;
			}
		}
		return true;
	}
}
