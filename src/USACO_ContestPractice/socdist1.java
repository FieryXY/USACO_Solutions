package USACO_ContestPractice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
				min = Math.min(min, current.length());
			}
			
//			bend.add(array[0].length());
//			bend.add(array[array.length-1].length());
//			
//			int max = Arrays.asList(array).stream().max(Comparator.comparingInt(String::length)).get().length();
//			int max2 = -1;
//			int min = Arrays.asList(array).stream().min(Comparator.comparingInt(String::length)).get().length();
			
//			for(int i = 0; i < N; i++) {
//				char current = input.charAt(i);
//				if(current == '1') {
//					if(i == 0) {continue;}
//					 min = Math.min(currentClusterCount, min);
//					 if(currentClusterCount > max) {
//						 max2 = max;
//						 max = currentClusterCount;
//					 }
//					 else {
//						 max2 = Math.max(currentClusterCount, max2);
//					 }
//					 
//					currentClusterCount = 0;
//				}
//				else if(current == '0') {
//					if(i == N-1) {
//						continue;
//					}
//					currentClusterCount++;
//				}
//			}
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
			
			int answer = Math.min(min, min2);
			
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
			return new int[] {halfValue};
		}
		if(bend[1] == num) {
			int halfValue = num/2;
			bend[1] = -1;
			return new int[] {halfValue};
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
}
