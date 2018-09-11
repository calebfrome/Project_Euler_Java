
public class _020_FactorialDigitSum {

	public static void main(String[] args) {

		int x = 100;
		//each entry is 9 digits of the final number
		int[] factorial = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		
		//System.out.println(99*9999999);
		
		for(int i=1;i<=x;i++) {
			for(int f=0;f<25;f++) {
				factorial[f]*=i;
			}

			for(int j=1;j<=24;j++) {
				if(factorial[j]%10000000 != factorial[j]) {
					factorial[j-1]+=(factorial[j]-(factorial[j]%10000000))/10000000;
					factorial[j]%=10000000;
				}
			}
			System.out.println(i+" "+digitSum(factorial)+" "+arrayToStr(factorial));
		}
	}

	public static int digitSum(int[] f) {
		String str;
		int sum=0;
		for(Integer x:f) {
			str = x.toString();
			for(int pos=0;pos<str.length();pos++) {
				sum+=(int)str.charAt(pos)-48;
				//System.out.println(str.charAt(pos)+" "+sum);
			}
		}
		return sum;
	}
	
	//doesn't print all zeroes but that's ok!
	public static String arrayToStr(int[] f) {
		//boolean firstSection=true;
		boolean leadingZerosRemaining=true;
		String num="";
		for(int i:f) {
			if(i!=0)
				leadingZerosRemaining=false;
			if(!leadingZerosRemaining)
				num=num.concat(String.valueOf(i));
		}
		return num;
	}

}
