package USACO_Training;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

/*
 ID: SohanA
 LANG: JAVA
 TASK: namenum
 */

public class namenum {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
			HashMap<String, String> names = new HashMap<String, String>();
			String nextLine = br.readLine();
			while(nextLine != null) {
				String num = getNumber(nextLine);
				if(names.keySet().contains(num)) {
					String current = names.get(num);
					names.remove(num);
					names.put(num, current+","+nextLine);
				}
				else {
					names.put(num, nextLine);
				}
				
				nextLine = br.readLine();
			}
			br.close();
			
			BufferedReader br1 = new BufferedReader(new FileReader("namenum.in"));
			String requestedNumber = br1.readLine();
			
			br1.close();
			String possibilities = names.get(requestedNumber);
			if(possibilities == null) {
				PrintWriter none = new PrintWriter(new FileWriter("namenum.out"));
				none.println("NONE");
				none.close();
				System.exit(0);
			}
			String[] asArray = possibilities.split(",");
			Arrays.sort(asArray, String.CASE_INSENSITIVE_ORDER);
			String answer = Arrays.toString(asArray).replace("[", "").replace("]", "").replaceAll(", ", "\n");
			PrintWriter pw = new PrintWriter(new FileWriter("namenum.out"));
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
	
	private static String getNumber(String name) {
		return name.replaceAll("[ABC]", "2").replaceAll("[DEF]", "3").replaceAll("[GHI]", "4")
			.replaceAll("[JKL]", "5").replaceAll("[MNO]", "6").replaceAll("[PRS]", "7")
			.replaceAll("[TUV]", "8").replaceAll("[WXY]", "9");
	}
}
