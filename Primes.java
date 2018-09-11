import java.util.ArrayList;

public class Primes {
	
	/**
	 * Tests whether an integer is prime
	 * 
	 * @param value The value to be tested for primeness
	 * @return True if value is prime; false if value is composite
	 */
	public static boolean isPrime(int value) {
		if(value <= 1)
			return false;
		boolean isPrime=true;
		for(int divisor=(int)Math.sqrt(value);divisor>=2;divisor--) {
			if(value%divisor==0)
				isPrime=false;
		}
		return isPrime;
	}
	
	/**
	 * Creates an array of the first (specified number of) prime numbers
	 * 
	 * @param numPrimes The number of primes to include in the array
	 * @return An array containing the first n primes
	 */
	public static int[] createArrayNumPrimes(int numPrimes) {
		int[] primes = new int[numPrimes];
		primes[0]=2;
		int value=3;
		for(int i=1;i<numPrimes;i++) {
			if(isPrime(value)==true) {
				primes[i]=value;
			}
			else
				i--; //keep same array position if no number is added
			value+=2; //test every odd number
		}
		return primes;
	}
	
	/**
	 * Finds the nth prime by testing every integer starting at 2
	 * 
	 * @param n The index of the list of primes corresponding to the desired prime 
	 * @return the nth prime
	 */
	public static int nthPrime(int n) {
		int[] primes = createArrayNumPrimes(n);
		int result=primes[n-1];
		return result;
	}
	
	
	/**
	 * Sums all the primes less than or equal to a given number
	 * 
	 * @param max The highest number that can be included in the summation
	 * @return The sum of all primes less than or equal to max
	 */
	public static long sumPrimesMax(int max) {
		long sum=0;
		long[] primes = new long[max/2]; //create oversized array
		primes[0]=2;
		long value=3;
		int i;
		for(i=1;value<=max;i++) {
			if(isPrime((int)value)==true) {
				primes[i]=value;
			}
			else
				i--; //keep same array position if no number is added
			value+=2; //test every odd number
		}
		for(int j=0;j<i;j++) {
			sum+=primes[j];
			//System.out.println(j+1+": "+primes[j]+"    "+sum); //debug
		}
		return sum;
	}
	
	/**
	 * Sums the first n primes
	 * 
	 * @param n The number of primes to be summed
	 * @return The sum of the first n primes
	 */
	public static int sumNPrimes(int n) {
		int[] primeArray = createArrayNumPrimes(n);
		int sum=0;
		for(int p:primeArray) {
			sum+=p;
		}
		return sum;
	}
	
	/**
	 * Creates an array of all primes less than or equal to a given number
	 * @param ceiling The maximum value of the primes to be listed
	 * @return An array containing all primes <= ceiling
	 */
	public static ArrayList<Integer> createArrayPrimesBelow(int ceiling) {
		ArrayList<Integer> primesArray = new ArrayList<Integer>();
		primesArray.add(2);
		for(int i=3;i<=ceiling;i+=2) {
			if(isPrime(i)) {
				primesArray.add(i);
			}
		}
		return primesArray;
	}
	
	/**
	 * Creates an array of all primes in a given range
	 * @param floor The minimum value of the primes to be listed
	 * @param ceiling The maximum value of the primes to be listed
	 * @return An array containing all primes in the range [floor, ceiling]
	 */
	public static ArrayList<Integer> createArrayPrimes(int floor, int ceiling) {
		ArrayList<Integer> primesArray = new ArrayList<Integer>();
		if(floor <= 2)
			primesArray.add(2);
		if(floor % 2 == 0)
			floor++;
		for(int i=floor;i<=ceiling;i+=2) {
			if(isPrime(i)) {
				primesArray.add(i);
			}
		}
		return primesArray;
	}
}
