import java.util.ArrayList;

public class _050_ConsecPrimeSum {

	public static void main(String[] args) {
		ArrayList<Integer> primes = Primes.createArrayPrimesBelow(10000);
		int sum = 0;
		int maxLen = 0;
		while(sum <= 1000000) {
			sum += primes.get(maxLen++);
		}
		//iterate over all chain lengths from large to small
		for(int length=maxLen; length>2; length--) {
			//iterate (by start index) over all chains of this length
			for(int chain=0; chain<=maxLen-length; chain++) {
				//check one chain
				for(int j=chain; j<chain+length; j++) {
					sum += primes.get(j);
				}
				if(Primes.isPrime(sum)) {
					System.out.println("Max chain prime is " + sum);
					return;
				}
				sum = 0;
			}
		}
	}
}
