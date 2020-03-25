package USACO_Training;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 ID: SohanA
 LANG: JAVA
 TASK: palsquare
 */

public class palsquare {
	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("palsquare.in"));
			int base = Integer.valueOf(br.readLine());
			br.close();
			PrintWriter pw = new PrintWriter(new FileWriter("palsquare.out", true));
			for(int i = 1; i <= 300; i++) {
				String converted = baseConvert((int) Math.pow(i, 2), base);
				if(converted.equals(new StringBuilder(converted).reverse().toString())) {
					pw.println(baseConvert(i, base) + " " + converted);
				}
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	private static String baseConvert(int num, int base) {
		int remainder = num;
		String answer = "";
		int startingFrom = (int) (Math.log(num)/Math.log(base));
		for(int i = startingFrom; i >= 0; i--) {
			int divisor = (int) Math.pow(base, i);
			int nextDigit = remainder/divisor;
			String nD = String.valueOf(nextDigit);
			if(nextDigit > 9) {
				nD = String.valueOf(alphabet[nextDigit-10]).toUpperCase();
			}
			answer += nD;
			remainder = remainder % divisor;
		}
		
		return answer;
	}
}
