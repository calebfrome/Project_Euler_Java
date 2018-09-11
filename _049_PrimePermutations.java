/* Solution is 2969 6299 9629 */

import java.util.ArrayList;
import java.util.Arrays;

public class _049_PrimePermutations {

	public static void main(String[] args) {
		ArrayList<Integer> primes = Primes.createArrayPrimes(1000, 9999);
		int num;
		for(int i=0; i<primes.size(); i++) {
			num = primes.get(i);
			for(int diff=1; diff<(primes.get(primes.size()-1)-primes.get(i))/2; diff++) {
				if(primes.contains(num+diff) && perms(num, num+diff)) {
					if(primes.contains(num+2*diff) && perms(num, num+2*diff)) {
						System.out.println(num+""+(num+diff)+""+(num+2*diff));
					}
				}
			}
		}
	}
	
	public static boolean perms(int a, int b) {
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		int[] a_vals = new int[s1.length()];
		int[] b_vals = new int[s2.length()];
		for(int i=0; i<s1.length(); i++) {
			a_vals[i] = Integer.valueOf(s1.substring(i, i+1));
			b_vals[i] = Integer.valueOf(s2.substring(i, i+1));
		}
		Arrays.sort(a_vals);
		Arrays.sort(b_vals);
		for(int j=0; j<a_vals.length; j++) {
			if(a_vals[j] != b_vals[j]) {
				return false;
			}
		}
		return true;
	}

}
