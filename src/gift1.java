import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/*
ID: SohanA
LANG: JAVA
TASK: gift1
*/

public class gift1 {
	static LinkedHashMap<String, Integer> accounts = new LinkedHashMap<String, Integer>();
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
			int count = Integer.valueOf(br.readLine());
			
			String[] nameOrder = new String[count];
			//Create Accounts
			for (int i = 0; i < count; i++) {
				String name = br.readLine();
				accounts.put(name, 0);
				nameOrder[i] = name;
			}
			for(int i = 0; i < count; i++) {
				String hostAccount = br.readLine();
				String stats = br.readLine();
				int money = Integer.valueOf(stats.split(" ")[0]);
				int rCount = Integer.valueOf(stats.split(" ")[1]);
				if(rCount <= 0) {continue;}
				int newHostValue = accounts.get(hostAccount)-money+(money%rCount);
				accounts.remove(hostAccount);
				accounts.put(hostAccount, newHostValue);
				int giftValue = money / rCount;
				for(int j = 0; j < rCount; j++) {
					String receipent = br.readLine();
					int newRValue = accounts.get(receipent)+giftValue;
					accounts.remove(receipent);
					accounts.put(receipent, newRValue);
				}
				
			}
			br.close();
			String outputValue = "";
			for(String name : nameOrder) {
				outputValue += name + " " + accounts.get(name) + "\n";				
			}
			//outputValue = outputValue.substring(0, outputValue.length()-1);
			PrintWriter pw = new PrintWriter(new FileWriter("gift1.out", true));
			pw.print(outputValue);
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
