
public class _023_NonAbundantSums {

	public static void main(String[] args) {
		int[] abundants = new int[28124];
		int pos=0;
		for(int i=1;i<=28123;i++) {
			if(isAbundant(i)) {
				abundants[pos++]=i;
				//System.out.println(i);
			}
		}
		int sum=0;
		for(int i=1;i<=28123;i++) {
			if(!isAbundantSum(i, abundants)) {
				sum+=i;
				//System.out.println(i);
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isAbundant(int x) {
		int sum=0;
		for(int i=1;i<=(x/2);i++) {
			if(x%i == 0)
				sum+=i;
		}
		return sum>x;
	}
	
	public static boolean isAbundantSum(int x,int[] abundants) {
		for(int pos1=0;abundants[pos1]<x && pos1<28124;pos1++) {
			for(int pos2=0;pos2<28124;pos2++) {
				if(abundants[pos1]+abundants[pos2]==x)
					return true;
			}
		}
		return false;
	}
}
