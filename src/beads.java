import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 ID: SohanA
 LANG: JAVA
 TASK: beads
 */

public class beads {
	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("beads.in"));
			br.readLine();
			String input = br.readLine();
			br.close();
			int answer = daCode(input);
			PrintWriter pw = new PrintWriter(new FileWriter("beads.out"));
			pw.println(answer);
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static int daCode(String test) {
		
		test = test + test;
		
		if(test.replaceAll("[rw]", "").length() == 0 || test.replaceAll("[bw]", "").length() == 0) {
			return test.length() / 2;
		}
		String regex1 = "[bw][rw]";
		String regex2 = "[rw][bw]";
		Pattern pat1 = Pattern.compile(regex1);
		Pattern pat2 = Pattern.compile(regex2);
		Matcher m1 = pat1.matcher(test);
		Matcher m2 = pat2.matcher(test);
		boolean continuing = true;
		ArrayList<Integer> blueStarts = new ArrayList<Integer>();
		ArrayList<Integer> redStarts = new ArrayList<Integer>();
		while(continuing) {
			continuing = false;
			if(m1.find()) {
				blueStarts.add(m1.start());
				continuing = true;
			}
			if(m2.find()) { 
				redStarts.add(m2.start());
				continuing = true;
			}	
		}
		Pattern redp = Pattern.compile("[rw]+");
		Pattern bluep = Pattern.compile("[bw]+");
	
		int largestTotal = 0;
		
		for(int point : blueStarts) {
			int total = 0;
			Matcher redm = redp.matcher(test.substring(point+1, test.length()));
			redm.find();
			total += redm.end()-redm.start();
			Matcher bluem = bluep.matcher(new StringBuilder(test.substring(0, point+1)).reverse().toString());
			if(bluem.find()) {
			total += bluem.end()-bluem.start();
			}
			largestTotal = (total > largestTotal) ? total : largestTotal;
		}
		for(int point : redStarts) {
			int total = 0;
			Matcher bluem = bluep.matcher(test.substring(point+1, test.length()));
			bluem.find();
			total += bluem.end()-bluem.start();
			Matcher redm = redp.matcher(new StringBuilder(test.substring(0, point+1)).reverse().toString());
			if(redm.find()) {
			total += redm.end()-redm.start();
			}
			largestTotal = (total > largestTotal) ? total : largestTotal;
		}
		
		return (largestTotal <= test.length() / 2) ? largestTotal : test.length() / 2;
	}
}
