import java.util.ArrayList;
import java.util.Arrays;

public class _032_PandigitalProducts {

	public static void main(String[] args) {
		ArrayList<Integer> panProducts = new ArrayList<Integer>();
		int sum = 0;
		for(int f1=1; f1<10000; f1++) {
			for(int f2=0; f2<10000; f2++) {
				if(isPandigital(f1,f2)) {
					System.out.println(f1 + " * " + f2 + " = " + (f1*f2));
					if(!panProducts.contains(f1*f2)) {
						panProducts.add(f1*f2);
						sum += f1*f2;
					}
				}
			}
		}
		System.out.println("Sum = " + sum);
	}
	
	public static boolean isPandigital(Integer f1, Integer f2) {
		String s = f1.toString() + f2.toString() + ((Integer)(f1*f2)).toString();
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
