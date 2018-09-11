public class _046_GoldbachOther {

	public static void main(String[] args) {
		int n = 3;
		boolean flag = false;
		
		while(true) {
			n += 2;
			while(Primes.isPrime(n)) {
				n += 2;
			}
			System.out.println(n); //debug
			for(int i=1; i*i < n; i++) {
				if(Primes.isPrime(n - 2*i*i)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println(n + " disproves the conjecture.");
				return;
			}
			flag = false;
		}

	}

}
