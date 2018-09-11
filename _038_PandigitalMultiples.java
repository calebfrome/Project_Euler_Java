import java.util.Arrays;

public class _038_PandigitalMultiples {

	public static void main(String[] args) {
		int maxPCP = 0;
		for(int n=2; n<=9; n++) {
			for(int num=1; num<Math.pow(10, 9/n); num++) {
				if(PCP(num, n) > maxPCP) {
					maxPCP = PCP(num,n);
					System.out.println(num + " " + n + " " + maxPCP);
				}
			}
		}
		System.out.println(maxPCP);
	}
	
	public static int PCP(int num, int n) {
		String s = "";
		for(int i=1; i<=n; i++) {
			s += String.valueOf(num*i);
		}
		if(isPandigital(s))
			return Integer.valueOf(s);
		else return 0;
	}
	
	public static boolean isPandigital(String s) {
		if(s.length() != 9) {
			return false;
		}
		int[] vals = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			vals[i] = Integer.valueOf(s.substring(i,i+1));
		}
		Arrays.sort(vals);
		return is1to9(vals);
	}
	
	public static boolean is1to9(int[] vals) {
		for(int i=0; i<vals.length; i++) {
			if(vals[i] != i+1) {
				return false;
			}
		}
		return true;
	}

}
