package Coursera_Problems;
import java.util.*;
import java.util.Scanner;

public class PointsAndSegments {

	
	
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        
        List<Point> list = new ArrayList<Point>();
        
        Comparator<Point> c = new Comparator<Point>() {
        	
        	public int compare(Point p1, Point p2) {
        		return p1.location.compareTo(p2.location);
        	}
        	
        };
        
        for(int i = 0; i < starts.length; i++) {
        	Point newPoint = new Point("L", starts[i]);
        	int index = Collections.binarySearch(list, newPoint, c);
        	if(index < 0) index = (index+1)*-1;
        	list.add(index, newPoint);
        }
        for(int i = 0; i < ends.length; i++) {
        	Point newPoint = new Point("R", starts[i]);
        	int index = Collections.binarySearch(list, newPoint, c);
        	if(index < 0) index = (index+1)*-1;
        	list.add(index, newPoint);
        }
        for(int i = 0; i < points.length; i++) {
        	Point newPoint = new Point("P", starts[i]);
        	int index = Collections.binarySearch(list, newPoint, c);
        	if(index < 0) index = (index+1)*-1;
        	list.add(index, newPoint);
        }
        
        
       for(int i = 0; i < list.size(); i++) {
    	   
       }
        
        
        
        
        
        
        
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
    
	
}

class Point {
	String type;
	Integer location;
	Point(String t, int l) {
		this.type = t;
		this.location = l;
	}
}

