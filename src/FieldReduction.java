import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FieldReduction {
	
	static int[] xVals;
	static int[] yVals;
	
	public static void main(String[] args) {
		getInput();
		int xAverage = (int) Arrays.stream(xVals).average().getAsDouble();
		int yAverage = (int) Arrays.stream(yVals).average().getAsDouble();
		int xOutlier = IntStream.range(0, xVals.length)
			.reduce(0, (current, underdog) -> (Math.abs(xAverage - xVals[current]) > Math.abs(xAverage - xVals[underdog])) ? current : underdog);
		int yOutlier = IntStream.range(0, yVals.length)
				.reduce(0, (current, underdog) -> (Math.abs(yAverage - yVals[current]) > Math.abs(yAverage - yVals[underdog])) ? current : underdog);
		int xOutlierDifference = Math.abs(xAverage - xVals[xOutlier]);
		int yOutlierDifference = Math.abs(yAverage - yVals[yOutlier]);
		int outlierIndex = (xOutlierDifference > yOutlierDifference) ? xOutlier : yOutlier;
		output(String.valueOf(calculateArea(new ArrayList<Integer>(Arrays.stream(xVals).boxed().collect(Collectors.toList())), 
				new ArrayList<Integer>(Arrays.stream(yVals).boxed().collect(Collectors.toList())), outlierIndex)));
	}
	
	private static int calculateArea(ArrayList<Integer> xS, ArrayList<Integer> yS, int outlierIndex) {
		xS.remove(outlierIndex);
		yS.remove(outlierIndex);
		IntStream x = xS.stream().mapToInt(i -> i);
		IntStream y = yS.stream().mapToInt(i -> i);
		
		return (xS.stream().mapToInt(i -> i).max().getAsInt()-xS.stream().mapToInt(i -> i).min().getAsInt()) * (yS.stream().mapToInt(i -> i).max().getAsInt()-yS.stream().mapToInt(i -> i).min().getAsInt());
	}
	
	private static void getInput() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
			int cowCount = Integer.valueOf(br.readLine());
			xVals = new int[cowCount];
			yVals = new int[cowCount];
			String cr = br.readLine();
			int currentInd = 0;
			while(cr != null) {	
				xVals[currentInd] = Integer.valueOf(cr.split(" ")[0]);
				yVals[currentInd] = Integer.valueOf(cr.split(" ")[1]);
				currentInd++;
				cr = br.readLine();
			}
			
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
	
	private static void output(String o) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("reduce.out", true));
			pw.print(o);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
