import java.util.ArrayList;

//good through 124300 (lowest value 0.19180979 in the 120100-120200 range)
//good from 540k - 560k
//30k testing: good through 480 (0.19180859) and 510 (0.18052571)

public class _243_Resilience {
	
	static ArrayList<Integer> primesArray = Primes.createArrayPrimesBelow((int)Math.sqrt(1000000));

	public static void main(String[] args) {
		int denom = 540000;
		double resLevel = 1.0;
		double minResLevel = 0.1918091;
		double threshold = 15499/94744.0;
		while(resLevel >= threshold) {
			resLevel = resilience(denom++);
			if(denom%100 == 0)
				System.out.println(denom);
			if(resLevel < minResLevel) {
				minResLevel = resLevel;
				System.out.println(minResLevel);
				denom += 30000;
			}
		}
		System.out.println(denom-1 + " | " + resLevel);
	}
	
	public static double resilience(int denom) {
		int numRes = 0;
		for(int num=1; num<denom; num++) {
			numRes += (isResilient(num, denom) ? 1 : 0);
		}
		return ((double)numRes)/(denom-1);
	}
	
	//a fraction is resilient iff its num and denom are relatively prime.
	public static boolean isResilient(int num, int denom) {
		for(int p : primesArray) {
			if(num%p == 0 && denom%p == 0) return false;
			if(p > denom) return false;
		}
		
		return true;
	}
}
