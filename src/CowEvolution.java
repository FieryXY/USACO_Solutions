import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CowEvolution {

	
	static HashMap<String, String> reqs;
	static HashMap<String, String> possibleReqs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reqs = new HashMap<String, String>();
		possibleReqs = new HashMap<String, String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
			br.readLine();
			String current = br.readLine();
			while(current != null) {
				String[] bleh = current.split(" ");
				ArrayList<String>words = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(bleh, 1, bleh.length)));
				int deepestLength = -1;
				String deepest = "";
				for(String word : words) {
					if(reqs.keySet().contains(word)) {
						if(reqs.get(word).split(" ").length > deepestLength) {
							deepestLength = reqs.get(word).split(" ").length;
							deepest = word;
						}
						for(String r : reqs.get(word).split(" ")) {
							if(r.equals("")) continue;
							if(!(words.contains(r))) {
								returnValue(false);
							}
						}
//						String[] intersection = words.stream().filter(w -> Arrays.asList(possibleReqs.get(w).split(" ")).contains(w)).toArray(String[]::new);
//						if(intersection.length == 1) {
//							String newReq = reqs.get(word) + " " + intersection[0];
//							reqs.remove(word);
//							reqs.put(word, newReq);
//						}
						words.set(words.indexOf(word), "");
					}
				}
				words.removeAll(Arrays.asList(new String[] {""}));
				String baseReq = (deepestLength == -1) ? "" : reqs.get(deepest)+" "+deepest;
				for(String leftover : words) {
					//baseReq += (" " + deepest).trim();
					//deepest = leftover;
//					if(words.size() > 1) {
//						String possibleReq = Arrays.toString(words.stream().filter(w -> !(w.equals(leftover))).toArray())
//								.replaceAll("{|}", "").replaceAll(", ", " ");
//						possibleReqs.put(leftover, possibleReq);
//					}
					reqs.put(leftover, baseReq);
				}
				
				current = br.readLine();
			}
			returnValue(true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private static void returnValue(boolean returnVal) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("evolution.out", true));
			pw.print((returnVal) ? "yes" : "no");
			pw.close();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
