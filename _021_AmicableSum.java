
public class _021_AmicableSum {

	public static void main(String[] args) {
		int sum=0;
		int[] sums=new int[10001];
		for(int i=1;i<=10000;i++) {
			sums[i]=factorSum(i);
		}
		for(int i=1;i<=10000;i++) {
			if(sums[i]<=10000) {
				if(sums[sums[i]]==i && i!=sums[i]) {  //sums[i]=b and sums[b]=i
					sum+=(i);
					System.out.println(i+" "+sums[i]);
				}
			}
		}
		System.out.println(sum);
	}

	public static int factorSum(int num) {
		int sum=0;
		for(int i=1;i<=(num/2);i++) {
			if(num%i == 0) {
				sum+=i;
				//System.out.println(i);
			}
		}
		return sum;
	}



}
