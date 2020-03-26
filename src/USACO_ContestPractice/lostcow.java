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
 TASK: lostcow
 */
public class lostcow {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
			String input = br.readLine();
			br.close();
			int x = Integer.valueOf(input.split(" ")[0]);
			int y = Integer.valueOf(input.split(" ")[1]);
			double d = Math.abs(x-y);
			double logger = Math.log(d)/Math.log(2);
			int L = (logger % 1 == 0) ? (int) logger : (int) logger+1;
			
			if(y>x && L%2 ==1) {
				L++;
			}
			if(y<x && L%2 == 0) {
				L++;
			}
			
//			double last = 3;
//			int i = 1;
//			
//			while(i < L) {
//				i++;
//				last = last+(3*(Math.pow(2, i-1)));
//			}
		double sum = 4;
		double last = 2;
		double current = 4;
		int exponent = 1;
		while(exponent != L) {
			sum += last;
			sum += current;
			last = current;
			current *= 2;
			exponent++;
		}
		
		sum -= (Math.pow(2, L)) - d;
		
			PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out", true));
			pw.println((int) sum);
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
