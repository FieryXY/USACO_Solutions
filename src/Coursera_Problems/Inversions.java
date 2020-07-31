package Coursera_Problems;
import java.io.ByteArrayInputStream;
import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        
        int[] originalLeft = Arrays.copyOfRange(a, left, ave);
        int[] originalRight = Arrays.copyOfRange(a, ave, right);
        
        int i = left, l = 0, r = 0;
        
        
        
        while(i < right) {
        	int nextLeft = (l < originalLeft.length) ? originalLeft[l] : Integer.MAX_VALUE;
        	int nextRight = (r < originalRight.length) ? originalRight[r] : Integer.MAX_VALUE;
        	
//        	if(nextLeft < 0) {
//        		a[i] = nextRight;
//        		i++;
//        		r++;
//        		continue;
//        	}
//        	else if(nextRight < 0) {
//        		a[i] = nextLeft;
//        		i++;
//        		l++;
//        		numberOfInversions += originalRight.length;
//        		continue;
//        	}
        	
        	if(nextLeft <= nextRight) {
        		a[i] = nextLeft;
        		i++;
        		l++;
        	}
        	else if(nextRight < nextLeft) {
        		numberOfInversions += originalLeft.length-l;
        		a[i] = nextRight;
        		i++;
        		r++;
        	}
        }
        

        
        return numberOfInversions;
    }
    
    
    
    

    public static void main(String[] args) {
//    	String toPutIn = "6\n9 8 7 3 2 1";
//    	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

