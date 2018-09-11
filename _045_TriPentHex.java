/* Solution is 1533776805 */

public class _045_TriPentHex {

	public static void main(String[] args) {
		long n_tri=1, n_pent=1, n_hex=1;
		long tri=0, pent=0, hex=0;
		int count = 0;
		
		while(count < 3) {
			//generate next tri
			tri = n_tri*(n_tri+1)/2;
			if(n_tri % 10000000 == 0) System.out.println(n_tri);
			n_tri++;
			//generate pent until match or pass
			while(pent < tri) {
				pent = n_pent*(3*n_pent-1)/2;
				n_pent++;
			}
			//if match, generate hex until match or pass
			if(pent == tri) {
				while(hex < tri) {
					hex = n_hex*(2*n_hex - 1);
					n_hex++;
				}
				if(hex == tri) {
					count++;
					System.out.println(tri);
				}
			}	
		}
	}

}
