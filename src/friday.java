import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
ID: SohanA
LANG: JAVA
TASK: friday
*/




public class friday {
	//Constants
	static final int BASE_YEAR = 1900;
	static final int iTC = 12;
	static final int[] monthLengths = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	public static void main(String[] args) {
		try {
			int[] scoreboard = new int[7];
			BufferedReader br = new BufferedReader(new FileReader("friday.in"));
			int N = Integer.valueOf(br.readLine());
			br.close();
			int endYear = BASE_YEAR+N-1;
			int currentYear = BASE_YEAR;
			int month = 0;
			Day currentDay = new Day();
			while(currentYear <= endYear) {
				scoreboard[currentDay.incrementedBy(iTC).getIndex()]++;
				currentDay.incrementBy(getDays(month, currentYear));
				month++;
				if(month >= 12) {
					month = 0;
					currentYear++;
				}
			}
			String returnString = Arrays.toString(scoreboard).replaceAll("\\[|\\]", "").replaceAll(", ", " ");
			PrintWriter pw = new PrintWriter(new FileWriter("friday.out", true));
			pw.println(returnString);
			pw.close();
}
		catch(FileNotFoundException e) {
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int getDays(int month, int year) {
		
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			if(month == 1) {
				return 29;
			}
		}
		
		return monthLengths[month];
	}
	
}


class Day {
	static enum Days {
		SATURDAY(0), SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6);
		private final int index;
		Days(int index) {
			this.index = index;
		}
		public int getIndex() {
			return index;
		}
	}
	
	private Days current = Days.MONDAY;
	
	public Days incrementedBy(int num) {
		return getDayFromIndex((current.getIndex()+num)%7);
	}
	public void incrementBy(int num) {
		current = getDayFromIndex((current.getIndex()+num)%7);
	}
	
	private static Days getDayFromIndex(int ind) {
		switch(ind) {
		case 0:
			return Days.SATURDAY;
		case 1:
			return Days.SUNDAY;
		case 2:
			return Days.MONDAY;
		case 3:
			return Days.TUESDAY;
		case 4:
			return Days.WEDNESDAY;
		case 5:
			return Days.THURSDAY;
		case 6:
			return Days.FRIDAY;
		default:
			return null;
		}
	}
}
