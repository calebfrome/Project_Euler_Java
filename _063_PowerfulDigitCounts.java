import java.math.BigInteger;

public class _063_PowerfulDigitCounts {

	public static void main(String[] args) {
		BigInteger num = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		int numDigits = 0;
		int count = 0;
		BigInteger base;
		BigInteger minBase = new BigInteger("1");
		boolean minFlag = true;
		
		while(true) {
			System.out.println(++numDigits + " digits:");
			base = minBase;
			minFlag = true;
			do {
				num = base.pow(numDigits);
				if(getNumDigits(num) == numDigits) {
					System.out.println(++count + ": " + num + " = " + base + "^" + numDigits);
					if(minFlag) {
						minBase = base;
						minFlag = false;
					}
				}
				base = base.add(one);
			} while(getNumDigits(num) <= numDigits);
			if(minFlag) break; //stop if we didn't find a result for this number of digits
		}
	}
	
	public static int getNumDigits(BigInteger n) {
		int numDigits = 1;
		BigInteger compare = new BigInteger("10");
		while(n.compareTo(compare) >= 0) {
			compare = compare.multiply(new BigInteger("10"));
			numDigits++;
		}
		return numDigits;
	}

}
