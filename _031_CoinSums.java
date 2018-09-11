/* Answer is 73682 */ 

import java.util.ArrayList;

public class _031_CoinSums {

	static ArrayList<Integer> coins;
	static int coinVals[] = {200,100,50,20,10,5,2,1};
	
	public static void main(String[] args) {
		coins = new ArrayList<Integer>();
		coins.add(200);
		int combos = 1;
		while(coins.get(0) != 1) {
			generateCombo();
			combos++;
		}
		System.out.println("Total combinations = " + combos);
	}
	
	public static void generateCombo() {
		int index = 0, sum = 0, rem = 0;
		int splitIndex = coins.size() - 1;
		while(coins.get(splitIndex) == 1) {
			coins.remove(splitIndex);
			splitIndex--;
		}
		while(coinVals[index] != coins.get(splitIndex)) index++;
		coins.set(splitIndex, coinVals[index+1]);
		for(int i=0; i<coins.size(); i++) {
			sum += coins.get(i);
		}
		index++;
		while(sum < 200) {
			rem = 200 - sum;
			while(coinVals[index] > rem) index++;
			coins.add(coinVals[index]);
			sum += coinVals[index];
		}
		if(splitIndex <= 5) {
			for(int j=0; j<coins.size(); j++) {
				System.out.print(coins.get(j) + " ");
			}
			System.out.println();
		}
	}

}
