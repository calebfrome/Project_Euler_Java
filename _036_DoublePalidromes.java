/* Answer is 872187 */

public class _036_DoublePalidromes {

	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<1000000; i++) {
			if(isPalindrome(String.valueOf(i)) && isPalindrome(toBinary(i))) {
				System.out.print(i + " = ");
				for(int j: toBinary(i)) {
					System.out.print(j);
				}
				System.out.println();
				sum += i;
			}
		}
		System.out.println("Sum is " + sum);
	}
	
	public static int[] toBinary(int decNum) {
		int i = 1;
		int divisor = 1;
		while(divisor*2 <= decNum) {
			divisor = (int) Math.pow(2, i++);
		}
		int binNum[] = new int[i];
		i=0;
		while(divisor >= 1) {
			binNum[i++] = decNum/divisor;
			decNum %= divisor;
			divisor /= 2;
		}
		return binNum;
	}
	
	public static boolean isPalindrome(String s) {
		for(int i=0; i<= s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome(int[] n) {
		int max = n.length-1;
		for(int i=0; i<= max/2; i++) {
			if(n[i] != n[max-i]) {
				return false;
			}
		}
		return true;
	}

}
