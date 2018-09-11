import java.util.ArrayList;

public class _051_PrimeDigitReplacements {

	static ArrayList<Integer> primes = Primes.createArrayPrimesBelow(1000000);
	
	public static void main(String[] args) {
		int n = 120303;
		int fam = 0;
		while(n++ > 0) {
			fam = family(String.valueOf(n), 8);
			if(fam > 0) {
				System.out.println(fam);
				return;
			}
		}
	}
	
	public static int family(String num, int famSize) {
		int[] pattern;
		int[] fam = new int[10];
		int famIndex = 0;
		int famCount;
		int lowFam = 0;
		int minLowFam = 0;
		int temp = 0;
		StringBuilder sb = new StringBuilder("");
		//check all patterns except (0)* (from i=0 - same number) and  (1)* (entirely new number)
		for(int i=1; i<Math.pow(2, num.length())-1; i++) { 
			pattern = toBinary(i, num.length());
			famCount = 0;
			famIndex = 0;
			lowFam = 0;
			for(int digit=0; digit<=9; digit++) {
				sb = new StringBuilder(num);
				for(int j=0; j<num.length(); j++) {
					if(pattern[j] == 1)
						sb.setCharAt(j, Character.forDigit(digit, 10));
				}
				temp = Integer.valueOf(sb.toString());
				if(Primes.isPrime(temp) && sb.charAt(0) != '0') {
					fam[famIndex++] = temp;
					famCount++;
					if(lowFam == 0) lowFam = temp;
					else lowFam = Math.min(lowFam, temp);
				}
			}
			if(famCount == 8) {
				System.out.println(num + ": ");
				for(int f: fam) {
					System.out.println(f);
				}
				if(minLowFam == 0) minLowFam = lowFam;
				else minLowFam = Math.min(minLowFam, lowFam);
				lowFam = 0;
			}
		}
		return minLowFam;
	}
	
	public static int[] toBinary(int decNum, int length) {
		int i = 1;
		int divisor = 1;
		while(divisor*2 <= decNum) {
			divisor = (int) Math.pow(2, i++);
		}
		int binNum[] = new int[length];
		i=length-i;
		while(divisor >= 1) {
			binNum[i++] = decNum/divisor;
			decNum %= divisor;
			divisor /= 2;
		}
		return binNum;
	}
}
