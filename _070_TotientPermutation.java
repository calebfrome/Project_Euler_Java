/* Solution is 8319823
 * This could be sped up drastically by storing the n choose k arrays
 * in a separate class, accessed by a key defined by n and k
 */

import java.util.ArrayList;
import java.util.Arrays;

public class _070_TotientPermutation {

static ArrayList<Integer> primes = Primes.createArrayPrimesBelow(10000000);
	
	public static void main(String[] args) {
		double ntMin = Double.MAX_VALUE;
		double nt = 0.0;
		int nMin = 0;
		int n = 1;
		int temp;
		while(++n < 10000000) {
			if(n % 1000 == 0) System.out.println(n);
			temp = totient(n);
			//System.out.println(n + ": " + temp);
			if(perms(n, temp)) { 
				nt = ((double)n)/temp;
				if(nt < ntMin) {
					ntMin = nt;
					nMin = n;
					System.out.println("Found new min n/t: " + ntMin + " at n=" + nMin);
				}
			}
		}
		System.out.println("n/t is minimized at n=" + nMin + " | nt = " + ntMin);
	}
		
	public static int totient(int x) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int temp = x;
		int factor = 1;
		int pullOut = 1;
		if(Primes.isPrime(temp)) {
			return x-1;
		}
		//find all factors and pull out duplicates
		for(int i=0; factor <= temp; i++) {
			factor = primes.get(i);
			while(temp % factor == 0) {
				if(!factors.contains(factor)) {
					factors.add(factor);
				}
				else {
					pullOut *= factor;
					x /= factor;
				}
				temp /= factor;
			}
		}
		String[] combos = new String[factors.size()];
		int sign = 1;
		int sum = 0;
		int tempSum;
		int tempCombo;
		int count;
		//iterate over all combo sizes
		for(int comboSize = factors.size()-1; comboSize > 0; comboSize--) {
			tempSum = 0;
			combos = calcCombos(factors.size(), comboSize);
			//iterate over every possible combo
			for(String s: combos) {
				//create the combo
				tempCombo = 1;
				count = 0;
				for(int index=0; index < factors.size(); index++) {
					if(s.charAt(index) == 49) {
						tempCombo *= factors.get(index);
						count++;
					}
					if(count == comboSize) break;
				}
				tempSum += tempCombo;
			}
			sum += sign*tempSum;
			sign *= -1;
		}
		sum += sign;
		return pullOut*(x-sum);
	}
	
	//faster
	public static boolean perms(int a, int b) {
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		if(s1.length() != s2.length()) return false;
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
	
	//slower
	public static boolean perms2(int a, int b) {
		boolean flag = true;
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		if(s1.length() != s2.length()) return false;
		int[] b_indices = new int[s2.length()];
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				while(b_indices[j]==1) {
					if(++j>=s2.length()) {
						flag = false;
						break;
					}
				}
				if(flag && s2.charAt(j) == s1.charAt(i)) {
					b_indices[j] = 1;
					break;
				}
				flag = true;
			}
		}
		for(int index=0; index<s2.length(); index++) {
			if(b_indices[index] == 0) return false;
		}
		return true;
	}
	
	
	public static String[] calcCombos(int n, int k) {
		String[] combos = new String[factorial(n)/(factorial(n-k)*factorial(k))];
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<k; i++) {
			sb.append('1');
		}
		while(sb.length() < n) {
			sb.append('0');
		}
		combos[0] = sb.toString();
		int lastValidOne;
		StringBuilder ones;
		for(int index=1; index<combos.length; index++) {
			//find index of last occurrence of "10"
			lastValidOne = sb.length() - 2;
			ones = new StringBuilder("");
			while(!sb.substring(lastValidOne, lastValidOne+2).equals("10")) {
				if(sb.charAt(lastValidOne+1) == '1') ones.append("1");
				lastValidOne--;
			}
			//create next combo by changing 10 to 01 and moving up all subsequent 1's
			sb = new StringBuilder(sb.substring(0, lastValidOne)).append("01").append(ones);
			while(sb.length() < n) {
				sb.append('0');
			}
			//add this combo to the array
			combos[index] = sb.toString();
		}
		
		
		/*
		1000 0100 0010 0001
		1100 1010 1001 0110 0101 0011
		1110 1101 1011 0111
		
		11100 11010 11001 10110 10101 10011 01110 01101 01011 00111
		*/
		return combos;
	}
	
	public static int factorial(int num) {
		return factorial(num, 1);
	}
	
	public static int factorial(int num, int result) {
		if(num == 0) return 1;
		if(num == 1) return result;
		return factorial(num-1, result*num);
	}

}
