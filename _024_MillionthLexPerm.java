import java.util.ArrayList;


public class _024_MillionthLexPerm {

	public static void main(String[] args) {
		String num = "";
		int number = 1000000; //nth permutation
		number--; //account for 0-based system
		int numDigits = 10;
		int fBase = numDigits-1;
		int fNum = 0;
		int numReps = 0;
		while(number>0) {
			fNum = factorial(fBase);
			if(fNum <= number) {
				number -= fNum;
				numReps++;
			}
			else {
				fBase--;
				num = num + String.valueOf(numReps);
				numReps = 0;
			}
		}
		num = num + String.valueOf(numReps);
		//System.out.println(num); //debug		
		System.out.println(compute(num));
	}
	
	public static int factorial(int x) {
		int factorial = 1;
		for(int i=x;i>0;i--) {
			factorial*=i;
		}
		return factorial;
	}
	
	public static String compute(String reps) {
		String result = "";
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(0);
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		ints.add(6);
		ints.add(7);
		ints.add(8);
		ints.add(9);
		
		int chosenIndex;
		
		for(int i=0; i<reps.length(); i++) {
			chosenIndex = Integer.valueOf(String.valueOf(reps.charAt(i)));
			result += String.valueOf(ints.get(chosenIndex));
			ints.remove(ints.indexOf(ints.get(chosenIndex)));
		}
		result += String.valueOf(ints.get(0)); //exactly one number is left
		
		return result;
	}

}
