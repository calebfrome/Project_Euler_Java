import java.util.Arrays;

public class _052_PermutedMultiples {

	public static void main(String[] args) {	
		long n=999;
		int quotient = 10;
		boolean flag = true; //true if we found the answer
		while(n++ > 0) {
			//n must be in the range of 100* to 167* | * = 10^k
			if(n % 167 == 0 && n/167 == quotient) {
				n = (n/167)*1000;
				quotient *= 10;
			}
			System.out.println(n);
			for(int i=2; i<=6; i++) {
				if(!permMultiple(n, i)) {
					flag = false;
					break;
				}
				System.out.println(n + ": " + i + " works");
			}
			if(flag) {
				System.out.println("The solution is " + n);
				return;
			}
			flag = true;
		}
	}
	
	public static boolean permMultiple(long num, int multiplier) {
		String s1 = String.valueOf(num);
		String s2 = String.valueOf(num*multiplier);
		int[] vals1 = new int[s1.length()];
		int[] vals2 = new int[s2.length()];
		for(int i=0; i<s1.length(); i++) {
			vals1[i] = Integer.valueOf(s1.substring(i,i+1));
			vals2[i] = Integer.valueOf(s2.substring(i,i+1));
		}
		Arrays.sort(vals1);
		Arrays.sort(vals2);
		for(int i=0; i<vals1.length; i++) {
			if(vals1[i] != vals2[i]) return false;
		}
		return true;
	}

}
