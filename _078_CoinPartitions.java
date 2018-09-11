import java.math.BigInteger;
import java.util.ArrayList;

public class _078_CoinPartitions {

	public static void main(String[] args) {
		
		int numCoins = 1; //tested through 121, none were mod 1 million
		BigInteger million = new BigInteger("1000000");
		while(true) {
			if(numPartitions(numCoins++).mod(million).intValue() == 0) {
				break;
			}
		}
		System.out.println("The winner is: " + numCoins);
	}
	
	public static BigInteger numPartitions(Integer n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		BigInteger numPartitions = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		int index;
		int temp;
		int sum;
		for(int maxVal = n; maxVal>=1; maxVal--) {
			list.addAll(construct(n,maxVal));
			index = list.size() - 1;
			sum = 0;
			while(!list.isEmpty()) {
				temp = list.get(index);
				sum += temp;
				list.remove(index--);
				if(sum == n) {
					list.clear();
				}
				else if(temp != 1) {
					list.addAll(construct(sum,temp-1));
					numPartitions = numPartitions.add(one);
					index = list.size()-1;
					sum = 0;
				}
			}
			numPartitions = numPartitions.add(one);
		}
		//System.out.println(n + ": " + numPartitions);
		System.out.print("{"+n+","+numPartitions+"}, ");
		return numPartitions;
	}
	
	//construct a list of numbers whose sum is sum
	//using the largest possible numbers <= maxVal
	public static ArrayList<Integer> construct(int sum, int maxVal) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		while(sum > 0) {
			while(maxVal > sum) {
				maxVal--;
			}
			ret.add(maxVal);
			sum -= maxVal;
		}
		return ret;
	}
}
