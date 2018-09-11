
public class _092_SquareDigitChains {

	public static void main(String[] args) {
		int count89 = 0;
		int num = 0;
		String s = "";
		for(int i=1; i<10000000; i++) {
			if(i % 1000000 == 0) System.out.println(i);
			num = i;
			while(num != 1 && num != 89) {
				s = String.valueOf(num);
				num = 0;
				for(int j=0; j<s.length(); j++) {
					num += Math.pow(Integer.valueOf(s.substring(j, j+1)), 2);
				}
			}
			if(num == 89) {
				count89++;
			}
		}
		System.out.println("The solution is " + count89);
	}

}
