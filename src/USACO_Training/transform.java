package USACO_Training;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 ID: SohanA
 LANG: JAVA
 TASK: transform
 */

public class transform {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("transform.in"));
			int dimension = Integer.valueOf(br.readLine());
			char[][] initial = new char[dimension][dimension];
			char[][] expected = new char[dimension][dimension];
			for(int i = 0; i < dimension; i++) {
				initial[i] = br.readLine().toCharArray();
			}
			for(int i = 0; i < dimension; i++) {
				expected[i] = br.readLine().toCharArray();
			}
			
		
			
			if( rotationCheck(dimension, initial, expected) > 0 ) {
				returnAnswer(String.valueOf(rotationCheck(dimension, initial, expected)));
			}
			
			char[][] reflected = new char[dimension][dimension];
			
			for(int i = 0; i < dimension; i++) {
				for(int j = 0; j < dimension; j++) {
					reflected[i][(dimension-1)-j] = initial[i][j];
				}
			}
			if( areEqual(reflected, expected) ) {
				returnAnswer("4");
			}
			
			if( rotationCheck(dimension, reflected, expected) > 0 ) {
				returnAnswer("5");
			}
			if( areEqual(initial, expected) ) {
				returnAnswer("6");
			}
			
			returnAnswer("7");
			
			
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
	
	private static int rotationCheck(int dimension, final char[][] initial, final char[][] result) {
		
		char[][] one = new char[dimension][dimension];
		char[][] two = new char[dimension][dimension];
		char[][] three = new char[dimension][dimension];

		for(int i = 0; i < dimension; i++) {
			for(int j = 0; j < dimension; j++) {
				three[(dimension-1)-j][i] = initial[i][j];
				two[(dimension-1)-i][(dimension-1)-j] = initial[i][j];
				one[j][-1*i + (dimension-1)] = initial[i][j];
			}
		}
		
		if( areEqual(result, one) ) {
			return 1;
		}
		if( areEqual(result, two) ) {
			return 2;
		}
		if( areEqual(result, three) ) {
			return 3;
		}
		
		return 0;
	}
	
	private static boolean areEqual(char[][] a, char[][] b) {
		if(!(a.length == b.length)) {
			return false;
		}
		for(int i = 0; i < a.length; i++) {
			if(!(Arrays.equals(a[i], b[i]))) {
				return false;
			}
		}
		return true;
	}
	
	private static void returnAnswer(String answer) throws IOException {
			PrintWriter pw = new PrintWriter(new FileWriter("transform.out"));
			pw.println(answer);
			pw.close();
			System.exit(0);
	}
}
