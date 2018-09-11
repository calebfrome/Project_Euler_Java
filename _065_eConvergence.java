import java.math.BigInteger;

public class _065_eConvergence {

	public static void main(String[] args) {
		int digitSum = 0;
		BigInteger n_cur = new BigInteger("0");
		BigInteger d_cur = new BigInteger("0");
		BigInteger n_prev = new BigInteger("2");
		BigInteger d_prev = new BigInteger("1");
		BigInteger n_prev_2 = new BigInteger("1");
		BigInteger d_prev_2 = new BigInteger("0");
		int multiplier;
		for(int i=0; i<33; i++) {
			for(int j=0; j<3; j++) {
				if(j==1) {
					multiplier = (i+1)*2;
				}
				else multiplier = 1;
				n_cur = n_prev.multiply(new BigInteger(String.valueOf(multiplier))).add(n_prev_2);
				d_cur = d_prev.multiply(new BigInteger(String.valueOf(multiplier))).add(d_prev_2);
				n_prev_2 = n_prev;
				d_prev_2 = d_prev;
				n_prev = n_cur;
				d_prev = d_cur;
			}
		}
		String num = n_cur.toString();
		for(int k=0; k<num.length(); k++) {
			digitSum += Integer.valueOf(num.substring(k, k+1));
		}
		System.out.println(digitSum);
	}

}
