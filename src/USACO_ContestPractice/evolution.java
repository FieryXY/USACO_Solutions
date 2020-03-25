package USACO_ContestPractice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 ID: SohanA
 LANG: JAVA
 TASK: evolution
 */
public class evolution {
	public static void main(String[] args) {
		//Map Non-Distributed to Distributed
		HashMap<String, String> populations = new HashMap<String, String>();
		HashMap<String, Integer> traitMap = new HashMap<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
			br.readLine();
			String currentLine = br.readLine();
			while(currentLine != null) {
				List<String> temp = Arrays.asList(currentLine.split(" "));
				temp.remove(0);
				String traits = Arrays.toString(temp.toArray(new String[temp.size()])).replaceAll("\\[|\\]", "").replaceAll(", ", " ");
				
				for(String t : temp) {
					int past = 0;
					if(traitMap.keySet().contains(t)) {
						past = traitMap.get(t);
						traitMap.remove(t);
					}
					past++;
					traitMap.put(t, past);
					
				}
				populations.put(traits, "");
				currentLine = br.readLine();
			}
			br.close();
			while(traitMap.isEmpty() == false) {
				int maximum = 	Collections.max(traitMap.values());
				 String cT = "";
				for(String key : traitMap.keySet()) {
					if(traitMap.get(key) == maximum) {
						cT = key;
						break;
					}
				}
				final String currentTrait = cT;
				String[] traited =populations.keySet().stream().filter(p -> Arrays.asList(p.split(" ")).contains(currentTrait)).toArray(size -> new String[size]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
