import java.math.BigInteger;
import java.util.ArrayList;

public class _029_DistinctPowers {

	public static void main(String[] args) {
		ArrayList<BigInteger> powers = new ArrayList<BigInteger>();
		BigInteger base;
		BigInteger result;
		for(int a=2; a<=100; a++) {
			System.out.println(a);
			for(int b=2; b<=100; b++) {
				base = new BigInteger(String.valueOf(a));
				result = base.pow(b);
				if(!powers.contains(result)) {
					powers.add(result);
				}
			}
		}
		System.out.println(powers.size());
	}

}
