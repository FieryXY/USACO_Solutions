package USACO_Bronze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
 ID: SohanA
 LANG: JAVA
 TASK: socdist2
 */
public class socdist2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("socdist2.in"));
			PrintWriter pw = new PrintWriter(new FileWriter("socdist2.out", true));
			int N = Integer.valueOf(br.readLine());
			TreeMap<Integer, Integer> values = new TreeMap<Integer, Integer>();
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				int pos = Integer.valueOf(line.split(" ")[0]);
				int isSick = Integer.valueOf(line.split(" ")[1]);
				values.put(pos, isSick);
			}
			int maxR = 9999999;
			int lastPos = -1;
			int lastHealthyPos = -1;
			boolean getNextPos = false;
			for(Map.Entry<Integer, Integer> entry : values.entrySet()) {
				if(entry.getValue() == 0) {
					if(lastPos >= 0) {
						maxR = Math.min(maxR, entry.getKey()-lastPos);
					}
					getNextPos = true;
					lastPos = -1;
					lastHealthyPos = entry.getKey();
					continue;
				}
				lastPos = entry.getKey();
				if(getNextPos) {
					maxR = Math.min(maxR, entry.getKey()-lastHealthyPos);
				}
			}
			boolean inCluster = false;
			int prePos = -1;
			int answer = 0;
			ArrayList<Integer> notLonely = new ArrayList<Integer>();
			for(Map.Entry<Integer, Integer> entry : values.entrySet()) {
				if(entry.getValue() == 0) {
					notLonely.add(entry.getKey());
				}
				if(inCluster) {
					if(entry.getValue() == 0 || entry.getKey() - prePos >= maxR) {
						inCluster = false;
						answer++;
					}
					notLonely.add(prePos);
				}
				else {
					if(entry.getValue() == 0) {
						continue;
					}
					if(prePos >= 0 && entry.getKey()-prePos < maxR) {
						inCluster = true;
						notLonely.add(prePos);
					}
				}
				prePos = entry.getKey();
			}
			if(inCluster) {
				answer++;
				notLonely.add(-1);
			}
			
			answer += (values.entrySet().size() - notLonely.size());
			
			pw.println(answer);
			br.close();
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
