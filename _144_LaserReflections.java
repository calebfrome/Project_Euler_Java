/* Solution is 354 */

public class _144_LaserReflections {

	public static void main(String[] args) {
		double xA = 0.0;
		double yA = 0.0;
		double xB = 0.0;
		double yB = 10.1;
		double xC = 1.4;
		double yC = -9.6;
		double m1, m2, mP;
		int count = 0; //actually starts at 1 but the last "bounce" is the escape, so it doesn't count
		do {
			//shift points and recompute slopes
			xA = xB;
			yA = yB;
			xB = xC;
			yB = yC;
			m1 = (yB - yA)/(xB - xA);
			mP = yB/(4*xB);
			m2 = Math.tan((2*Math.atan(mP) - Math.atan(m1)));
			xC = (m2*m2*xB - m2*yB + 2*Math.sqrt(25*m2*m2 - m2*m2*xB*xB + 2*m2*xB*yB - yB*yB + 100))/(m2*m2 + 4);
			if(Math.abs(xC - xB) < 0.001) {
				xC = (m2*m2*xB - m2*yB - 2*Math.sqrt(25*m2*m2 - m2*m2*xB*xB + 2*m2*xB*yB - yB*yB + 100))/(m2*m2 + 4);
			}
			yC = m2*(xC - xB) + yB;
			System.out.println(++count + ": " + xC + "," + yC);
		} while(Math.abs(xC) > 0.01 || yC <= 0);
	}

}
