
public class _030_DigitFifthPowers {

	public static void main(String[] args) {
		int sum = 0;
		int tempSum;
		String s;
		for(Integer num=1634; num<1000000; num++) {
			s = num.toString();
			tempSum = 0;
			for(int d=0; d<s.length(); d++) {
				tempSum += Math.pow(Character.getNumericValue(s.charAt(d)),5);
			}
			if(tempSum == num) {
				System.out.println(num);
				sum += num;
			}
		}
		System.out.println("Sum: " + sum);
	}

}
