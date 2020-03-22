package USACO_Training;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 ID: SohanA
 LANG: JAVA
 TASK: milk2
 */

class Pair {
	Integer beginning;
	Integer end;
	
	Pair(int b, int e) {
		this.beginning = b;
		this.end = e;
	}
}

public class milk2{
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
			int repeats = Integer.valueOf(br.readLine());
			//String initial = br.readLine();
			
			ArrayList<Pair> fullPairs = new ArrayList<Pair>();
			for(int i = 0; i < repeats; i++) {
				String now = br.readLine();
				if(now == null) {
					break;
				}
				now = now.trim();
				int begin = Integer.valueOf(now.split(" ")[0]);
				int end = Integer.valueOf(now.split(" ")[1]);
				fullPairs.add(new Pair(begin, end));
			}
			
			Pair[] sortedPairs = fullPairs.stream().sorted((o1,o2) -> o1.beginning.compareTo(o2.beginning)).toArray(Pair[]::new);
			int currentBegin = sortedPairs[0].beginning;
			int currentEnd = sortedPairs[0].end;
			int longestCont = 0;
			
			fullPairs = new ArrayList<Pair>();
			
			for(Pair pair : sortedPairs) {
				int begin = pair.beginning;
				int end = pair.end;
				if(begin <= currentEnd) {
					currentBegin = (currentBegin < begin) ? currentBegin : begin;
					currentEnd = (currentEnd > end) ? currentEnd : end;
				}
				else {
					longestCont = (longestCont > (currentEnd-currentBegin)) ? longestCont : currentEnd-currentBegin;
					fullPairs.add(new Pair(currentBegin, currentEnd));
					currentBegin = begin;
					currentEnd = end;
					 
				}
			}
			longestCont = (longestCont > (currentEnd-currentBegin)) ? longestCont : currentEnd-currentBegin;
			fullPairs.add(new Pair(currentBegin, currentEnd));
			
			
			
			int longestIdle = 0;
			
			for(int i = 0; i < fullPairs.size()-1; i++) {
				int idle = fullPairs.get(i+1).beginning-fullPairs.get(i).end;
				longestIdle = (longestIdle > idle) ? longestIdle : idle;
			}
			
			br.close();
			System.out.println(longestCont);
			PrintWriter pw = new PrintWriter(new FileWriter("milk2.out", true));
			pw.println(String.valueOf(longestCont)+" "+String.valueOf(longestIdle));
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


