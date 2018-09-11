
public class _039_IntegerRightTriangles {

	public static void main(String[] args) {
		int maxSolutions = 0;
		int maxP = 0;
		for(int p=3; p<=1000; p++) {
			if(numSolutions(p) > maxSolutions) {
				maxSolutions = numSolutions(p);
				maxP = p;
				System.out.println(maxP + ": " + maxSolutions);
			}
		}
		System.out.println("Maximum occurs at p=" + maxP + " (" + maxSolutions + ")");
	}
	
	public static int numSolutions(int p) {
		int numSolutions = 0;
		for(int a=1; a<(p/3); a++) {
			for(int b=a; b<(p/2); b++) {
				if(a*a + b*b == (p-a-b)*(p-a-b)) {
					numSolutions++;
				}
			}
		}
		return numSolutions;
	}

}
