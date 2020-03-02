package USACO_Bronze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Triangles {
	public static void main(String[] args) {
		FileParser values = new FileParser();
		double largestArea = 0;
		int i = 0;
		int x, y;
		
		while(i < values.fencePostCount) {
			x = values.xVals.remove(i);
			 y = values.yVals.remove(i);
			ArrayList<Integer> xIndices = generateSomeArray(values.xVals, x);
			ArrayList<Integer> yIndices = generateSomeArray(values.yVals, y);
			
			for(int t = 0; t < xIndices.size(); t++) {
				for(int p = 0; p < yIndices.size(); p++) {
					int xI = xIndices.get(t);
					int yI = yIndices.get(p);
					if(xI == yI) {continue;}
					double area = findTriangularArea(values.xVals.get(xI), values.yVals.get(xI),
							values.xVals.get(yI), values.yVals.get(yI));
					if(area > largestArea) {largestArea = area;}
				}
			}
			
			values = new FileParser();
			i++;
			
//			int xIndex = values.xVals.indexOf(x);
//			int yIndex = values.yVals.indexOf(y);
//			if(!(xIndex != -1 && yIndex != -1)) {
//				i++;
//				values = new FileParser();
//				if(i >= values.fencePostCount) {
//					break;
//				}
//				x = values.xVals.remove(i);
//				 y = values.yVals.remove(i);
//				continue;
//			}
			
//			values.xVals.remove(xIndex);
//			values.yVals.remove(xIndex);
//			values.xVals.remove((xIndex < yIndex) ? yIndex-1: yIndex);
//			values.yVals.remove((xIndex < yIndex) ? yIndex-1: yIndex);
		}
		FileParser.returnOutput((int) ((int) 2*largestArea));
		
	}
	private static double findTriangularArea(int x1, int y1, int x2, int y2) {
		return (Math.abs((double) x2- (double) x1)*Math.abs((double) y2- (double) y1))/2;
	}
	private static ArrayList<Integer> generateSomeArray(ArrayList<Integer> arr, int value) {		
		return new ArrayList<Integer>(IntStream.range(0, arr.size()).filter(elem -> arr.get(elem) == value)
				.boxed().collect(Collectors.toList()));
	}
}


class FileParser {	
	static String INPUT_PATH = "triangles.in";
	static String OUTPUT_PATH = "triangles.out";
	
	int fencePostCount;
	ArrayList<Integer> xVals = new ArrayList<Integer>();
	ArrayList<Integer> yVals = new ArrayList<Integer>();
	
	FileParser() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(INPUT_PATH));
			fencePostCount = Integer.valueOf(br.readLine());
			//xVals = new int[fencePostCount];
			//yVals = new int[fencePostCount];
			Pattern pattern = Pattern.compile("(-?[0-9]+) (-?[0-9]+)");
			for(int i = 0; i < fencePostCount; i++) {
				Matcher m = pattern.matcher(br.readLine());
				m.matches();
				xVals.add(Integer.valueOf(m.group(1)));
				yVals.add(Integer.valueOf(m.group(2)));
				//xVals[i] = Integer.valueOf(m.group(1));
				//yVals[i] = Integer.valueOf(m.group(2));
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Initial Input");
			//xVals = new int[0];
			//yVals = new int[0];
			return;
		} catch (IOException e) {
			System.out.println("IOException");
			return;
		}
		
	}
	
	public static void returnOutput(int output) {
		try {
//			PrintStream ps = new PrintStream(OUTPUT_PATH);
//			System.setOut(ps);
//			System.out.println(String.valueOf(output) + "\n");
			 PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH));  //Set true for append mode);  
			 writer.print("");
			 writer.print(String.valueOf(output));
			 //writer.newLine();
			 writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
