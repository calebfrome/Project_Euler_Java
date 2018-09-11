/* Answer is 210 */

public class _040_ChampsConstant {

	public static void main(String[] args) {
		int product = 1;
		int count = 0;
		int threshold = 1;
		int index = 0;
		Integer i = 0;
		while(threshold <= 1000000) {
			count += (++i).toString().length();
			if(count >= threshold) {
				index = i.toString().length() - (count-threshold+1);
				product *= Integer.valueOf(i.toString().substring(index, index+1));
				threshold *= 10;
			}
		}
		System.out.println(product);
	}

}
