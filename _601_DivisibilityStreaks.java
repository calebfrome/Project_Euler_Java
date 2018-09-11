import java.math.BigInteger;

/*
1 -> 1
2 -> 5
3 -> 5
4 -> 17
5 -> 0
6 -> 59
7 -> 20
8 -> 52
9 -> 0
10 -> 379
11 -> 0
12 -> 559
13 -> 0
14 -> 0
15 -> 1490
16 -> 5609
17 -> 0
18 -> 5313
13509 through 18
*/


public class _601_DivisibilityStreaks {

	public static void main(String[] args) {		
		int sum = 0;
		int tmp;
		BigInteger four = new BigInteger("4");
		//System.out.println(P(3,new BigInteger("14")));
		//System.out.println(P(6,new BigInteger("10").pow(6)));
		for(int i=20; i<=31; i++) {
			tmp = P(i, four.pow(i));
			sum += tmp;
			System.out.println(i + " -> " + tmp);
		}
		System.out.println("Sum: " + sum);
	}
	
	public static int P(int streakLevel, BigInteger maxN) {
		int numStreaks = 0;
		BigInteger n = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		for(; n.compareTo(maxN) == -1; n = n.add(one)) {
			if(n.intValue()%1000000 == 0)
				System.out.println(n.toString());
			if(streak(n).intValue() == streakLevel)
				numStreaks++;
		}
		return numStreaks;
	}
	
	
	public static BigInteger streak(BigInteger n) {
		BigInteger k = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		BigInteger r;
		while(true) {
			r = (n.add(k)).remainder((k.add(one)));
			if(r.intValue() != zero.intValue())
				return k;
			k = k.add(one);
		}
	}
}
