
public class _034_DigitFactorials {

	public static void main(String[] args) {
		int sumDF = 0;
		for(int num=3; num<100000; num++) {
			if(isSumDF(num)) {
				System.out.println(num);
				sumDF += num;
			}
		}
		System.out.println("Sum: " + sumDF);
	}
	
	public static boolean isSumDF(int n) {
		String s = String.valueOf(n);
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			sum += factorial(Character.getNumericValue(s.charAt(i)));
		}
		return sum == n;
	}
	
	public static int factorial(int n) {
		int ret = 1;
		while(n > 1) {
			ret *= n--;
		}
		return ret;
	}

}
