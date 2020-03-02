package USACO_ContestPractice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MilkFactory {
	
	static Station[] stations;
	
	public static void main(String[] args) {
		constructTree();
	}
	
	private static void constructTree() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("factory.in"));
			int size = Integer.valueOf(br.readLine());
			
			stations = new Station[size];
			
			stations = Arrays.stream(stations).map(s -> new Station()).toArray(Station[]::new);
			
			String currentLine = br.readLine();
			while(currentLine != null) {
				int a = Integer.valueOf(currentLine.split(" ")[0]);
				int b = Integer.valueOf(currentLine.split(" ")[1]);
				stations[a-1].parents.add(stations[b-1]);
				stations[b-1].children.add(stations[a-1]);
				currentLine = br.readLine();
			}
			int answer = -1;
			int index = 0;
			for(Station st : stations) {
				Station[] bleh = recursiveChildrenCheck(size, st, new Station[size]);
				boolean isTrue = Arrays.stream(recursiveChildrenCheck(size, st, new Station[size]))
						.filter(s -> s != null).collect(Collectors.toList()).size() == size-1;
				if(isTrue) {
					answer = index+1;
					break;
				}
				index++;
			}
			PrintWriter pw = new PrintWriter(new FileWriter("factory.out", true));
			pw.print(String.valueOf(answer));
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
	
	private static Station[] recursiveChildrenCheck(int size, Station s, Station[] checklist) {
		
		for(Station child : s.children) {
			int index = Arrays.asList(stations).indexOf(child);
			if(checklist[index] == null) {
				checklist[index] = child;
				checklist = recursiveChildrenCheck(size, child, checklist);
			}
		}
		
		
		return checklist;
	}
}



class Station {
	ArrayList<Station> parents = new ArrayList<Station>();
	ArrayList<Station> children = new ArrayList<Station>();
	
	public Station() {
		//Nothing for Now
	}
	
}
