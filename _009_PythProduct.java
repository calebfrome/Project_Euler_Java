/** PROBLEM 9
*There exists one pythagorean triple where a+b+c=1000. Find product abc.
*ANSWER: a=200 b=375 c=425   abc=31875000
*/

public class _009_PythProduct {

	public static void main(String[] args) {
		int a=1;
		int b=1;
		int c=1;
		boolean solved=false;
		
		for(a=1;a<1000 || !solved;a++) {
			for(b=1;b<1000 || !solved;b++) {
				c=1000-a-b;
				if(a*a+b*b==c*c) {
					solved=true;
					System.out.println(a+"  "+b+"  "+c+"  "+(a*b*c));
				}
			}
		}

	}

}
