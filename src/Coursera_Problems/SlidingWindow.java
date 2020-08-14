package Coursera_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {
	
	
	private static int[] a;
	private static int m;
	
	
	
	private static void readInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			a = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			m = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	private static int[] solve() {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		Deque<Integer> aq = new LinkedList<Integer>();
		
		
		int[] returned = new int[a.length-m+1];
		
		
		for(int i = 0; i < a.length; i++) {
			q.add(a[i]);
			if(q.size() == m) {
				
			}
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		readInput();
	}
}


class MaxQueue {
	Queue<Integer> q = new LinkedList<Integer>();
	Deque<Integer> aq = new LinkedList<Integer>();
}
