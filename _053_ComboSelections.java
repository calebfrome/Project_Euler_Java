
public class _053_ComboSelections {

	public static void main(String[] args) {
		int count = 0;
		double c;
		int n_temp;
		int r_temp;
		int nr_temp;
		for(int n=1; n<=100; n++) {
			for(int r=1; r<=n; r++) { //r=0 is valid but always = 1
				c = 1;
				n_temp = n;
				r_temp = r;
				nr_temp = n-r;
				while(n_temp > 0 || r_temp > 0 || nr_temp > 0) {
					if(n_temp == r_temp) {
						n_temp = r_temp = 0;
					}
					if(c < 1000000 && n_temp > 0) {
						c *= (n_temp--);
					}
					else if (r_temp > 0) {
						c /= (r_temp--);
					}
					else if (nr_temp > 0) {
						c /= (nr_temp--);
					}
					if(r_temp == 0 && nr_temp == 0 && c > 1000000) {
						break;
					}
				}
				if(c > 1000000) {
					count++;
				}
			}
		}

		System.out.println("Solution is " + count);
	}
	
	public static int factorial(int num) {
		return factorial(num, 1);
	}
	
	public static int factorial(int num, int result) {
		if(num == 0) return 1;
		if(num == 1) return result;
		return factorial(num-1, result*num);
	}

}
