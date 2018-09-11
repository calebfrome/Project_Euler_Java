import java.util.ArrayList;

public class _033_CuriousFractions {

	public static void main(String[] args) {
		int numProduct = 1;
		int denomProduct = 1;
		for(int denom=10; denom<=99; denom++) {
			for(int num=10; num<denom; num++) {
				if(isCurious(num,denom)) {
					System.out.println(num + "/" + denom);
					numProduct *= num;
					denomProduct *= denom;
				}
			}
		}
		System.out.println("Answer is: " + simplify(numProduct, denomProduct));
	}
	
	public static boolean isCurious(Integer nr, Integer dr) {
		String n;
		String d;
		StringBuilder sb_n;
		StringBuilder sb_d;
		for(Integer i=1; i<=9; i++) {
			n = nr.toString();
			d = dr.toString();
			if(n.contains(i.toString()) && d.contains(i.toString())) {
				sb_n = new StringBuilder(n);
				sb_d = new StringBuilder(d);
				n = sb_n.deleteCharAt(n.indexOf(i.toString())).toString();
				d = sb_d.deleteCharAt(d.indexOf(i.toString())).toString();
				if(Integer.valueOf(n)/Integer.valueOf(d).floatValue() == nr/(float)dr) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	//simplify the fraction n/d and return the denominator
	public static int simplify(int n, int d) {
		ArrayList<Integer> primesArray = Primes.createArrayPrimesBelow((int)Math.sqrt(n));
		for(int p : primesArray) {
			while(n%p == 0 && d%p == 0) {
				n /= p;
				d /= p;
			}
		}
		return d;
	}

}
