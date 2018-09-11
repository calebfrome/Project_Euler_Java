
public class _019_CountingSundays {

	public static void main(String[] args) {
		int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] monthDaysLeap = {31,29,31,30,31,30,31,31,30,31,30,31}; 
		
		int numSundays = 0;
		int numDays = 366; //offset because monday
		
		for(int year = 1901; year<=2000; year++) {
			for(int month = 0; month<12; month++) {
				if(isLeapYear(year)) {
					numDays += monthDaysLeap[month];
				}
				else {
					numDays += monthDays[month];
				}
				
				if(numDays % 7 == 0) {
					numSundays++;
				}
			}
		}
		
		System.out.println(numSundays);
	}
	
	public static boolean isLeapYear(int year) {
		return ((year % 100 != 0) && (year % 4 == 0)) || (year % 400 == 0);
	}

}
