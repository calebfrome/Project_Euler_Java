/* Answer is 21124 */

public class _017_NumberLetters {

	public static void main(String[] args) {
		
		int first9=36;
		int first19=106;
		int twenty=6;
		int thirty=6;
		int forty=5;
		int fifty=5;
		int sixty=5;
		int seventy=7;
		int eighty=6;
		int ninety=6;
		int hundred=7;
		int andHundred=10;
		int oneThousand=11;
		
		int twenties=10*twenty+first9;
		int thirties=10*thirty+first9;
		int forties=10*forty+first9;
		int fifties=10*fifty+first9;
		int sixties=10*sixty+first9;
		int seventies=10*seventy+first9;
		int eighties=10*eighty+first9;
		int nineties=10*ninety+first9;
		
		int first99 = (first19+twenties+thirties+forties+fifties+sixties+seventies+eighties+nineties);
		int total = (10*first99)+(100*first9)+(9*hundred)+(891*andHundred)+oneThousand;
		
		System.out.println(total);
	}

}
