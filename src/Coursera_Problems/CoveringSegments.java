package Coursera_Problems;
import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.function.Predicate;

public class CoveringSegments {

    private static Integer[] optimalPoints(Segment[] segments) {
        //write your code here
       
    	//List<Segment> leftSort = Arrays.asList(segments);
    	List<Segment> rightSort =  new ArrayList<Segment>(Arrays.asList(segments));
    	
    	
    	
    	//leftSort.sort((s1, s2) -> (s1.start < s2.start) ? -1 : 1 );
    	rightSort.sort((s1, s2) -> (s1.end < s2.end) ? -1 : 1 );
    	

    	
    	ArrayList<Integer> points = new ArrayList<Integer>();
    	
    	while(rightSort.size() > 0) {
    		int currentEnd = rightSort.get(0).end;
    		rightSort.remove(0);
    		points.add(currentEnd);
    		for(int i = rightSort.size()-1; i >= 0; i--) {
    			if(rightSort.get(i).start <= currentEnd) {
    				rightSort.remove(i);
    			}
    		}
    		
    	}
    	
    
    	
    	return points.toArray(new Integer[points.size()]);
    }
    
//    private static Segment[] sortSegments(Segment[] segs, Predicate<Segment> pred) {
//    	if(segs.length == 1) {
//    		return segs;
//    	}
//    	
//    	Segment[] left = sortSegments(Arrays.copyOfRange(segs, 0, segs.length/2),pred);
//    	Segment[] right = sortSegments(Arrays.copyOfRange(segs, segs.length/2, segs.length),pred);
//    	
//    	int leftPtr = 0, rightPtr = 0, newPtr = 0;
//    	
//    	
//    	
//    	
//    	return null;
//    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        Integer[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
