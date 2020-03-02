package USACO_ContestPractice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTree {

	
	public static void main(String[] args) {
		//Tree Construction
		try {
			BufferedReader br = new BufferedReader(new FileReader("family.in"));
			HashMap<String, Cow> cows = new HashMap<String, Cow>();
			String firstLine = br.readLine();
			String host = firstLine.split(" ")[1];
			String target = firstLine.split(" ")[2];
			String currentLine = br.readLine();
			while(currentLine != null) {
				String tempHost = currentLine.split(" ")[0];
				String tempTarget = currentLine.split(" ")[1];
				if(!(cows.keySet().contains(tempHost))) cows.put(tempHost, new Cow(tempHost));
				if(!(cows.keySet().contains(tempTarget))) cows.put(tempTarget, new Cow(tempTarget));
				cows.get(tempHost).children.add(cows.get(tempTarget));
				cows.get(tempTarget).parent = cows.get(tempHost);
				currentLine = br.readLine();
			}
			br.close();
			//Check for Aunts, Mothers, and Sisters
			String result = doubleColumnSearch(cows.get(host), cows.get(target));
			if(!(result.equals("Fail"))) {
				returnValue(target +
						" is the "+generateReturnVal(result) + " of "+host);
			}
			else {
				if(isCousin(cows.get(host), cows.get(target))) {
					returnValue("COUSINS");
				}
				else {
					returnValue("NOT RELATED");
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void returnValue(String value) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("family.out", true));
			pw.print(value);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	private static boolean isCousin(Cow host, Cow target) {
		
		Cow ultraParent = host.parent;
		while(ultraParent != null) {
			if(ultraParent.parent != null) {
				ultraParent = ultraParent.parent;
			}
			else {
				break;
			}
		}
		
		
		return recursiveCheck(ultraParent, target);
	}
	private static boolean recursiveCheck(Cow host, Cow target) {
		
		boolean returnVal = host.children.contains(target);
		if(!returnVal) {
			for(Cow child : host.children) {
				if(recursiveCheck(child, target)) {
					returnVal = true;
					break;
				}
			}
		}
		
		return returnVal;
	}
	
	private static String doubleColumnSearch(Cow host, Cow target) {
		Cow nextParent = host.parent;
		int genGap = 1;
		while(nextParent != null) {
			if(nextParent.name.equals(target.name)) {
				return String.valueOf(genGap) + " " + "true";
			}
			else if(nextParent.children.contains(target)) {
				return String.valueOf(genGap-1) + " " + "false";
			}
			
			
			genGap++;
			nextParent = nextParent.parent;
		}
		return "Fail";
	}
	
	private static String generateReturnVal(String dcResult) {
		
		int genGap = Integer.valueOf(dcResult.split(" ")[0]);
		boolean isDirect = dcResult.split(" ")[1].equals("true");
		if(!isDirect && genGap == 0) {
			returnValue("SIBLINGS");
			return "sibling";
		}
		else if(isDirect && genGap == 1) {
			return "mother";
		}
		else if(isDirect) {
			return new String(new char[genGap-2]).replaceAll("\0", "great-")+"grand-mother";
		}
		else {
			return new String(new char[genGap-1]).replaceAll("\0", "great-")+"aunt";
		}
		
		
	}

}

class Cow {
	String name;
	Cow parent;
	ArrayList<Cow> children;
	Cow(String n) {
		this.name = n;
		children = new ArrayList<Cow>();
	}
}
