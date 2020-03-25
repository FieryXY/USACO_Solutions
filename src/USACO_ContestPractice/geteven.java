package USACO_ContestPractice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 ID: SohanA
 LANG: JAVA
 TASK: geteven
 */
public class geteven {
	static Variable b,e,s,i,g,o,m;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("geteven.in"));
			 b = new Variable();e= new Variable();s= new Variable();i= new Variable();
					g= new Variable();o= new Variable();m= new Variable();
			long allProduct = 1;
			br.readLine();
			String nextLine = br.readLine();
			while(nextLine != null) {
				boolean even = Integer.valueOf(nextLine.split(" ")[1]) % 2 == 0;
				if(even) {
					getVar(nextLine.split(" ")[0]).evens++;
				}
				else {
					getVar(nextLine.split(" ")[0]).odds++;
				}
				nextLine = br.readLine();
			}
			br.close();
			
			allProduct = b.getPT()*e.getPT()*s.getPT()*i.getPT()*g.getPT()*o.getPT()*m.getPT();
			
			
			//Base Expressions
			long baseOne = m.evens;
			long baseTwo = ((b.odds*i.odds)+(b.evens*i.evens));
			long baseThree = ((g.odds*o.odds)+(g.evens*o.evens))*((e.odds*s.odds)+(e.evens*s.evens))
					+ ((g.odds*o.evens)+(g.evens*o.odds))*((e.odds*s.evens)+(e.evens*s.odds));
			
			//Segments
			long segmentOne = baseOne*(allProduct/m.getPT());
			long segmentTwo = baseTwo * (allProduct/(b.getPT()*i.getPT()));
			long segmentThree = baseThree * (allProduct/(g.getPT()*o.getPT()*e.getPT()*s.getPT()));
			long allSegments = segmentOne+segmentTwo+segmentThree;
			
			//Overlaps
			long overlapOne = (baseOne*baseTwo) * (allProduct/(m.getPT()*b.getPT()*i.getPT()));
			long overlapTwo = (baseTwo*baseThree)*(allProduct/(b.getPT()*i.getPT()*g.getPT()*o.getPT()*e.getPT()*s.getPT()));
			long overlapThree = (baseOne*baseThree)*(allProduct/(m.getPT()*g.getPT()*o.getPT()*e.getPT()*s.getPT()));
			long hyperOverlap = (baseOne*baseTwo*baseThree);
			long allOverlap = (overlapOne+overlapTwo+overlapThree) - 2*hyperOverlap;
			
			long answer = allSegments - allOverlap;
			
			System.out.println(answer);
			
			PrintWriter pw = new PrintWriter(new FileWriter("geteven.out", true));
			pw.println(String.valueOf(answer));
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private static Variable getVar(String str) {
		switch(str) {
		case "B":
			return b;
		case "E":
			return e;
		case "S":
			return s;
		case "I":
			return i;
		case "G":
			return g;
		case "O":
			return o;
		case "M":
			return m;
		}
		return null;
	}

}

class Variable {
	int evens = 0;
	int odds = 0;
	
	Variable() {
		
	}
	public long getPT() {
		return evens+odds;
	}
}
