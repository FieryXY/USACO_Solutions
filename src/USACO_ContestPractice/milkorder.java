package USACO_ContestPractice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.IntStream;

/*
 ID: SohanA
 LANG: JAVA
 TASK: milkorder
 */
public class milkorder {
	static ArrayList<Integer> ks = new ArrayList<Integer>();
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
			String variables = br.readLine();
			int n = Integer.valueOf(variables.split(" ")[0]);
			int[] cowSim = new int[n];
			//int m = Integer.valueOf(variables.split(" ")[1]);
			int k = Integer.valueOf(variables.split(" ")[2]);
			String mInput = br.readLine();
			Stack<Integer> mCows = new Stack<Integer>();
			for(String cow : mInput.split(" ")) {
				mCows.push(Integer.valueOf(cow));
			}
			String nextLine = br.readLine();
			while(nextLine != null) {
				ks.add(Integer.valueOf(nextLine.split(" ")[0]));
				cowSim[Integer.valueOf(nextLine.split(" ")[1])-1] = Integer.valueOf(nextLine.split(" ")[0]);
				nextLine = br.readLine();
			}
			cowSim = doHierarchy(cowSim, mCows);
			
			int cowOneSpace = -1;
			int zero = -1;
			int one = -1;
			for(int i = 0; i < cowSim.length; i++) {
				if(cowSim[i] == 0 && zero < 0) {
					zero = i;
				}
				if(cowSim[i] == 1) {
					one = i;
					break;
				}
			}
			cowOneSpace = (one >= 0) ? one : zero;
			boolean zeroing = false;
			int zeroes = 0;
			for(int i = one; i >= 0; i --) {
				final int currentT = cowSim[i];
				if(!zeroing && ks.stream().anyMatch(aK -> aK == currentT)) {
					break;
				}
				if(cowSim[i] == 0) {
					if(zeroing == false) {
						zeroing = true;
					}
					zeroes++;
				}
				if(zeroing && cowSim[i] != 0) {
					break;
				}
			}
			cowOneSpace = cowOneSpace - zeroes;
			PrintWriter pw = new PrintWriter(new FileWriter("milkorder.out"));
			pw.println(String.valueOf(cowOneSpace+1));
			pw.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static int[] doHierarchy(int[] cowSim, Stack<Integer> mCows) {
		try {
			Integer lastPop = -1;
			Integer popped = mCows.pop();
			while(popped != null) {
				final int lastCow = lastPop.intValue();
				final int currentCow = popped.intValue();
				if(Arrays.stream(cowSim).anyMatch(i -> i == currentCow)) {
					lastPop = currentCow;
					popped = mCows.pop();
					continue;
				}
				int startFrom = cowSim.length-1;
				if(lastPop >= 0) {
					startFrom = IntStream.range(0, cowSim.length)
							.filter(i -> cowSim[i] == lastCow).findFirst().orElse(-1);
				}
			
					cowSim[getFreeIndex(cowSim, startFrom)] = currentCow;
				
				
				
				lastPop = currentCow;
				popped = mCows.pop();
			}
		}
		catch(EmptyStackException e) {
			
		}
		
		return cowSim;
	}
	
	private static int getFreeIndex(int[] arr, int sF) {
		for(int i = sF; i >= 0; i--) {
			if(arr[i] == 0) {
				return i;
			}
		}
		return -1;
	}
//	private static int getOneIndex(int[] arr, int sF, int stackLength) {
//		for(int i = stackLength+1; i <= sF; i++) {
//			if(arr[i] == 0) {
//				return i;
//			}
//		}
//		return -1;
//	}
}
