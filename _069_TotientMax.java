import java.util.ArrayList;

public class _069_TotientMax {

	static ArrayList<Integer> primes = Primes.createArrayPrimesBelow(10000000);
	
	public static void main(String[] args) {
		double ntMax = 0.0;
		double nt = 0.0;
		int nMax = 0;
		int n = 2;
		int i = 1;
		while(n <= 1000000) {
			if(n % 1000 == 0)
				System.out.println(n);
			nt = ((double)n)/totient(n);
			if(nt > ntMax) {
				ntMax = nt;
				nMax = n;
				System.out.println("Found new max n/t: " + ntMax + " at n=" + nMax);
			}
			n *= primes.get(i++);
		}
		System.out.println("n/t is maximized at n=" + nMax + " | nt = " + ntMax);
	}
		
	public static int totient(int x) {
		int numRP = 0;
		boolean flag = true;
		for(int y=1; y<x; y++) {
			for(int i=0; i<(x/2); i++) {
				if(x % primes.get(i) == 0 && y % primes.get(i) == 0) {
					flag = false;
					break;
				}
			}
			if(flag) numRP++;
			flag = true;
		}
		
		return numRP;
	}

}
