
public class _027_QuadraticPrimes {

	public static void main(String[] args) {
		int n;
		int maxCount = 0;
		int ab = 0;
		for(int a=-999; a<1000; a++) {
			for(int b=-1000; b<=1000; b++) {
				n=0;
				while(true) {
					if(Primes.isPrime(n*n + a*n + b)) {
						n++;
					}
					else break;
				}
				if(n > maxCount) {
					maxCount = n;
					ab = a*b;
				}
			}
		}
		System.out.println("Max Count = " + maxCount);
		System.out.println("AB = " + ab);
		
		
	}

}
