import java.math.BigInteger;

public class _055_LychrelNumbers {

	public static void main(String[] args) {
		int numLychrels = 0;
		for(int n=1; n<10000; n++) {
			if(isLychrel(n)) {
				System.out.println(n);
				numLychrels++;
			}
		}
		System.out.println(numLychrels);
	}
	
	public static boolean isLychrel(Integer n) {
		BigInteger bi = new BigInteger(n.toString());
		for(int iteration = 0; iteration < 50; iteration++) {
			bi = bi.add(reverse(bi.toString()));
			if(isPalindrome(bi.toString()))
				return false;
		}
		
		return true;
	}
	
	public static BigInteger reverse(String s) {
		String rev = "";
		for(int i=s.length()-1; i>=0; i--) {
			rev += s.charAt(i);
		}
		
		return new BigInteger(rev);
	}
	
	public static boolean isPalindrome(String s) {
		int index = 0;
		while(index < s.length()-index) {
			if(s.charAt(index) != s.charAt(s.length()-1-index)) {
				return false;
			}
			index++;
		}
		return true;
	}

}
