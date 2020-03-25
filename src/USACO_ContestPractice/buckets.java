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
 TASK: buckets
 */
public class buckets {
	public static void main(String[] args) {
		try {
			int[] b = null, r = null, l = null;
			BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
			String currentLine = br.readLine();
			int height = 0;
			while(currentLine != null) {
				 b = (currentLine.contains("B")) ? new int[] {currentLine.indexOf("B"), height} : b;
				 r = (currentLine.contains("R")) ? new int[] {currentLine.indexOf("R"), height} : r;
				 l = (currentLine.contains("L")) ? new int[] {currentLine.indexOf("L"), height} : l;
				height++;
				currentLine = br.readLine();
				
			}
			if(b == null || r == null || l == null) {
				throw new IOException();
			}
			int heightDifference = Math.abs(l[1]-b[1]);
			int widthDifference = Math.abs(l[0]-b[0]);
			int answer = heightDifference+widthDifference-1;
			PrintWriter pw = new PrintWriter(new FileWriter("buckets.out", true));
			pw.println(answer);
			pw.close();
			}
			catch(FileNotFoundException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
