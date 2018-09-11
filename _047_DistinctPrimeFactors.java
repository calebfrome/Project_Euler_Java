/* Answer is 134043 */

import java.util.ArrayList;

public class _047_DistinctPrimeFactors {

	final static int NUM_CONSEC = 4;
	final static int NUM_DISTINCT_PFACS = 4;
	
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		primes.add(2);
		primes.add(3);
		int pmax = 3;
		int n = 2;
		int consec = 0;
		while(true) {
			while(pmax < n) {
				if(Primes.isPrime(pmax += 2))
					primes.add(pmax);
			}
			if(numDPFacs(n++) == NUM_DISTINCT_PFACS) {
				System.out.println(n-1);
				consec++;
			}
			else consec = 0;
			if(consec == NUM_CONSEC) {
				//System.out.println(n-NUM_CONSEC);
				return;
			}
		}

	}
	
	public static int numDPFacs(int x) {
		ArrayList<Integer> facs = new ArrayList<Integer>();
		int i = 0;
		while(x > 1) {
			if(x % primes.get(i++) == 0) {
				x /= primes.get(--i);
				if(!facs.contains(primes.get(i)))
					facs.add(primes.get(i));
			}
		}
		return facs.size();
	}

}
