/* Answer is 5482660 */

import java.util.ArrayList;

public class _044_PentagonalNumbers {
	
	public static void main(String[] args) {
		ArrayList<Integer> pnums = new ArrayList<Integer>();
		pnums.add(1);
		int D = 0;
		int curN = 2;
		
		while(D==0 || D>=(3*pnums.size()-2)) {
			while(curN*3 > pnums.size()) {
				pnums.add((pnums.size()+1)*(3*(pnums.size()+1)-1)/2);
				//System.out.println("\t\t"+pnums.get(pnums.size()-1));
			}
			for(int i=0; i<curN; i++) {
				if(pnums.contains(pnums.get(i)+pnums.get(curN))) {
					if(pnums.contains(pnums.get(curN)-pnums.get(i))) {
						D = pnums.get(curN) - pnums.get(i);
						System.out.println(pnums.get(i) + " " + pnums.get(curN) + " " + D);
					}
				}
			}
			curN++;
			System.out.println(curN);
		}
	}
}
