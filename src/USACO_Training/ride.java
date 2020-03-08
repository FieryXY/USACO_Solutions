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
 TASK: ride
 */


public class ride {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("ride.in"));
			String cometName = br.readLine();
			String groupName = br.readLine();
			br.close();
			
			double cometNumber = (double) cometName.toLowerCase().chars().map((n) -> n-96).reduce((s,n) -> s*n).getAsInt();
			double groupNumber = (double) groupName.toLowerCase().chars().map((n) -> n-96).reduce((s,n) -> s*n).getAsInt();
			
			PrintWriter pw = new PrintWriter(new FileWriter("ride.out", true));
			if(cometNumber % 47 == groupNumber % 47) {
				pw.println("GO");
			}
			else {
				pw.println("STAY");
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
