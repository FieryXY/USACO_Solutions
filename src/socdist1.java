import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class socdist1 {
	static int[] bend = new int[2];
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
			PrintWriter pw = new PrintWriter(new FileWriter("socdist1.out", true));
			int N = Integer.valueOf(br.readLine());
			String input = br.readLine();
			br.close();
		
			String[] array = input.replaceAll("1$|^1", "").split("1");
			int max = -1;
			int max2 = -1;
			int min = 999999;
			bend[0] = (input.charAt(0) == '0') ? array[0].length() : -1;
			bend[1] = (input.charAt(input.length()-1) == '0') ? array[array.length-1].length() : -1;
			for(int i = 0; i < array.length; i++) {
				
				String current = array[i];
				if(current.length() > max) {
					max2 = max;
					max = current.length();
				}
				else {
					max2 = Math.max(max2, current.length());
				}
				if(i == 0 && bend[0] >= 0) {
					continue;
				}
				if(i == array.length-1 && bend[1] >=0) {
					continue;
				}
				min = Math.min(min, current.length());
			}
			int answer = -1;
			if((max >= 2*min+1 && max2 >= 2*min+1) || max >= 3*min+2) {
				pw.println(min+1);
				pw.close();
				System.exit(0);
			}
			ArrayList<Integer> testValues = new ArrayList<Integer>();
			testValues.add(max);
			testValues.add(max2);
			
			testValues.remove(testValues.indexOf(max));
			int[] result = cowDivision(max);
			for(int res : result) {
				testValues.add(res);
			}
			int nextTarget = Collections.max(testValues);
			testValues.remove(testValues.indexOf(nextTarget));
			result = cowDivision(nextTarget);
			for(int res : result) {
				testValues.add(res);
			}
			if(testValues.contains(-1)) {
				testValues.remove(testValues.indexOf(-1));
			}
			int min2 = Collections.min(testValues);
			
			int poss1 = Math.min(min, min2);
			
			//4 Division
			testValues = new ArrayList<Integer>();
			testValues.add(max);
			testValues.add(max2);
			testValues.remove(testValues.indexOf(max));
			result = cowDivision4(max);
			for(int res : result) {
				testValues.add(res);
			}
			if(testValues.contains(-1)) {
				testValues.remove(testValues.indexOf(-1));
			}
			int min3 = Collections.min(testValues);
			int poss2 = Math.min(min3, min);
			
			 answer = Math.max(poss1, poss2);
			 pw.println(answer+1);
			 pw.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static int[] cowDivision(int num) {
		
		if(bend[0] == num) {
			int halfValue = num/2;
			bend[0] = -1;
			//return new int[] {halfValue};
			return new int[] {num-1};
		}
		if(bend[1] == num) {
			int halfValue = num/2;
			bend[1] = -1;
			//return new int[] {halfValue};
			return new int[] {num-1};
		}
		
		if(num % 2 == 1) {
			int halfValue = num/2;
			return new int[]{halfValue, halfValue};
		}
		else {
			int halfValue = num/2;
			return new int[] {halfValue, halfValue-1};
		}
	}
	private static int[] cowDivision4(int num) {
		if(num < 4) {
			return new int[] {0,0,0};
		}
		int central = (num % 2 == 0) ? num/2 : (num/2)+1;
		int leftover = (num-central)/2;
		if((num-central) % 2 == 0) {
			if(bend[0] == num) {
				bend[0] = -1;
				return new int[] {central, leftover};
			}
			if(bend[1] == num) {
				bend[1] = -1;
				return new int[] {central, leftover};
			}
			return new int[] {leftover, central, leftover};
		}
		else {
			if(bend[0] == num) {
				bend[0] = -1;
				return new int[] {central, leftover+1};
			}
			if(bend[1] == num) {
				bend[1] = -1;
				return new int[] {central, leftover+1};
			}
			return new int[] {leftover, central, leftover+1};
		}
		
	}

}
