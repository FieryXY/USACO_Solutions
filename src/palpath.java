import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 ID: SohanA
 LANG: JAVA
 TASK: palpath
 */
public class palpath {
	public static char[][] field;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("palpath.in"));
			int N = Integer.valueOf(br.readLine());
			field = new char[N][N];
			for(int i = 0; i < N; i++) {
				field[i] = br.readLine().toCharArray();
			}
			br.close();
			if(field[0][0] != field[N-1][N-1]) {
				returnValue(0);
			}
		
			List<Possibility> posses = new ArrayList<Possibility>();
			List<Possibility> toAdd = new ArrayList<Possibility>();
			List<String> answers = new ArrayList<String>();
			posses.add(new Possibility(0,0,N-1,N-1,String.valueOf(field[0][0]), String.valueOf(field[N-1][N-1])));
			while(posses.size() != 0) {
				for(Possibility p : posses) {
					List<Possibility> possibs = p.test();
					toAdd.addAll(possibs);
					if(p.isComplete()) {
						if(!answers.contains(p.one+p.two)) {
							answers.add(p.one+p.two);
						}
					}
					
				}
				posses = toAdd;
				toAdd = new ArrayList<Possibility>();
			}
			returnValue(answers.size());
			
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
	
	private static void returnValue(int value) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("palpath.out", true));
			pw.println(String.valueOf(value));
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Possibility {
	int x1, y1, x2, y2;
	String one, two;
	Possibility(int x1, int y1, int x2, int y2, String one, String two) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.one = one;
		this.two = two;
	}
	public List<Possibility> test() {
		char[] onePoss = new char[] { (y1+1 < palpath.field.length) ? palpath.field[y1+1][x1] : ' ', (x1+1 < palpath.field.length) ? palpath.field[y1][x1+1] : ' '};
		char[] twoPoss = new char[] {(y2-1 >= 0) ? palpath.field[y2-1][x2] : ' ', (x2-1 >= 0) ? palpath.field[y2][x2-1] : ' '};
		List<Possibility> children = new ArrayList<Possibility>();
			
		for(int i = 0; i < onePoss.length; i++) {
			for(int j = 0; j < twoPoss.length; j++) {
				if(onePoss[i] == ' ' || twoPoss[j] == ' ') {
					continue;
				}
				String oneTest = one + String.valueOf(onePoss[i]);
				String twoTest = String.valueOf(twoPoss[j]) + two;
				String finalTest = oneTest + twoTest;
				if(finalTest.equals(new StringBuilder(finalTest).reverse().toString())) {
					children.add(new Possibility((i == 0) ? x1 : x1+1, (i==0) ? y1+1 : y1, (j == 0) ? x2 : x2-1,
							(j==0) ? y2-1 : y2, oneTest, twoTest));
				}
			}
		}
		
		return children;
	}
	public boolean isComplete() {
		return (x1 == x2 && y1 == y2);
	}
}
