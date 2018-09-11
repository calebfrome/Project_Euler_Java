
public class _058_SpiralPrimes {

	public static void main(String[] args) {
		int squareSide = 1;
		int numPrimes = 0;
		int numDiags = 1;
		do {
			for(int i=1; i<=4; i++) {
				if(Primes.isPrime(squareSide*squareSide + (squareSide+1)*i)) {
					numPrimes++;
				}
			}
			numDiags += 4;
			squareSide+=2;
		} while(((double)numPrimes)/numDiags >= 0.1);
		System.out.println(squareSide);
	}

}
