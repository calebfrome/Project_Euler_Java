
public class _025_1000DigitFibonacci {
	
	//public static long[] number;
	//public static long[] number_1;
	//public static long[] number_2;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//each long will be 8 digits so that when two are added the result is at most 9 and thus guaranteed to be in bounds
		
		int size = 1000/8 + 1;
		long[] number = new long[size];
		for(long l:number) {
			l=0;
		}
		long[] number_1 = new long[size];
		for(long l:number_1) {
			l=0;
		}
		long[] number_2 = new long[size];
		for(long l:number_2) {
			l=0;
		}
		number[number.length-1] = 1;
		number_1[number.length-1] = 1;
		number_2[number.length-1] = 1;
		
		int index = 2; //when number is first computed, it is the third number in the sequence
		
		while(numDigits(number) < 1000) {
			index++;
			for(int i = 0; i<size; i++) {
				number[i] = number_1[i] + number_2[i];
			}
			for(int j=1; j<size; j++) {
				if(number[j]%100000000 != number[j]) {
					number[j-1]+=(number[j]-(number[j]%100000000))/100000000;
					number[j]%=100000000;
				}
			}
			
			//deep copy
			for(int k=0; k<size; k++) {
				number_2[k] = number_1[k];
			}
			for(int l=0; l<size; l++) {
				number_1[l] = number[l];
			}
		}
		System.out.println(index);
	}
	
	public static int numDigits(long[] num) {
		if(num[num.length-1] == 0) {
			return 0;
		}
		
		boolean startFound = false;
		int index = 0;
		int numDigits = 0;
		while(!startFound) {
			if(num[index] > 0) {
				numDigits += getSize(num[index]);
				startFound = true;
			}
			index++;
		}
		
		numDigits += (num.length - index)*8;
		return numDigits;
	}
	
	public static int getSize(long numberVal) {
		String str = String.valueOf(numberVal);
		return str.length();
	}

}
