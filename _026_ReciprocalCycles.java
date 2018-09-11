import java.math.BigDecimal;

public class _026_ReciprocalCycles {

	public static void main(String[] args) {
		int maxCycles = 0;
		int tempCycles = 0;
		int maxNum = 0;
		for(Integer d = 2; d < 1000; d++) {
			tempCycles = numRecipCycles(d);
			System.out.println(d + ": " + tempCycles);
			if(tempCycles > maxCycles) {
				maxCycles = tempCycles;
				maxNum = d;
			}
		}
		System.out.println("Max is " + maxNum + ": " + maxCycles);
		
	}
	
	public static int numRecipCycles(Integer d) {
		int numCycles = 0;
		int cycleCount;
		boolean cycleFound = false;
		int index1;
		int index2;
		int multiplier;
		BigDecimal num = new BigDecimal("1");
		num.setScale(2000);
		BigDecimal denom = new BigDecimal(d.toString());
		denom.setScale(2000);
		BigDecimal bd = num.divide(denom,2000,BigDecimal.ROUND_HALF_UP);
		String str = bd.toString();
		str = str.substring(str.indexOf("."),str.length());
		while(str.charAt(str.length()-1) == '0') {
			str = str.substring(0,str.length()-1);
		}
		
		index1 = 0;
		
		for(int crop=0; crop<9500; crop++) {
		
			if(str.length() > 1)
				str = str.substring(1,str.length());
			else break;
			
			cycleCount=0;
		
			while(++cycleCount <= str.length()/2) {
				index1 = 0;
				index2 = cycleCount;
				multiplier = 1;
				if(cycleCount < 4) {
					multiplier += (5-cycleCount);
				}
				while(index1 < Math.min(cycleCount*multiplier, str.length()-cycleCount-1)) {
					cycleFound = true;
					//find a cycle that repeats twice
					if(str.charAt(index1++) != str.charAt(index2++)) {
						cycleFound = false;
						break;
					}
				}
				
				if(cycleFound) {
					numCycles = cycleCount;
					break;
				}
			}
			if(numCycles > 0) break;
		}
		
		return numCycles;
	}

}
