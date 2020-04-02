import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

/*
 ID: SohanA
 LANG: JAVA
 TASK: tracing
 */
public class tracing {	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
			PrintWriter pw = new PrintWriter(new FileWriter("tracing.out", true));
			int T = Integer.valueOf(br.readLine().split(" ")[1]);
			String infected = br.readLine();
			TreeMap<Integer, String> videotape = new TreeMap<Integer, String>();
			for(int i = 0; i < T; i++) {
				String line = br.readLine();
				int key = Integer.valueOf(line.split(" ")[0]);
				line = line.replaceAll("^[0-9]+ ", "");
				videotape.put(key, line);
			}
			
			
		}
		catch(FileNotFoundException e) {
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
