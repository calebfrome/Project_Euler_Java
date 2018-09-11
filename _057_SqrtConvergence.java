import java.math.BigInteger;

public class _057_SqrtConvergence {

	public static void main(String[] args) {
		BigInteger n_prev = new BigInteger("3");
		BigInteger d_prev = new BigInteger("2");
		BigInteger n_cur;
		BigInteger d_cur;
		int iterations = 1;
		int count = 0;
		while(iterations++ < 1000) {
			d_cur = n_prev.add(d_prev);
			n_cur = d_prev.add(d_cur);
			if(String.valueOf(n_cur).length() > String.valueOf(d_cur).length()) {
				count++;
			}
			System.out.println(n_cur + "/" + d_cur);
			n_prev = n_cur;
			d_prev = d_cur;
		}
		System.out.println("The solution is " + count);
	}

}
