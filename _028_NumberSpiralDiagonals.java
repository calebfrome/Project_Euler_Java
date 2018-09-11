
public class _028_NumberSpiralDiagonals {

	public static void main(String[] args) {		
		int sum = 1;
		int count = 1;
		int multiplier = 2;
		int edgeLength = 1001;
		while(count < Math.pow(edgeLength,2)) {
			for(int i=0; i<4; i++) {
				count += multiplier;
				sum += count;
			}
			multiplier += 2;
		}
		System.out.println(sum);
		sum=1;
		for(int i=3; i<=edgeLength; i+=2) {
			sum+= i*i*4 - 3*2*(i-1);
		}
		System.out.println(sum);
	}

}
