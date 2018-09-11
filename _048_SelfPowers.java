
public class _048_SelfPowers {

	public static void main(String[] args) {
		long modSum = 0;
		Long mod = new Long("10000000000");
		for(int n=1; n<1000; n++) {
			modSum += modExponent(n, n, mod);
			//System.out.println(modSum);
		}
		System.out.println("Solution is "+ (modSum % mod));
	}
	
	public static long modExponent(int base, int exp, long mod) {
		long result = 1;
		for(int e=1; e<=exp; e++) {
			result = (result * base) % mod;
		}
		return result;
	}

}
