
public class _043_SubstringDivisibility {

	static long sum = 0;
	
	public static void main(String[] args) {
		permSum("0123456789");
		System.out.println("Sum is " + sum);

	}
	
	public static boolean isSpecial(String s) {
		int[] primes = {2,3,5,7,11,13,17};
		for(int i=1; i<=7; i++) {
			if(Integer.valueOf(s.substring(i,i+3)) % primes[i-1] != 0)
				return false;
		}		
		return true;
	}
	
	public static void permSum(String s) { permSum("", s); }
	
    private static void permSum(String prefix, String s) {
    	int n = s.length();
        if (n == 0) {
        	if(isSpecial(prefix)) {
        		//System.out.println(prefix);
        		long val = Long.valueOf(prefix);
        		System.out.println(val);
        		sum += val;
        	}
        }
        else {
            for (int i = 0; i < n; i++)
            	permSum(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }

    }
}
